using NHibernate.Id.Insert;
using NHibernate.Mapping;
using Server.DbConnection;
using Server.DbConnetion;
using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using Autofac;
using HostFleetManager.Interfaces;

namespace Server
{
    public class FleetService : IFleetService
    {
        private static readonly string dbString = "FleetManagement.db";

        private readonly IUserRepository _repositoryUser;//= Program.Container.Resolve<IUserRepository>(new NamedParameter("databaseFile", dbString));
        private readonly IBusinessUnitRepository _repositoryBusinessUnit;// = Program.Container.Resolve<IBusinessUnitRepository>(new NamedParameter("databaseFile", dbString));
        private readonly IEmployeeRepository _repositoryEmployee;// = Program.Container.Resolve<IEmployeeRepository>(new NamedParameter("databaseFile", dbString));
        private readonly IVehicleRepository _repositoryVehicle;// = Program.Container.Resolve<IVehicleRepository>(new NamedParameter("databaseFile", dbString));
        private readonly IVehicleToEmployeeRepository _vehicleToEmployeeRepository;// = Program.Container.Resolve<IVehicleToEmployeeRepository>(new NamedParameter("databaseFile", dbString));

        public FleetService()
        {
            _repositoryUser= Program.Container.Resolve<IUserRepository>(new NamedParameter("databaseFile", dbString));
            _repositoryBusinessUnit = Program.Container.Resolve<IBusinessUnitRepository>(new NamedParameter("databaseFile", dbString));
            _repositoryEmployee = Program.Container.Resolve<IEmployeeRepository>(new NamedParameter("databaseFile", dbString));
            _repositoryVehicle = Program.Container.Resolve<IVehicleRepository>(new NamedParameter("databaseFile", dbString));
            _vehicleToEmployeeRepository = Program.Container.Resolve<IVehicleToEmployeeRepository>(new NamedParameter("databaseFile", dbString));
    }

        //Testing
        public FleetService(IBusinessUnitRepository businessUnits,
                              IVehicleRepository vehicles,
                              IEmployeeRepository employees, 
                              IUserRepository user ,
                              IVehicleToEmployeeRepository vehicleToEmployee)
        {
            _repositoryUser = user;
            _repositoryBusinessUnit = businessUnits;
            _repositoryVehicle = vehicles;
            _repositoryEmployee = employees;
            _vehicleToEmployeeRepository = vehicleToEmployee;
        }

        ////////////////// USER //////////////////

        public User CanUserLogin(string userName, string password)
        {
            var user = _repositoryUser.GetUserFromUsername(userName);
            if (user == null) return null;
            var equals = BCrypt.Net.BCrypt.Verify(password, user.Password);
            if (equals)
            {
                return new User()
                {
                    Id = user.Id,
                    Firstname = user.Firstname,
                    Lastname = user.Lastname,
                    IsAdmin = user.IsAdmin,
                    Username = user.Username
                };
            }
            return null;
        }

        public bool ChangePassword(string username, string oldPassword, string newPassword)
        {
            if (username == null) return false;
            var databasePassword = _repositoryUser.GetPasswordHashFromDb(username);
            if (databasePassword == null) return false;
            try
            {
                var newPasswordHash = BCrypt.Net.BCrypt.ValidateAndReplacePassword(oldPassword, databasePassword, newPassword);
                var user = _repositoryUser.GetUserFromUsername(username);
                _repositoryUser.SetNewPassword(user.Id, newPasswordHash);
            }
            catch
            {
                return false;
            }


            return true;
        }

        public List<User> getAllUsers()
        {
            return _repositoryUser.GetAll();
        }

        public bool AddUser(User user)
        {
            if (user.Username == null || user.Lastname == null || user.Firstname == null) return false;

            //return false if user is already in db - wether it is 
            if (_repositoryUser.GetUserFromUsername(user.Username) != null) return false;

            if (getAllUsers().Find(x => x.Username.ToUpper() == user.Username.ToUpper()) != null) return false;

            //hash pasword and store user
            var passwordHash = BCrypt.Net.BCrypt.HashPassword("geheim");
            user.Password = passwordHash;

            try
            {
                _repositoryUser.Save(user);
            }
            catch
            { return false; }

            //return true if user is in db
            return (_repositoryUser.GetUserFromUsername(user.Username) != null) ? true : false;
        }

        public bool DeleteUser(User user)
        {
            if (user == null) return false;
            if (_repositoryUser.GetUserFromUsername(user.Username) == null) return false;

            try
            { 
                _repositoryUser.Delete(user); 
            }
            catch { return false; }
            

            return (_repositoryUser.GetUserFromUsername(user.Username) == null) ? true : false;
        }

        public bool ChangeUser(User newUser)
        {
            if (newUser?.Version == null) return false;

            if (_repositoryUser.GetUserFromId(newUser.Id) == null) return false;

            //Optimistic Locking 
            if (_repositoryUser.GetUserFromId(newUser.Id).Version > newUser.Version) return false;

            try
            {
            _repositoryUser.Insert(newUser);

            }
            catch
            { return false; }

            return (_repositoryUser.GetUserFromUsername(newUser.Username) != null) ? true : false;
        }

        ////////////////// BUSINESSUNITS ///////////////////
        public List<BusinessUnit> GetAllBusinessUnits()
        {
            return _repositoryBusinessUnit.GetAll();
        }

        public bool AddBusinessUnit(BusinessUnit businessUnit)
        {
            if (businessUnit.Name == null || businessUnit.Name == "") return false;

            if (GetAllBusinessUnits().Find(x => x.Name.ToUpper() == businessUnit.Name.ToUpper()) != null) return false;

            if (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) != null) return false;

            try
            {
            _repositoryBusinessUnit.Save(businessUnit);

            }
            catch
            { return false; }

            return (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) != null) ? true : false;
        }

        public bool DeleteBusinessUnit(BusinessUnit businessUnit)
        {
            if (businessUnit == null) return false;
            if (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) == null) return false;

            try
            {
            _repositoryBusinessUnit.Delete(businessUnit);

            }
            catch
            { return false; }

            return (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) == null) ? true : false;
        }

        public bool ChangeBusinessUnit(BusinessUnit newBusinessUnit)
        {
            if (newBusinessUnit == null) return false;
            if (newBusinessUnit?.Version == null) return false;

            if (newBusinessUnit?.Id == null || newBusinessUnit?.Version == null) return false;
            if (_repositoryBusinessUnit.getUnitFromId(newBusinessUnit.Id) == null) return false;

            //Optimistic Locking 
            if ((_repositoryBusinessUnit.getUnitFromId(newBusinessUnit.Id).Version > newBusinessUnit.Version) ) return false;

            try
            {

            _repositoryBusinessUnit.Insert(newBusinessUnit);
            }
            catch
            { return false; }

            return (_repositoryBusinessUnit.getUnitFromUnitName(newBusinessUnit.Name) != null) ? true : false;
        }

        ////////////////// EMPLOYEES ///////////////////
        public List<Employee> GetAllEmployees()
        {
            return _repositoryEmployee.GetAll();
        }

        public bool AddEmployee(Employee employee)
        {
            if (employee == null) return false;
            if (employee?.EmployeeNumber == null || employee?.FirstName == null || employee?.LastName == null || employee?.BusinessUnitId == null) return false;
            if (_repositoryEmployee.GetEmployeeByEmployeeNumber(employee.EmployeeNumber) != null) return false;

            try
            {
            _repositoryEmployee.Save(employee);

            }
            catch
            { return false; }

            return (_repositoryEmployee.GetEmployeeByEmployeeNumber(employee.EmployeeNumber) != null) ? true : false;
        }

        public bool DeleteEmployee(Employee employee)
        {
            if (_repositoryEmployee.GetEmployee(employee.Id) == null) return false;
            //if (CanRemoveEmployee(employee) == false) return false;

            try
            {
                _repositoryEmployee.Delete(employee);

            }catch
            { return false; }

            return (_repositoryEmployee.GetEmployee(employee.Id) == null) ? true : false;
        }

        public bool ChangeEmployee(Employee newEmployee)
        {
            if (newEmployee?.Version == null) return false;

            if (_repositoryEmployee.GetEmployee(newEmployee.Id) == null) return false;

            //Optimistic Locking 
            if (_repositoryEmployee.GetEmployee(newEmployee.Id).Version > newEmployee.Version) return false;

            try
            {

            _repositoryEmployee.Insert(newEmployee);
            }
            catch
            { return false; }

            return (_repositoryEmployee.GetEmployeeByEmployeeNumber(newEmployee.EmployeeNumber) != null) ? true : false;
        }

        public bool CanRemoveEmployee(Employee employee)
        {
            if (employee == null) return false;
            var e = _repositoryEmployee.GetEmployee(employee.Id);
            return _repositoryVehicle.IsVehicleReferredToEmp(e);
        }

        ////////////////// VEHICLES ///////////////////
        public List<Vehicle> GetAllVehicles()
        {
            return _repositoryVehicle.GetAll();
        }

        public bool AddVehicle(Vehicle vehicle)
        {
            if (vehicle == null && vehicle?.Id == null) return false;

            if (_repositoryVehicle.GetVehicleFromId(vehicle.Id) != null) return false;

            if (vehicle?.LicensePlate == "" || vehicle?.LicensePlate == null) return false;

            if (GetAllVehicles().Find(x => x.LicensePlate.ToUpper() == vehicle.LicensePlate.ToUpper()) != null) return false;

            try
            {
                _repositoryVehicle.Save(vehicle);

            }
            catch
            { return false; }

            return (_repositoryVehicle.GetVehicleFromId(vehicle.Id) != null) ? true : false;
        }

        public bool DeleteVehicle(Vehicle vehicle)
        {
            if (vehicle == null) return false;
            if (_repositoryVehicle.GetVehicleFromId(vehicle.Id) == null) return false;

            //Delete all Relations from Vehicle
            if (DeleteAllRelationsFromVehicle(_repositoryVehicle.GetVehicleFromId(vehicle.Id)) == false) return false;

            try
            {
                _repositoryVehicle.Delete(vehicle);
            }
            catch
            { return false; }

            return (_repositoryVehicle.GetVehicleFromId(vehicle.Id) == null) ? true : false;
        }

        public bool ChangeVehicle(Vehicle newVehicle)
        {
            if (newVehicle?.Version == null) return false;

            if (_repositoryVehicle.GetVehicleFromId(newVehicle.Id) == null) return false;

            //Optimistic Locking 
            if (_repositoryVehicle.GetVehicleFromId(newVehicle.Id).Version > newVehicle.Version) return false;

            try
            {
                _repositoryVehicle.Insert(newVehicle);
            }
            catch
            { return false; }

            return (_repositoryVehicle.GetVehicleFromId(newVehicle.Id) != null) ? true : false;
        }

        public List<VehicleToEmployeeRelation> GetRelationFromVehicle(Vehicle vehicle)
        {
            return _vehicleToEmployeeRepository.GetRelationFromVehicle(vehicle);
        }

        public Employee GetEmployeeById(int id)
        {
            return _repositoryEmployee.GetEmployee(id);
        }

        public bool AddVehicleToEmployeeRelation(VehicleToEmployeeRelation relation)
        {
            if (relation == null) return false;
            //if (_vehicleToEmployeeRepository.GetRelationFromRelationId(relation.Id) != null) return false;

            try
            {
                _vehicleToEmployeeRepository.Save(relation);

            }
            catch
            { return false; }

            return (_vehicleToEmployeeRepository.GetRelationFromRelationId(relation.Id) != null) ? true : false;
        }

        public bool DeleteVehicleToEmployeeRelation(VehicleToEmployeeRelation relation)
        {
            if (_vehicleToEmployeeRepository.GetRelationFromRelationId(relation.Id) == null) return false;

            try
            {
                _vehicleToEmployeeRepository.Delete(relation);
            }
            catch
            { return false; }

            //return (_vehicleToEmployeeRepository.GetRelationFromRelationId(relation.Id) == null) ? true : false;
            return true;
        }

        public List<VehicleToEmployeeRelation> GetAllRelations()
        {
            return _vehicleToEmployeeRepository.GetAll();
        }

        private bool DeleteAllRelationsFromVehicle(Vehicle vehicle) 
        {
            var relations = _vehicleToEmployeeRepository.GetAll();

            foreach (var relation in relations)
            {

                if (relation.VehicleId.Id == vehicle.Id)
                {
                    try
                    {
                        _vehicleToEmployeeRepository.Delete(relation);
                    }
                    catch
                    {
                        //Error while deleting object from db
                        return false;
                    }
                }

            }
            //Everything was successfull
            return true;
        }
    }
}

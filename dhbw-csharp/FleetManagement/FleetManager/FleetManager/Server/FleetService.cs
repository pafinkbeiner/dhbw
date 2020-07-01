using NHibernate.Id.Insert;
using NHibernate.Mapping;
using Server.DbConnection;
using Server.DbConnetion;
using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq.Expressions;

namespace Server
{
    public class FleetService : IFleetService
    {
        private static readonly string dbString = @"E:\02_Eigene_Dateien\Dokumente\dhbw-csharp\FleetManagement\FleetManager\FleetManager\Server\FleetManagement.db";
        private readonly UserRepository _repositoryUser = new UserRepository(dbString);
        private readonly BusinessUnitRepository _repositoryBusinessUnit = new BusinessUnitRepository(dbString);
        private readonly EmployeeRepository _repositoryEmployee = new EmployeeRepository(dbString);
        private readonly VehiclesRepository _repositoryVehicle = new VehiclesRepository(dbString);
        private readonly VehicleToEmployeeRepository _vehicleToEmployeeRepository = new VehicleToEmployeeRepository(dbString);

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
            var databasePassword = _repositoryUser.GetPasswordHashFromDb(username.ToLower());
            if (databasePassword == null) return false;
            var newPasswordHash = BCrypt.Net.BCrypt.ValidateAndReplacePassword(oldPassword, databasePassword, newPassword);
            var user = _repositoryUser.GetUserFromUsername(username);
            _repositoryUser.SetNewPassword(user.Id, newPasswordHash);
            return true;
        }

        public List<User> getAllUsers()
        {
            return _repositoryUser.GetAll();
        }

        public bool AddUser(User user)
        {
            if (user.Username == null || user.Lastname == null || user.Firstname == null) return false;

            //return false if user is already in db
            if (_repositoryUser.GetUserFromUsername(user.Username) != null) return false;

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
            if (_repositoryUser.GetUserFromUsername(user.Username) == null) return false;

            try
            { 
                _repositoryUser.Delete(user); 
            }
            catch { return false; }
            

            return (_repositoryUser.GetUserFromUsername(user.Username) == null) ? true : false;
        }

        public bool ChangeUser(User oldUser, User newUser)
        {
            //Optimistic Locking 
            if (_repositoryUser.GetUserFromUsername(oldUser.Username).Version > newUser.Version) return false;

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
            if (businessUnit.Name == null) return false;

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
            if (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) == null) return false;

            try
            {
            _repositoryBusinessUnit.Delete(businessUnit);

            }
            catch
            { return false; }

            return (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) == null) ? true : false;
        }

        public bool ChangeBusinessUnit(BusinessUnit oldBusinessUnit, BusinessUnit newBusinessUnit)
        {
            //Optimistic Locking 
            if (_repositoryBusinessUnit.getUnitFromUnitName(oldBusinessUnit.Name).Version > newBusinessUnit.Version) return false;

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

            try
            {

            _repositoryEmployee.Delete(employee);
            }catch
            { return false; }

            return (_repositoryEmployee.GetEmployee(employee.Id) == null) ? true : false;
        }

        public bool ChangeEmployee(Employee oldEmployee, Employee newEmployee)
        {
            //Optimistic Locking 
            if (_repositoryEmployee.GetEmployeeByEmployeeNumber(oldEmployee.EmployeeNumber).Version > newEmployee.Version) return false;

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
            if (_repositoryVehicle.GetVehicleFromId(vehicle.Id) != null) return false;

            if(vehicle.LicensePlate != null)
            vehicle.LicensePlate = vehicle.LicensePlate.ToUpper();

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
            if (_repositoryVehicle.GetVehicleFromId(vehicle.Id) == null) return false;

            try
            {
                _repositoryVehicle.Delete(vehicle);
            }
            catch
            { return false; }

            return (_repositoryVehicle.GetVehicleFromId(vehicle.Id) == null) ? true : false;
        }

        public bool ChangeVehicle(Vehicle oldVehicle, Vehicle newVehicle)
        {
            //Optimistic Locking 
            if (_repositoryVehicle.GetVehicleFromId(oldVehicle.Id).Version > newVehicle.Version) return false;

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
    }
}

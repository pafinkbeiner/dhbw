using NHibernate.Id.Insert;
using NHibernate.Mapping;
using Server.DbConnection;
using Server.DbConnetion;
using Server.Models;
using System;
using System.Collections.Generic;

namespace Server
{
    public class FleetService : IFleetService
    {
        //private static readonly string dbString = @"E:\02_Eigene_Dateien\Dokumente\dhbw-csharp\FleetManagement\FleetManager\FleetManager\Server\FleetManagement.db";
        private static readonly string dbString = @"/FleetManagement.db";

        private readonly UserRepository _repositoryUser = new UserRepository(dbString);
        private readonly BusinessUnitRepository _repositoryBusinessUnit = new BusinessUnitRepository(dbString);
        private readonly EmployeeRepository _repositoryEmployee = new EmployeeRepository(dbString);
        private readonly VehiclesRepository _repositoryVehicle = new VehiclesRepository(dbString);
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
            //return false if user is already in db
            if (_repositoryUser.GetUserFromUsername(user.Username) != null) return false;

            //hash pasword and store user
            var passwordHash = BCrypt.Net.BCrypt.HashPassword("geheim");
            user.Password = passwordHash;

            _repositoryUser.Save(user);

            //return true if user is in db
            return (_repositoryUser.GetUserFromUsername(user.Username) != null) ? true : false;
        }

        public bool DeleteUser(User user)
        {
            if (_repositoryUser.GetUserFromUsername(user.Username) == null) return false;

            _repositoryUser.Delete(user);

            return (_repositoryUser.GetUserFromUsername(user.Username) == null) ? true : false;
        }

        public bool ChangeUser(User oldUser, User newUser)
        {
            if (_repositoryUser.GetUserFromUsername(oldUser.Username) == null) return false;

            _repositoryUser.Delete(oldUser);
            _repositoryUser.Save(newUser);


            return (_repositoryUser.GetUserFromUsername(newUser.Username) != null) ? true : false;
        }

        public List<BusinessUnit> GetAllBusinessUnits()
        {
            return _repositoryBusinessUnit.GetAll();
        }

        public bool AddBusinessUnit(BusinessUnit businessUnit)
        {
            if (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) != null) return false;

            _repositoryBusinessUnit.Save(businessUnit);

            return (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) != null) ? true : false;
        }

        public bool DeleteBusinessUnit(BusinessUnit businessUnit)
        {
            if (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) == null) return false;

            _repositoryBusinessUnit.Delete(businessUnit);

            return (_repositoryBusinessUnit.getUnitFromUnitName(businessUnit.Name) == null) ? true : false;
        }

        public bool ChangeBusinessUnit(BusinessUnit oldBusinessUnit, BusinessUnit newBusinessUnit)
        {
            if (_repositoryBusinessUnit.getUnitFromUnitName(oldBusinessUnit.Name) == null) return false;

            _repositoryBusinessUnit.Delete(_repositoryBusinessUnit.getUnitFromUnitName(oldBusinessUnit.Name));
            _repositoryBusinessUnit.Save(newBusinessUnit);


            return (_repositoryBusinessUnit.getUnitFromUnitName(newBusinessUnit.Name) != null) ? true : false;
        }

        ////////////////// EMPLOYEES ///////////////////
        public List<Employee> GetAllEmployees()
        {
            try
            {

            return _repositoryEmployee.GetAll();
            }
            catch (Exception e)
            {
                return new List<Employee>();
            }
        }

        public bool AddEmployee(Employee employee)
        {
            throw new System.NotImplementedException();
        }

        public bool DeleteEmployee(Employee employee)
        {
            throw new System.NotImplementedException();
        }

        public bool ChangeEmployee(Employee oldEmployee, Employee newEmployee)
        {
            throw new System.NotImplementedException();
        }

        ////////////////// VEHICLES ///////////////////
        public List<Vehicle> GetAllVehicles()
        {
            return _repositoryVehicle.GetAll();
        }

        public bool AddVehicle(Vehicle vehicle)
        {
            throw new System.NotImplementedException();
        }

        public bool DeleteVehicle(Vehicle vehicle)
        {
            throw new System.NotImplementedException();
        }

        public bool ChangeVehicle(Vehicle oldVehicle, Employee newVehicle)
        {
            throw new System.NotImplementedException();
        }
    }
}

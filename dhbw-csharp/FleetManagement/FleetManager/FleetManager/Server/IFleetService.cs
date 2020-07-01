using NHibernate.Mapping;
using Server.Models;
using System.Collections.Generic;
using System.ServiceModel;

namespace Server
{
    [ServiceContract]
    public interface IFleetService
    {
        [OperationContract]
        User CanUserLogin(string userName, string password);

        [OperationContract]
        bool ChangePassword(string username, string oldPassword, string newPassword);

        [OperationContract]
        List<User> getAllUsers();

        [OperationContract]
        List<BusinessUnit> GetAllBusinessUnits();

        [OperationContract]
        bool AddUser(User user);

        [OperationContract]
        bool DeleteUser(User user);

        [OperationContract]
        bool ChangeUser(User oldUser, User newUser);

        [OperationContract]
        bool AddBusinessUnit(BusinessUnit businessUnit);

        [OperationContract]
        bool DeleteBusinessUnit(BusinessUnit businessUnit);

        [OperationContract]
        bool ChangeBusinessUnit(BusinessUnit oldBusinessUnit, BusinessUnit newBusinessUnit);

        [OperationContract]
        List<Employee> GetAllEmployees();

        [OperationContract]
        bool AddEmployee(Employee employee);

        [OperationContract]
        bool DeleteEmployee(Employee employee);

        [OperationContract]
        bool ChangeEmployee(Employee oldEmployee, Employee newEmployee);

        [OperationContract]
        bool CanRemoveEmployee(Employee employee);

        [OperationContract]
        Employee GetEmployeeById(int id);

        [OperationContract]
        List<Vehicle> GetAllVehicles();

        [OperationContract]
        bool AddVehicle(Vehicle vehicle);

        [OperationContract]
        bool DeleteVehicle(Vehicle vehicle);

        [OperationContract]
        bool ChangeVehicle(Vehicle oldVehicle, Vehicle newVehicle);

        [OperationContract]
        List<VehicleToEmployeeRelation> GetRelationFromVehicle(Vehicle vehicle);

        [OperationContract]
        bool AddVehicleToEmployeeRelation(VehicleToEmployeeRelation relation);

        [OperationContract]
        bool DeleteVehicleToEmployeeRelation(VehicleToEmployeeRelation relation);

        [OperationContract]
        List<VehicleToEmployeeRelation> GetAllRelations();
    }
}
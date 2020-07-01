using HostFleetManager.Interfaces;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using Server;
using Server.Models;
using System.Collections.Generic;

namespace Test
{
    [TestClass]
    public class CostBusinessUnitTest
    {
        private static readonly Mock<IBusinessUnitRepository> _businessUnitRepositoryMock = new Mock<IBusinessUnitRepository>();
        private static readonly Mock<IEmployeeRepository> _employeeRepositoryMock = new Mock<IEmployeeRepository>();
        private static readonly Mock<IVehicleRepository> _vehicleRepositoryMock = new Mock<IVehicleRepository>();
        private static readonly Mock<IVehicleToEmployeeRepository> _vehicleToEmployeeRepositoryMock = new Mock<IVehicleToEmployeeRepository>();

        private static IFleetService _service = new FleetService(_businessUnitRepositoryMock.Object, _vehicleRepositoryMock.Object, _employeeRepositoryMock.Object, null, _vehicleToEmployeeRepositoryMock.Object);

        private static readonly BusinessUnit _buUnit1 = new BusinessUnit
        {
            Id = 1,
            Name = "Unit1",
            Version = 1
        };
        private static readonly BusinessUnit _buUnit2 = new BusinessUnit
        {
            Id = 2,
            Name = "Unit2",
            Version = 1
        };
        private static readonly Employee _employeeUser1 = new Employee
        {
            Id = 1,
            EmployeeNumber = 100,
            FirstName = "User1",
            LastName = "Joe",
            Version = 1
        };
        private static readonly Employee _employeeUser2 = new Employee
        {
            Id = 2,
            EmployeeNumber = 101,
            FirstName = "User2",
            LastName = "Joe",
            Version = 1
        };
        private static readonly Vehicle _vehicle1 = new Vehicle
        {
            Id = 1,
            LicensePlate = "A-A-0",
            Brand = "Audi",
            Model = "A6",
            Version = 1
        };
        private static readonly Vehicle _vehicle2 = new Vehicle
        {
            Id = 2,
            LicensePlate = "A-A-1",
            Brand = "Audi",
            Model = "A6",
            Version = 1
        };

        [ClassInitialize]
        public static void Setup(TestContext context)
        {
            _businessUnitRepositoryMock.Setup(x => x.GetAll())
                .Returns(new List<BusinessUnit> { _buUnit1, _buUnit2 });
            _employeeRepositoryMock.Setup(x => x.GetAll())
                .Returns(new List<Employee> { _employeeUser1, _employeeUser2 });
            _vehicleRepositoryMock.Setup(x => x.GetAll())
                .Returns(new List<Vehicle> { _vehicle1, _vehicle2 });

        }

        [TestMethod]
        public void TestGettingAllVehicles()
        {
            var result = _service.GetAllVehicles();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.Count, 2);
        }

        [TestMethod]
        public void TestGettingAllEmployees()
        {
            var result = _service.GetAllEmployees();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.Count, 2);
        }

        [TestMethod]
        public void TestGettingAllBusinessUnits()
        {
            var result = _service.GetAllBusinessUnits();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.Count, 2);
        }

    }
}

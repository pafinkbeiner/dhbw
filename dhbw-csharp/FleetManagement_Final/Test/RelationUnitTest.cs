using HostFleetManager.Interfaces;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using Server;
using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    [TestClass]
    public class RelationUnitTest
    {

        private static readonly Mock<IVehicleToEmployeeRepository> _vehicleToEmployeeRepositoryMock = new Mock<IVehicleToEmployeeRepository>();
        private static IFleetService _service = new FleetService(null, null, null, null, _vehicleToEmployeeRepositoryMock.Object);

        private static readonly VehicleToEmployeeRelation _relation1 = new VehicleToEmployeeRelation
        {
            EmployeeId = new Employee
            {
                Id = 1,
                EmployeeNumber = 101,
                FirstName = "User1",
                LastName = "User11",
                Version = 1
            },
            VehicleId = new Vehicle
            {
                Id = 1,
                LicensePlate = "A-A-0",
                Brand = "Audi",
                Model = "A6",
                Version = 1
            },
            StartDate = DateTime.Now,
            Id = 1
        };

        private static readonly VehicleToEmployeeRelation _relation2 = new VehicleToEmployeeRelation
        {
            EmployeeId = new Employee
            {
                Id = 2,
                EmployeeNumber = 102,
                FirstName = "User2",
                LastName = "User21",
                Version = 1
            },
            VehicleId = new Vehicle
            {
                Id = 2,
                LicensePlate = "A-A-1",
                Brand = "Audi",
                Model = "A6",
                Version = 1
            },
            StartDate = DateTime.Now,
            Id = 2
        };

        private static readonly VehicleToEmployeeRelation _nullRelation = null;

        [ClassInitialize]
        public static void Setup(TestContext context)
        {

            _vehicleToEmployeeRepositoryMock.Setup(x => x.GetAll()).Returns(new List<VehicleToEmployeeRelation> { _relation1, _relation2});

            _vehicleToEmployeeRepositoryMock.Setup(x => x.GetRelationFromRelationId(1)).Returns(_relation1);

            _vehicleToEmployeeRepositoryMock.Setup(x => x.GetRelationFromRelationId(2)).Returns(_relation2);

            _vehicleToEmployeeRepositoryMock.Setup(x => x.Save(_relation1)).Returns(true);
            _vehicleToEmployeeRepositoryMock.Setup(x => x.Save(_relation2)).Returns(true);
            _vehicleToEmployeeRepositoryMock.Setup(x => x.Save(_nullRelation)).Returns(false);

            _vehicleToEmployeeRepositoryMock.Setup(x => x.Delete(_relation1));
            _vehicleToEmployeeRepositoryMock.Setup(x => x.Delete(_relation2));
        }

        [TestMethod]
        public void TestGettingAllrelations()
        {
            var result = _service.GetAllRelations();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.Count, 2);
        }

        [TestMethod]
        public void TestSavingNullRelation()
        {
            var result = _service.AddVehicleToEmployeeRelation(_nullRelation);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

        [TestMethod]
        public void TestSavingRelation1()
        {
            var result = _service.AddVehicleToEmployeeRelation(_relation1);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, true);
        }

        [TestMethod]
        public void TestSavingRelation2()
        {
            var result = _service.AddVehicleToEmployeeRelation(_relation2);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, true);
        }

        [TestMethod]
        public void TestRemovingRelation()
        {
            var result = _service.AddVehicleToEmployeeRelation(_relation1);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, true);
        }
    }
}

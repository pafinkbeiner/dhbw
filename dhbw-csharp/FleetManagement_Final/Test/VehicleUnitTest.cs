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
    public class VehicleUnitTest
    {
        private static Mock<IVehicleRepository> _vehicleRepositoryMock = new Mock<IVehicleRepository>();
        private static IFleetService _service = new FleetService(null, _vehicleRepositoryMock.Object, null, null, null);

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
        private static readonly Vehicle _invalidVehicleToSave = new Vehicle
        {
            LicensePlate = "A-A-0",
            Brand = "Audi",
            Model = "A6"
        };

        private static readonly Vehicle _validVehicleToSave = new Vehicle
        {
            LicensePlate = "A-A-2",
            Brand = "Audi",
            Model = "A6",
            Insurance = 100,
            LeasingFrom = DateTime.Now,
            LeasingTo = DateTime.Now,
            LeasingRate = 100
        };
        private static readonly Vehicle _notExistingVehicle = new Vehicle
        {
            Id = 99,
            Brand = "Audi",
            Model = "A6",
        };

        private static readonly VehicleToEmployeeRelation _relation = new VehicleToEmployeeRelation
        {
            EmployeeId = new Employee
            {
                Id = 1,
                BusinessUnitId = new BusinessUnit
                {
                    Id = 1,
                    Name = "Test"
                },
                FirstName = "User1",
                LastName = "Doe",
                EmployeeNumber = 1
            }, 
            VehicleId = new Vehicle 
            {
                LicensePlate = "A-A-2",
                Brand = "Audi",
                Model = "A6",
                Insurance = 100,
                LeasingFrom = DateTime.Now,
                LeasingTo = DateTime.Now,
                LeasingRate = 100,
            },
            StartDate = DateTime.Today,
            EndDate = DateTime.Today
        };

        [ClassInitialize]
        public static void Setup(TestContext context)
        {
            _vehicleRepositoryMock.Setup(x => x.GetAll())
                .Returns(new List<Vehicle> { _vehicle1, _vehicle2 });

            _vehicleRepositoryMock.Setup(x => x.GetVehicleFromId(1))
                .Returns(_vehicle1);
            _vehicleRepositoryMock.Setup(x => x.GetVehicleFromId(2))
                .Returns(_vehicle2);

            _vehicleRepositoryMock.Setup(x => x.Save(_validVehicleToSave)).Returns(true);
            _vehicleRepositoryMock.Setup(x => x.Save(_invalidVehicleToSave)).Returns(false);

            _vehicleRepositoryMock.Setup(x => x.getVehicleFromLicensePlate("A-A-0"))
                .Returns(_vehicle1);

            _vehicleRepositoryMock.Setup(x => x.Save(_vehicle1)).Returns(true);

            _vehicleRepositoryMock.Setup(x => x.Delete(_vehicle1));
        }

        [TestMethod]
        public void TestGettingAllVehicles()
        {
            var result = _service.GetAllVehicles();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.Count, 2);
        }

        [TestMethod]
        public void TestDeletingVehicleByIdButNotRelations()
        {
            var result = _service.DeleteVehicle(_invalidVehicleToSave);

            Assert.IsNotNull(result);
            Assert.AreEqual(false, result);
        }

        [TestMethod]
        public void TestDeletingVehicleWhichDoesNotExist()
        {
            var result = _service.DeleteVehicle(_notExistingVehicle);

            Assert.IsNotNull(result);
            Assert.AreEqual(false, result);
        }

        [TestMethod]
        public void TestSavingVehicleWithAlreadyExistingLicensePlate()
        {
            var result = _service.AddVehicle(_invalidVehicleToSave);

            Assert.IsNotNull(result);
            Assert.AreEqual(false, result);
        }

        [TestMethod]
        public void TestSavingValidVehicle()
        {
            var result = _service.AddVehicle(_validVehicleToSave);

            Assert.IsNotNull(result);;
        }

        [TestMethod]
        public void TestAddingEmployeeInvalidRelationToVehicle()
        {
            var result = _service.AddVehicleToEmployeeRelation(_relation);

            Assert.IsNotNull(result);
            Assert.AreEqual(false, result);
        }

    }
}

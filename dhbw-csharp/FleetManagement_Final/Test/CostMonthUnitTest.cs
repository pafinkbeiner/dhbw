using HostFleetManager.Interfaces;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using Server;
using Server.Models;
using System.Collections.Generic;

namespace Test
{
    [TestClass]
    public class CostMonthUnitTest
    {

        private static readonly Mock<IVehicleRepository> _vehicleRepositoryMock = new Mock<IVehicleRepository>();

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

        [ClassInitialize]
        public static void Setup(TestContext context)
        {

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
        public void TestGettingFirstVehicle()
        {
            var result = _service.GetAllVehicles().Find(x => x.Id == 1);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, _vehicle1);
        }

        [TestMethod]
        public void TestGettingSecondVehicle()
        {
            var result = _service.GetAllVehicles().Find(x => x.Id == 2);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, _vehicle2);
        }


    }
}

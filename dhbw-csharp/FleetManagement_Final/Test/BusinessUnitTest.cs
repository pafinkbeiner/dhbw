using HostFleetManager.Interfaces;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using Server;
using Server.DbConnetion;
using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    [TestClass]
    public class BusinessUnitTest
    {
        private static readonly Mock<IBusinessUnitRepository> _businessUnitRepositoryMock = new Mock<IBusinessUnitRepository>();
        private static IFleetService _service = new FleetService(_businessUnitRepositoryMock.Object, null, null, null, null);

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
        private static readonly BusinessUnit _buToSave = new BusinessUnit
        {
            Name = "Unit1",
            Description = "this should fail"
        };


        [ClassInitialize]
        public static void Setup(TestContext context)
        {
            _businessUnitRepositoryMock.Setup(x => x.GetAll())
                .Returns(new List<BusinessUnit> { _buUnit1, _buUnit2 });

            _businessUnitRepositoryMock.Setup(x => x.getUnitFromId(1))
                .Returns(_buUnit1);
            _businessUnitRepositoryMock.Setup(x => x.getUnitFromId(2))
                .Returns(_buUnit2);

            _businessUnitRepositoryMock.Setup(x => x.getUnitFromUnitName("Unit1"))
                .Returns(_buUnit1);

            _businessUnitRepositoryMock.Setup(x => x.Delete(_buUnit1));
        }

        [TestMethod]
        public void TestGettingAllBusinessUnits()
        {
            var result = _service.GetAllBusinessUnits();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.Count, 2);
        }

        [TestMethod]
        public void TestDeleteBusinessUnit()
        {
            var result = _service.DeleteBusinessUnit(_buUnit1);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

        [TestMethod]
        public void TestSavingBusinessUnitWithAlreadyExistingName()
        {
            var result = _service.AddBusinessUnit(_buToSave);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

    }
}

using HostFleetManager.Interfaces;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
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
        private Mock<IRepository<BusinessUnit>> businessUnitRepoMock = new Mock<IRepository<BusinessUnit>>();
        private BusinessUnit businessUnitNull = null;
        private BusinessUnit businessUnitValid = new BusinessUnit { Name = "Einkauf", Description = "Hier fließt Geld." };
        private BusinessUnit businessUnitInvalid = new BusinessUnit { Name = null, Description = "Hier fließt Geld." };

        [TestMethod]
        public void SaveNullBusinessUnit()
        {
            businessUnitRepoMock.Setup(x => x.Save(null)).Returns(false);
            Assert.IsFalse(businessUnitRepoMock.Object.Save(businessUnitNull));
        }

        [TestMethod]
        public void SaveValidBusinessUnit()
        {
            businessUnitRepoMock.Setup(x => x.Save(businessUnitValid)).Returns(true);
            Assert.IsTrue(businessUnitRepoMock.Object.Save(businessUnitValid));
        }

        [TestMethod]
        public void SaveInvalidBusinessUnit()
        {
            businessUnitRepoMock.Setup(x => x.Save(businessUnitInvalid)).Returns(false);
            Assert.IsFalse(businessUnitRepoMock.Object.Save(businessUnitInvalid));
        }
    }
}

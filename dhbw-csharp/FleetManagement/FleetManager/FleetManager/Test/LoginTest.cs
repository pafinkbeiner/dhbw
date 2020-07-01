using HostFleetManager.Interfaces;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Test.FleetServiceReference;

namespace Test
{
    [TestClass]
    public class LoginTest
    {
        //TODO - Test Insert Function

        private Mock<IRepository<User>> userRepoMock = new Mock<IRepository<User>>();

        [TestMethod]
        public void TestMethod1()
        {
            userRepoMock.Setup(x => x.Save(null)).Returns(false);

            Assert.IsFalse(userRepoMock.Object.Save(null));
        }

        [TestMethod]
        public void WrongUserName()
        {
            userRepoMock.Setup(x => x.Save(null)).Returns(false);

            Assert.IsFalse(userRepoMock.Object.Save(null));
        }
    }
}

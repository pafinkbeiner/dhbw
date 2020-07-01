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
using Test.FleetServiceReference;

namespace Test
{
    [TestClass]
    public class UserTest
    {
        private Mock<IRepository<User>> userRepoMock = new Mock<IRepository<User>>();
        private User userNull = null;
        private User userValid = new User { Username = "MaxMus", Firstname = "Max", Lastname = "Mustermann", Password = "geheim", IsAdmin = false };
        private User userInvalid = new User { Username = null, Firstname = "Max", Lastname = "Mustermann", Password = "geheim", IsAdmin = false };


        [TestMethod]
        public void SaveNullUser()
        {
            userRepoMock.Setup(x => x.Save(null)).Returns(false);
            Assert.IsFalse(userRepoMock.Object.Save(userNull));
        }

        [TestMethod]
        public void SaveValidUser()
        {
            userRepoMock.Setup(x => x.Save(userValid)).Returns(true);
            Assert.IsTrue(userRepoMock.Object.Save(userValid));
        }

        [TestMethod]
        public void SaveInvalidUser()
        {
            userRepoMock.Setup(x => x.Save(userInvalid)).Returns(false);
            Assert.IsFalse(userRepoMock.Object.Save(userInvalid));
        }
    }
}

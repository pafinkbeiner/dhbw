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
    public class UserTest
    {
        private static Mock<IUserRepository> _userRepositoryMock = new Mock<IUserRepository>();
        private static IFleetService _service = new FleetService(null, null, null, _userRepositoryMock.Object, null);

        private static readonly User _user1 = new User
        {
            Id = 1,
            Firstname = "Firstname1",
            Lastname = "Lastname2",
            Username = "Username2",
            IsAdmin = false,
            Password = "$2y$10$1coNSX5TTw3cUDZdXw1AhOoRw6ewMTcVAU.1YVx.gEzQLpQNnvXjq",
            Version = 1
        };
        private static readonly User _user2 = new User
        {
            Id = 1,
            Firstname = "Firstname1",
            Lastname = "Lastname2",
            Username = "Username2",
            IsAdmin = false,
            Password = "$2y$10$1coNSX5TTw3cUDZdXw1AhOoRw6ewMTcVAU.1YVx.gEzQLpQNnvXjq", 
            Version = 1
        };
        private static readonly User _nonExistent = new User
        {
            Id = 3,
            Firstname = "Max",
            Lastname = "Mustermann",
        };

        [ClassInitialize]
        public static void Setup(TestContext context)
        {
            _userRepositoryMock.Setup(x => x.GetAll())
                .Returns(new List<User>(){ _user1, _user2 });

            _userRepositoryMock.Setup(x => x.GetUserFromId(1))
                .Returns(_user1);

            _userRepositoryMock.Setup(x => x.Delete(_user1));

            _userRepositoryMock.Setup(x => x.GetUserFromUsername("Username2"))
            .Returns(_user1);
        }

        [TestMethod]
        public void TestGettingAllUsers()
        {
            var result = _service.getAllUsers();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.Count(), 2);
        }

        [TestMethod]
        public void TestGettingUserById()
        {
            var result = _service.getAllUsers().Find(x => x.Id == 1);

            Assert.IsNotNull(result);
        }

        [TestMethod]
        public void TestGettingNullForInvalidUserId()
        {
            var result = _service.getAllUsers().Find(x => x.Id == 99);

            Assert.IsNull(result);
        }

        [TestMethod]
        public void TestDeletingNonExistentUser()
        {
            var result = _service.DeleteUser(_nonExistent);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

        [TestMethod]
        public void TestDeletingUser()
        {
            var result = _service.DeleteUser(_user1);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

    }
}

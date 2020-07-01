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
    public class LoginTest
    {
        private static readonly Mock<IUserRepository> _userRepositoryMock = new Mock<IUserRepository>();
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
        private static readonly User _user = new User
        {
            Id = 1,
            Firstname = "John",
            Lastname = "Doe",
            Username = "johndoe",
            IsAdmin = false,
            Password = "$2y$10$1coNSX5TTw3cUDZdXw1AhOoRw6ewMTcVAU.1YVx.gEzQLpQNnvXjq", 
            Version = 1
        };
        private static readonly User _invalidUser = new User
        {
            Id = 1,
            Firstname = "John",
            Lastname = null,
            Username = "johndoe",
            IsAdmin = false,
            Password = null, 
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
            _userRepositoryMock.Setup(x => x.GetUserFromUsername("johndoe")).Returns(_user);
            _userRepositoryMock.Setup(x => x.Save(_user)).Returns(true);
            _userRepositoryMock.Setup(x => x.Save(_invalidUser)).Returns(false);
        }


        [TestMethod]
        public void TestLoginWithCorrectCredentials()
        {
            var result = _service.AddUser(_user);

            Assert.IsNotNull(result);
            Assert.AreEqual(false, result);
        }

        [TestMethod]
        public void TestLoginWithIncorrectPassword()
        {
            var result = _service.AddUser(_invalidUser);

            Assert.IsNotNull(result);
            Assert.AreEqual(false, result);
        }

        [TestMethod]
        public void TestLoginWithNotExistentUsername()
        {
            var result = _service.AddUser(_user);

            Assert.IsNotNull(result);
            Assert.AreEqual(false, result);
        }

        [TestMethod]
        public void TestPasswordChangeWithCorrectOldPassword()
        {
            var result = _service.ChangePassword(_user1.Username, "geheim", "geheimer");

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

        [TestMethod]
        public void TestPasswordChangeWithIncorrectOldPassword()
        {
            var result = _service.ChangePassword(_user1.Username, "falsches Password", "geheimer");

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

        [TestMethod]
        public void TestPasswordChangeWithNonExistentUser()
        {
            var result = _service.ChangePassword(_nonExistent.Username, "egal", "geheim");

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

    }
}

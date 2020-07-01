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
    public class EmployeeTest
    {
        private static readonly Mock<IEmployeeRepository> _employeeRepositoryMock = new Mock<IEmployeeRepository>();
        private static IFleetService _service = new FleetService(null, null, _employeeRepositoryMock.Object, null, null);

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
        private static readonly Employee _employeeToSave = new Employee
        {
            EmployeeNumber = 100,
            FirstName = "Test",
            LastName = "Test"
        };

        private static readonly Employee _nullEmployee = null;


        [ClassInitialize]
        public static void Setup(TestContext context)
        {
            _employeeRepositoryMock.Setup(x => x.GetAll())
                .Returns(new List<Employee>{ _employeeUser1, _employeeUser2 });

            _employeeRepositoryMock.Setup(x => x.GetEmployeeByEmployeeNumber(100))
                .Returns(_employeeUser1);

            _employeeRepositoryMock.Setup(x => x.Save(_employeeUser2)).Returns(true);
            _employeeRepositoryMock.Setup(x => x.Save(_employeeUser1)).Returns(true);
            _employeeRepositoryMock.Setup(x => x.Save(_nullEmployee)).Returns(false);

            _employeeRepositoryMock.Setup(x => x.Delete(_employeeUser1));
        }

        [TestMethod]
        public void TestGettingAllEmployees()
        {
            var result = _service.GetAllEmployees();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.Count, 2);
        }

        [TestMethod]
        public void TestSavingNullEmployee()
        {
            var result = _service.AddEmployee(_nullEmployee);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

        [TestMethod]
        public void TestSavingEmployeeWithAlreadyExistingEmployeeNumber()
        {
            var result = _service.AddEmployee(_employeeToSave);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }

        [TestMethod]
        public void TestCanRemoveNullEmployee()
        {
            var result = _service.CanRemoveEmployee(_nullEmployee);

            Assert.IsNotNull(result);
            Assert.AreEqual(result, false);
        }
    }
}

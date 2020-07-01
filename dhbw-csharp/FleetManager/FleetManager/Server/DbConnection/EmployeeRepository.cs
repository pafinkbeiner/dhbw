using Server.DbConnetion;
using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server.DbConnection
{
    public class EmployeeRepository : Repository<Employee>
    {
        public EmployeeRepository(string databaseFile) : base(databaseFile)
        {
        }

        public Employee GetEmployeeByEmployeeNumber(int employeeNumber)
        {
            List<Employee> list = this.GetAll();

            return list.Find(x => x.EmployeeNumber == employeeNumber);
        }
    }
}

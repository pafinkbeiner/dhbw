using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HostFleetManager.Interfaces
{
    public interface IEmployeeRepository: IRepository<Employee>
    {
        Employee GetEmployeeByEmployeeNumber(int employeeNumber);

        bool IsEmployeeReferred(BusinessUnit businessUnit);

        Employee GetEmployee(int id);    
    }  
}

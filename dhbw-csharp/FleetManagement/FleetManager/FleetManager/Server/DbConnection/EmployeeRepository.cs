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
            //return this.GetAll().Find(x => x.EmployeeNumber == employeeNumber);
            using (var session = NHibernateHelper.OpenSession())
            {
                return session.Query<Employee>().Where(x => x.EmployeeNumber == employeeNumber).FirstOrDefault();
            }
        }

        public bool IsEmployeeReferred(BusinessUnit businessUnit)
        {
            using (var session = NHibernateHelper.OpenSession())
            {

                if (session.Query<Employee>()
                      .Where(x => x.BusinessUnitId.Id == businessUnit.Id).FirstOrDefault() != null)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        public Employee GetEmployee(int id)
        {
            using (var session = NHibernateHelper.OpenSession())
            {
                using (var transaction = session.BeginTransaction())
                {
                    try
                    {
                        return session.Query<Employee>()
                               .Where(x => x.Id == id).FirstOrDefault();

                    }
                    catch
                    {
                        return null;
                    }
                }
            }
        }
    }
}

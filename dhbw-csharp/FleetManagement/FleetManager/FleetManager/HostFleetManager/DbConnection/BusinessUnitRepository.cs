using Server.DbConnetion;
using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server.DbConnection
{
    public class BusinessUnitRepository : Repository<BusinessUnit>
    {
        public BusinessUnitRepository(string databaseFile) : base(databaseFile)
        {
        }

        public BusinessUnit getUnitFromUnitName(string unitName)
        {
            List<BusinessUnit> list = this.GetAll();

            return list.Find(x => x.Name == unitName);
        }
    }
}

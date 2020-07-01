using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HostFleetManager.Interfaces
{
    public interface IBusinessUnitRepository: IRepository<BusinessUnit>
    {
        BusinessUnit getUnitFromUnitName(string unitName);

        BusinessUnit getUnitFromId(int id);
    }
}

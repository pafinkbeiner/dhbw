using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HostFleetManager.Interfaces
{
    public interface IVehicleToEmployeeRepository: IRepository<VehicleToEmployeeRelation>
    {
        List<VehicleToEmployeeRelation> GetRelationFromVehicle(Vehicle vehicle);

        VehicleToEmployeeRelation GetRelationFromRelationId(int id);
    }
}

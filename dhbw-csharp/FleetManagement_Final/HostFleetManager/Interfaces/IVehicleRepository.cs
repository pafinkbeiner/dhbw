using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HostFleetManager.Interfaces
{
    public interface IVehicleRepository: IRepository<Vehicle>
    {
        Vehicle GetVehicleFromId(int vehicleId);

        Vehicle getVehicleFromLicensePlate(string licensePlate);

        bool IsVehicleReferredToEmp(Employee emp);
    }
}

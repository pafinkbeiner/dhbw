using Server.DbConnetion;
using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server.DbConnection
{
    public class VehiclesRepository : Repository<Vehicle>
    {
        public VehiclesRepository(string databaseFile) : base(databaseFile)
        {
        }

        public Vehicle getVehicleFromLicensePlate(string licensePlate)
        {
            List<Vehicle> list = this.GetAll();

            return list.Find(x => x.LicensePlate == licensePlate);
        }
    }
}

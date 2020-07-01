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

        public Vehicle GetVehicleFromId(int vehicleId)
        {
            using (var session = NHibernateHelper.OpenSession())
            {
                try
                {
                    return session.Query<Vehicle>().Where(x => x.Id == vehicleId).FirstOrDefault();

                }catch
                {
                    return null;
                }

            }
        }

        public Vehicle getVehicleFromLicensePlate(string licensePlate)
        {
            return this.GetAll().Find(x => x.LicensePlate == licensePlate);
        }

        public bool IsVehicleReferredToEmp(Employee emp)
        {
            using (var session = NHibernateHelper.OpenSession())
            {
                try
                {
                    if (session.Query<VehicleToEmployeeRelation>()
                          .Where(x => x.EmployeeId.Id == emp.Id).FirstOrDefault() != null)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                catch { return false; }


            }
        }
    }
}

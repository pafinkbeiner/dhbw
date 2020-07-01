﻿using Server.DbConnetion;
using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server.DbConnection
{
    public class VehicleToEmployeeRepository : Repository<VehicleToEmployeeRelation>
    {

        public VehicleToEmployeeRepository(string databaseFile) : base(databaseFile)
        {
        }

        public List<VehicleToEmployeeRelation> GetRelationFromVehicle(Vehicle vehicle)
        {
            return this.GetAll().FindAll(x => x.VehicleId.Id == vehicle.Id);
        }

        public List<VehicleToEmployeeRelation> GetRelationFromRelationId(int id)
        {
            return this.GetAll().FindAll(x => x.Id == id);

        }
    }
}

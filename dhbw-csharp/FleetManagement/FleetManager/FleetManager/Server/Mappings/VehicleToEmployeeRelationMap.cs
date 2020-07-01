using FluentNHibernate.Mapping;
using Server.Models;

namespace Server.Mapping
{
    public class VehicleToEmployeeRelationMap : ClassMap<VehicleToEmployeeRelation>
    {
        public VehicleToEmployeeRelationMap()
        {
            Table("VehicleToEmployeeRelation");
            Id(x => x.Id).GeneratedBy.Native();
            Map(x => x.StartDate).Not.Nullable();
            Map(x => x.EndDate);
            References(x => x.VehicleId).Column("VehicleId").Not.Nullable();
            References(x => x.EmployeeId).Column("EmployeeId").Not.Nullable();
        }
    }
}

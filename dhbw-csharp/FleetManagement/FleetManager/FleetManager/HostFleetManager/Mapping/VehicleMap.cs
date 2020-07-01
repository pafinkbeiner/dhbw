using FluentNHibernate.Mapping;
using Server.Models;

namespace Server.Mapping
{
    public class VehicleMap : ClassMap<Vehicle>
    {
        public VehicleMap()
        {
            Table("Vehicles");
            Id(x => x.Id).GeneratedBy.Native().Not.Nullable();
            Map(x => x.LicensePlate).Not.Nullable();
            Map(x => x.Brand).Not.Nullable();
            Map(x => x.Model).Not.Nullable();
            Map(x => x.Insurance).Not.Nullable();
            Map(x => x.LeasingFrom).Not.Nullable();
            Map(x => x.LeasingTo).Not.Nullable();
            Map(x => x.LeasingRate).Not.Nullable();
            Version(x => x.Version).Not.Nullable().Default("1");
        }
    }
}

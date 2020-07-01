using FluentNHibernate.Mapping;
using Server.Models;

namespace Server.Mapping
{
    public class BusinessUnitMap : ClassMap<BusinessUnit>
    {
        public BusinessUnitMap()
        {
            Table("BusinessUnits");
            Id(x => x.Id).GeneratedBy.Native();
            Map(x => x.Name).Not.Nullable();
            Map(x => x.Description);
            Version(x => x.Version).Not.Nullable().Default(1);
        }
    }
}

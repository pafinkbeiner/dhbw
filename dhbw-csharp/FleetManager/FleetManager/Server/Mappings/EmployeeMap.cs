using FluentNHibernate.Mapping;
using Server.Models;

namespace Server.Mapping
{
    public class EmployeeMap : ClassMap<Employee>
    {
        public EmployeeMap()
        {
            Table("Employees");
            Id(x => x.Id).GeneratedBy.Native();
            Map(x => x.FirstName).Not.Nullable();
            Map(x => x.LastName).Not.Nullable();
            Map(x => x.EmployeeNumber).Not.Nullable().Unique();
            Map(x => x.Salutation);
            Map(x => x.Title);
            References(x => x.BusinessUnitId).Not.Nullable();
            Version(x => x.Version).Not.Nullable().Default(1);
        }
    }
}

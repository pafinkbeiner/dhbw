using FluentNHibernate.Mapping;
using Server.Models;

namespace Server.Mapping
{
    public class UserMap : ClassMap<User>
    {
        public UserMap()
        {
            Table("Users");
            Id(x => x.Id).GeneratedBy.Native();
            Map(x => x.Username).Not.Nullable().Unique();
            Map(x => x.Firstname);
            Map(x => x.Lastname).Not.Nullable();
            Map(x => x.Password).Not.Nullable();
            Map(x => x.IsAdmin).Not.Nullable().Default("false");
            Version(x => x.Version).Not.Nullable().Default(1);
        }
    }
}

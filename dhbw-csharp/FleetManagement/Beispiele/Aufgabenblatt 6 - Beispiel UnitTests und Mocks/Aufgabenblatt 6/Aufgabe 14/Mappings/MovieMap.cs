using Aufgabe_14.Models;
using FluentNHibernate.Mapping;

namespace Aufgabe_14.Mappings
{
    public class MovieMap: MapBase<Movie>
    {
        public MovieMap()
        {
            Table("Movies");
            Map(x => x.Title).Not.Nullable();
            References(x => x.Genre).Column("GenreId").Not.Nullable();
        }
    }
}

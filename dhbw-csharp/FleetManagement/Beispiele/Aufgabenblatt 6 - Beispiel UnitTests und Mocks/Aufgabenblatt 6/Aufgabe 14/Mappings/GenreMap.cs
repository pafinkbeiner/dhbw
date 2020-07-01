using Aufgabe_14.Models;
using FluentNHibernate.Mapping;

namespace Aufgabe_14.Mappings
{
    public class GenreMap: MapBase<Genre>
    {
        public GenreMap()
        {
            Table("Genres");
            Map(x => x.Name).Not.Nullable();
        }
    }
}

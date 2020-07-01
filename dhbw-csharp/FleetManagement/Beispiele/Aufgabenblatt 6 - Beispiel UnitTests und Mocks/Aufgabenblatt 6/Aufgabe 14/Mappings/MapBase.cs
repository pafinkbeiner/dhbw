using Aufgabe_14.Models;
using FluentNHibernate.Mapping;

namespace Aufgabe_14.Mappings
{
	public class MapBase<T> : ClassMap<T> where T: ModelBase
	{
		public MapBase()
		{
			Id(x => x.Id).GeneratedBy.Native();
		}
	}
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FluentNHibernate.Mapping;
using Aufgabe_13.Models;

namespace Aufgabe_13.Mappings
{
    class CustomerMap: ClassMap<Customer>
    {
        public CustomerMap()
        {
            Table("Customers");

            Id(x => x.Id);

            Map(x => x.Firstname).Length(100).Not.Nullable();
            Map(x => x.Surname).Column("Lastname").Length(100).Not.Nullable();
            Map(x => x.Gender).CustomType<Gender>().Not.Nullable();

            Component(x => x.Address, a =>
            {
                a.Map(x => x.Street).Length(100);
                a.Map(x => x.StreetNumber).Length(5);
                a.Map(x => x.PostCode).Not.Nullable();
                a.Map(x => x.City).Length(100);
            });
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_11.Models
{
    public class Employee
    {
        public string FirstName { get; set; }
        public string Surname { get; set; }
        public Gender Gender { get; set; }
        public Address Address { get; set; } = new Address();
    }
}

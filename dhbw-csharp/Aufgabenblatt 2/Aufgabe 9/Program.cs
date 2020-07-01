using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_9
{
    class Program
    {
        static void Main(string[] args)
        {
            Person person = new Person();

            person.NameChanged += Console.WriteLine;

            person.FirstName = "Donna";
            person.LastName = "Summer";

            Console.ReadKey();

        }
    }
}

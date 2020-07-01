using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace Aufgabe_6
{
    class Program
    {
        static void Main(string[] args)
        {
            Employee emp = new Employee {FirstName = "Petra", LastName = "Maier", Gender = Gender.Female};

            var serializer = new XmlSerializer(typeof(Employee));

            using (var stream = new FileStream(@"test.xml", FileMode.Create))
            {
                serializer.Serialize(stream, emp);
            }

            Employee emp1;

            using(var stream = new FileStream(@"test.xml", FileMode.Open))
            {
                emp1 = serializer.Deserialize(stream) as Employee;
            }

            Console.WriteLine("Vorname: "+emp1.FirstName+", Nachname: "+emp1.LastName+", Gender: "+emp1.Gender);

            Console.ReadKey();

        }
    }
}

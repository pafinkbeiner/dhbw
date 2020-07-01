using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_8
{
    class Program
    {
        static void Main(string[] args)
        {
            Employee emp = new Employee{FirstName = "Herbert", LastName = "Müller", Gender = Gender.Male};

            Employee empCopy;

            var formatter = new BinaryFormatter();

            using (var stream = new MemoryStream(300))
            {
                formatter.Serialize(stream, emp);

                stream.Position = 0;

                empCopy = formatter.Deserialize(stream) as Employee;
            }

            Console.WriteLine("Original: Vorname: " + emp.FirstName + ", Nachname: " + emp.LastName + ", Geschlecht: " + emp.Gender);

            Console.WriteLine("Klon: Vorname: "+empCopy.FirstName+", Nachname: "+empCopy.LastName+", Geschlecht: "+empCopy.Gender);

            Console.ReadKey();

        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_3
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Fahrzeug> array = new List<Fahrzeug>();

            array.Add(new Fahrzeug() { Kennzeichen = "KA TE 4711" });
            array.Add(new PKW(){ Kennzeichen = "KA SC 1894" });
            array.Add(new LKW() { Kennzeichen = "S OS 2342" });

            foreach (Fahrzeug f in array)
            {
                Console.WriteLine(f.Drive());

            }

            Console.ReadKey();
        }
    }
}

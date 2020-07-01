using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Aufgabe_3;

namespace Aufgabe_4
{
    class Program
    {
        static void Main(string[] args)
        {

            Fahrzeug fahrz1 = new ObjectFactory<Fahrzeug>().createInstance();
            PKW fahrz2 = new ObjectFactory<PKW>().createInstance();
            LKW fahrz3 = new ObjectFactory<LKW>().createInstance();

            //Testing - not necessary

            /*
            ObjectFactory<Fahrzeug> fahrzeugFactory = new ObjectFactory<Fahrzeug>();
            ObjectFactory<PKW> pkwFactory = new ObjectFactory<PKW>();
            ObjectFactory<LKW> lkwFactory = new ObjectFactory<LKW>();
            List<Fahrzeug> array = new List<Fahrzeug>();
            array.Add(fahrzeugFactory.createInstance());
            array.Add(pkwFactory.createInstance());
            array.Add(lkwFactory.createInstance());

            array[0].Kennzeichen = "KA TE 4711";
            array[1].Kennzeichen = "KA SC 1894";
            array[2].Kennzeichen = "S OS 2342";

            foreach (Fahrzeug f in array)
            {
                Console.WriteLine(f.Drive());

            }
            Console.ReadKey();
            */
        }
    }
}

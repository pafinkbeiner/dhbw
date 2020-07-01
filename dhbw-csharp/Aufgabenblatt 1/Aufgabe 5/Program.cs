using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_5
{
    class Program
    {
        static void Main(string[] args)
        {
            var string1 = "Es ist heute ein sehr schöner Tag in Horb am Neckar.";
            var string2 = "Diese Zeichenkette ist nicht lang, denke ich";
            var string3 = "Tabulatoren\tsind auch Leerzeichen";
            Console.WriteLine(string1.CountWords());
            Console.WriteLine(string2.CountWords());
            Console.WriteLine(string3.CountWords());
            Console.ReadKey();
        }
    }
}

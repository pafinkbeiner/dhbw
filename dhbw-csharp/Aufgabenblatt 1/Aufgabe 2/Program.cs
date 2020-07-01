using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Willkommen zu Aufgabe 2");
            while (true)
            {
                Console.Write("Eingabe: ");
                string eingabe = Console.ReadLine();
                if (eingabe == "zählen")
                {
                    Console.Write("minimaler Wert: ");
                    int minValue = Int32.Parse(Console.ReadLine());
                    Console.Write("maximaler Wert: ");
                    int maxValue = Int32.Parse(Console.ReadLine());
                    if (minValue > maxValue) throw new Exception("Bad input");
                    for (; minValue < maxValue + 1; minValue++)
                    {
                        Console.WriteLine("Aktuell Bei: {0}", minValue);
                    }
                }
                else if (eingabe == "beenden")
                {
                    break;
                }
                else if (eingabe == "hilfe")
                {
                    Console.WriteLine("Mögliche Eingaben sind: zählen / beenden / hilfe");
                }
            }
        }
    }
}

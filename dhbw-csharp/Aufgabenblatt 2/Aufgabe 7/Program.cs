using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Sockets;
using System.Reflection;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace Aufgabe_7
{
    class Program
    {
        static void Main(string[] args)
        {
            List<SalesRepresentative> salesReps;

            var serializer = new XmlSerializer(typeof(List<SalesRepresentative>));

            using (var stream = new FileStream(("vertreter.xml"), FileMode.Open))
            {
                salesReps = serializer.Deserialize(stream) as List<SalesRepresentative>;
            }

            Console.WriteLine("Liste aller Vertreter aus Baden-Württemberg, sortiert nach Umsatz:");

            GetSalesRepsFromBadenWuerttemberg(salesReps).ForEach(item =>
            {
                Console.WriteLine("Name:"+item.firstName+" "+item.lastName+", Firma: "+item.company+", Umsatz: "+item.salesVolume);
            });

            Console.WriteLine("");

            Console.WriteLine("Liste aller Vertreter, gruppiert nach Unternehmen, die mehr als 10.000,- Umsatz machen, sortiert nach Unternehmen: ");

            GetSalesRepsGroupedByCompany(salesReps).ForEach(item =>
            {
                Console.WriteLine("Name:" + item.FirstName + " " + item.LastName + ", Firma: " + item.Company + ", Umsatz: " + item.SalesVolume);
            });

            Console.WriteLine("");

            Console.WriteLine("Liste der 10 Vertreter, die am wenigsten Umsatz machen, sortiert nach Umsatz: ");

            GetTopTenLosers(salesReps).ForEach(item =>
            {
                Console.WriteLine("Name:" + item.FirstName + " " + item.LastName + ", Firma: " + item.Company + ", Umsatz: " + item.SalesVolume);
            });

            Console.ReadKey();
        }

        private static List<(string company, string lastName, string firstName, decimal salesVolume)> GetSalesRepsFromBadenWuerttemberg(List<SalesRepresentative> list)
        {
            var result = 
                (from SaleRep in list
                where SaleRep.Area == "Baden-Württemberg"
                orderby SaleRep.Company descending 
                select
                (
                    SaleRep.Company, 
                    SaleRep.LastName, 
                    SaleRep.FirstName, 
                    SaleRep.SalesVolume
                )).ToList();

            return result;
        }

        private static List<SalesRepresentative> GetSalesRepsGroupedByCompany(List<SalesRepresentative> list)
        {
            var result =
                from SalesRep in list
                where SalesRep.SalesVolume > 10000
                orderby SalesRep.SalesVolume descending
                group SalesRep by SalesRep.Company;

            List<SalesRepresentative> finalResult = new List<SalesRepresentative>();

            foreach (var group in result)
            {
                foreach (var salesRep in group)
                {
                    finalResult.Add(salesRep);
                }
            }

            return finalResult;

        }

        private static List<SalesRepresentative> GetTopTenLosers(List<SalesRepresentative> list)
        {
            var result =
                (from SalesRep in list
                orderby SalesRep.SalesVolume ascending
                select SalesRep).Take(10).ToList();

            return result;
        }

        

    }
}

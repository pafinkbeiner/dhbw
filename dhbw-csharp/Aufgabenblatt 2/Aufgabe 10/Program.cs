using System;
using System.Collections.Generic;
using System.Data.OleDb;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_10
{
    class Program
    {
        static void Main(string[] args)
        {
            var connStrBuilder = new OleDbConnectionStringBuilder
            {
                DataSource = @"beispiel.mdb",
                Provider = "Microsoft.Jet.OLEDB.4.0"
            };

            var conn = new OleDbConnection(connStrBuilder.ConnectionString);
            var command = new OleDbCommand("SELECT name, vorname FROM vertreter");

            command.Connection = conn;

            conn.Open();

            var reader = command.ExecuteReader();

            while (reader.Read())
            {
                Console.WriteLine(reader.GetString(0)+ ", "+ reader.GetString(1));
            }

            conn.Close();

            Console.ReadKey();

        }
    }
}

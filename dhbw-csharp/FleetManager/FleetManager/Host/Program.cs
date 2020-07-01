using Server;
using System;
using System.ServiceModel;
using System.ServiceModel.Description;

namespace Host
{
    class Program
    {
        static void Main(string[] args)
        {
            Uri baseAddress = new Uri("http://localhost:8733/ServerFleetManager/");

            ServiceHost selfHost = new ServiceHost(typeof(FleetService), baseAddress);

            try
            {

                selfHost.AddServiceEndpoint(typeof(IFleetService), new WSHttpBinding(), "FleetService");


                ServiceMetadataBehavior smb = new ServiceMetadataBehavior
                {
                    HttpGetEnabled = true
                };
                selfHost.Description.Behaviors.Add(smb);


                selfHost.Open();
                Console.WriteLine("The service is ready.");

                Console.WriteLine("Press <Enter> to terminate the service.");
                Console.WriteLine();
                Console.ReadLine();
                selfHost.Close();
            }
            catch (CommunicationException ce)
            {
                Console.WriteLine("An exception occurred: {0}", ce.Message);
                Console.ReadKey();
                selfHost.Abort();
            }
        }
    }
}

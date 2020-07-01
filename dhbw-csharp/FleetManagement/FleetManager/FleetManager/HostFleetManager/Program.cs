using System;
using System.ServiceModel;
using System.ServiceModel.Description;

namespace Server
{
    class Program
    {
        static void Main(string[] args)
        {
            // Step 1: Create a URI to serve as the base address.
            Uri baseAddress = new Uri("http://localhost:8733/ServerFleetManager/");


            // Step 2: Create a ServiceHost instance.
            ServiceHost selfHost = new ServiceHost(typeof(FleetService), baseAddress);

            try
            {
                // Step 3: Add a service endpoint.
                //selfHost.AddServiceEndpoint(typeof(IFleetService), new WSHttpBinding(), "FleetService");
                selfHost.AddServiceEndpoint(typeof(IFleetService), new WSHttpBinding(), "");

                // Step 4: Enable metadata exchange.
                ServiceMetadataBehavior smb = new ServiceMetadataBehavior
                {
                    HttpGetEnabled = true
                };
                selfHost.Description.Behaviors.Add(smb);

                // Step 5: Start the service.
                selfHost.Open();
                Console.WriteLine("The service is ready.");

                // Close the ServiceHost to stop the service.
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

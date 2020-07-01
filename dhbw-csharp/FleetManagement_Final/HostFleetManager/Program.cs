using Autofac;
using HostFleetManager.Interfaces;
using Server.DbConnection;
using Server.DbConnetion;
using System;
using System.ServiceModel;
using System.ServiceModel.Description;

namespace Server
{
    class Program
    {

        public static IContainer Container { get; private set; }

        static void Main(string[] args)
        {
            InitializeContainer();

            Uri baseAddress = new Uri("http://localhost:8733/Design_Time_Addresses/Server/FleetService/ ");
            ServiceHost selfHost = new ServiceHost(typeof(FleetService), baseAddress);

            try
            {
                selfHost.AddServiceEndpoint(typeof(IFleetService), new WSHttpBinding(), "");
                ServiceMetadataBehavior smb = new ServiceMetadataBehavior
                {
                    HttpGetEnabled = true
                };
                selfHost.Description.Behaviors.Add(smb);
                selfHost.Open();
                Console.WriteLine("The Fleet Service is ready.");
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

        static void InitializeContainer()
        {
            var containerBuilder = new ContainerBuilder();

            //Repositorys
            containerBuilder.RegisterType<UserRepository>().As<IUserRepository>();
            containerBuilder.RegisterType<BusinessUnitRepository>().As<IBusinessUnitRepository>();
            containerBuilder.RegisterType<VehiclesRepository>().As<IVehicleRepository>();
            containerBuilder.RegisterType<EmployeeRepository>().As<IEmployeeRepository>();
            containerBuilder.RegisterType<VehicleToEmployeeRepository>().As<IVehicleToEmployeeRepository>();


            Container = containerBuilder.Build();
        }
    }
}

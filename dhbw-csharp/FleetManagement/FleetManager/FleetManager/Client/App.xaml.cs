using Autofac;
using Client.Controller;
using Client.FleetServiceReference;
using Client.View;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace Client
{
    /// <summary>
    /// Interaktionslogik für "App.xaml"
    /// </summary>
    public partial class App : Application
    {
        public static IContainer Container { get; private set; }

        protected override void OnStartup(StartupEventArgs e)
        {
            var containerBuilder = new ContainerBuilder();

            //Add main controller
            containerBuilder.RegisterType<FleetManagementController>();

            //Add controller
            containerBuilder.RegisterType<AddBusinessAreaController>();
            containerBuilder.RegisterType<AddEmployeeController>();
            containerBuilder.RegisterType<AddUserController>();
            containerBuilder.RegisterType<BusinessAreasViewController>();
            containerBuilder.RegisterType<ChangePasswordController>();
            containerBuilder.RegisterType<CostBusinessAreaViewController>();
            containerBuilder.RegisterType<CostMonthViewController>();
            containerBuilder.RegisterType<EmployeesViewController>();
            containerBuilder.RegisterType<HomeViewController>();
            containerBuilder.RegisterType<LoginWindowController>();
            containerBuilder.RegisterType<UserViewController>();
            containerBuilder.RegisterType<VehiclesViewController>();

            //Add view
            containerBuilder.RegisterType<AddBusinessAreaWindow>();
            containerBuilder.RegisterType<AddEmployeeWindow>();
            containerBuilder.RegisterType<AddUserWindow>();
            containerBuilder.RegisterType<CostBusinessAreaView>();
            containerBuilder.RegisterType<CostMonthView>();
            containerBuilder.RegisterType<EmployeesView>();
            containerBuilder.RegisterType<FleetManagementView>();
            containerBuilder.RegisterType<HomeView>();
            containerBuilder.RegisterType<LoginWindow>();
            containerBuilder.RegisterType<UserView>();
            containerBuilder.RegisterType<VehiclesView>();

            //Add viewmodel
            containerBuilder.RegisterType<AddBusinessAreaViewModel>();
            containerBuilder.RegisterType<AddEmployeeViewModel>();
            containerBuilder.RegisterType<AddUserViewModel>();
            containerBuilder.RegisterType<BusinessAreasViewModel>();
            containerBuilder.RegisterType<ChangePasswordViewModel>();
            containerBuilder.RegisterType<CostBusinessAreaViewModel>();
            containerBuilder.RegisterType<CostMonthViewModel>();
            containerBuilder.RegisterType<EmployeesViewModel>();
            containerBuilder.RegisterType<FleetManagementViewModel>();
            containerBuilder.RegisterType<HomeViewModel>();
            containerBuilder.RegisterType<LoginViewModel>();
            containerBuilder.RegisterType<UserViewModel>();
            containerBuilder.RegisterType<VehiclesViewModel>();

            //Server
            containerBuilder.RegisterType<FleetServiceClient>();

            Container = containerBuilder.Build();

            var fleetManagementController = Container.Resolve<FleetManagementController>();

            fleetManagementController.Initialize();
        }
    }
}

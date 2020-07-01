using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Data;
using System.Linq;
using System.ServiceModel.Channels;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Navigation;
using Autofac;
using Client.FleetServiceReference;
using Client.Helper;
using Client.View;
using Client.ViewModel;

namespace Client.Controller
{
    public class FleetManagementController
    {

        private FleetManagementView fleetManagementView;
        private FleetManagementViewModel fleetManagementViewModel;
        private FleetServiceClient socket;
        private User user;

        public void Initialize()
        {
            socket = App.Container.Resolve<FleetServiceClient>();
            fleetManagementView = App.Container.Resolve<FleetManagementView>();
            fleetManagementViewModel = new FleetManagementViewModel()
            {
                LogoutCommand = new RelayCommand(ExecuteLogoutCommand),

                NewCommand = new RelayCommand(ExecuteNewCommand, BlockExecution),
                SaveCommand = new RelayCommand(ExecuteSaveCommand, BlockExecution),
                DeleteCommand = new RelayCommand(ExecuteDeleteCommand, BlockExecution),

                OpenHomeCommand = new RelayCommand(ExecuteOpenHomeCommand),
                OpenCostMonthCommand = new RelayCommand(ExecuteOpenCostMonthCommand),
                OpenCostBusinessAreaCommand = new RelayCommand(ExecuteOpenCostBusinessAreaCommand),
                OpenVehiclesCommand = new RelayCommand(ExecuteOpenVehiclesCommand),
                OpenEmployeesCommand = new RelayCommand(ExecuteOpenEmployeesCommand),
                OpenBusinessAreasCommand = new RelayCommand(ExecuteOpenBusinessAreasCommand),
                OpenUserCommand = new RelayCommand(ExecuteOpenUserCommand, IsAdminAuthorizeExecution)
            };

            Login();

        }

        private void Login()
        {
            LoginWindowController loginWindowController = App.Container.Resolve<LoginWindowController>();
            user = loginWindowController.LoginUser(socket);

            if (user != null)
            {
                fleetManagementViewModel.ActiveViewModel = App.Container.Resolve<HomeViewController>(new NamedParameter("user", user)).Initialize();
                fleetManagementView.DataContext = fleetManagementViewModel;
                fleetManagementView.ShowDialog();
            }
            else
            {
                fleetManagementView.Close();
            }
        }

        private void ExecuteLogoutCommand(object obj)
        {
            fleetManagementView.Hide();
            Login();
        }

        private void ExecuteOpenHomeCommand(object obj)
        {
            var homeViewController = new HomeViewController(user);

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewCommand, BlockExecution);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveCommand, BlockExecution);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand, BlockExecution);

            fleetManagementViewModel.ActiveViewModel = homeViewController.Initialize();
        }

        private void ExecuteOpenCostMonthCommand(object obj)
        {
            var costMonthViewController = new CostMonthViewController(socket);

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewCommand, BlockExecution);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveCommand, BlockExecution);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand, BlockExecution);

            fleetManagementViewModel.ActiveViewModel = costMonthViewController.Initialize();
        }
        private void ExecuteOpenCostBusinessAreaCommand(object obj)
        {
            var costBusinessAreaViewController = new CostBusinessAreaViewController(socket);

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewCommand, BlockExecution);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveCommand, BlockExecution);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand, BlockExecution);

            fleetManagementViewModel.ActiveViewModel = costBusinessAreaViewController.Initialize();
        }
        private void ExecuteOpenVehiclesCommand(object obj)
        {
            restartVehicleCommand();
        }


        private void ExecuteOpenEmployeesCommand(object obj)
        {
            restartEmployeeCommand();
        }

        private void ExecuteOpenBusinessAreasCommand(object obj)
        {
            restartBusinessUnitCommand();
        }

        private void ExecuteOpenUserCommand(object obj)
        {
            restartUserCommmand();
        }

        public void restartVehicleCommand()
        {
            var openVehiclesViewController = new VehiclesViewController(socket, this);

            fleetManagementViewModel.ActiveViewModel = openVehiclesViewController.Initialize();

            fleetManagementViewModel.NewCommand = new RelayCommand(openVehiclesViewController.ExecuteNewVehicleCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(openVehiclesViewController.ExecuteSaveVehicleCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(openVehiclesViewController.ExecuteDeleteVehicleCommand, openVehiclesViewController.CanExecuteDeleteCommand);
        }

        public void restartEmployeeCommand()
        {
            var employeesViewController = new EmployeesViewController(socket, this);

            fleetManagementViewModel.ActiveViewModel = employeesViewController.Initialize();

            fleetManagementViewModel.NewCommand = new RelayCommand(employeesViewController.ExecuteNewEmployeeCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(employeesViewController.ExecuteSaveEmployeeCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(employeesViewController.ExecuteDeleteEmployeeCommand, employeesViewController.CanExecuteDeleteCommand);
        }

        public void restartBusinessUnitCommand()
        {
            var businessAreasViewController = new BusinessAreasViewController(socket, this);

            fleetManagementViewModel.ActiveViewModel = businessAreasViewController.Initialize();

            fleetManagementViewModel.NewCommand = new RelayCommand(businessAreasViewController.ExecuteNewBusinessAreaCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(businessAreasViewController.ExecuteSaveBusinessAreaCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(businessAreasViewController.ExecuteDeleteBusinessAreaCommand, businessAreasViewController.CanExecuteDeleteCommand);
        }

        public void restartUserCommmand()
        {
            var userViewController = new UserViewController(socket, user, this);
            //var userViewController = App.Container.Resolve<UserViewController>(new NamedParameter("socket", socket), new NamedParameter("user", user), new NamedParameter("this", this));

            fleetManagementViewModel.ActiveViewModel = userViewController.Initialize();

            fleetManagementViewModel.NewCommand = new RelayCommand(userViewController.ExecuteNewUserCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(userViewController.ExecuteSaveUserCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(userViewController.ExecuteDeleteUserCommand, userViewController.CanExecuteDeleteCommand);
        }

        private void ExecuteNewCommand(Object obj)
        {
            //No Function
        }

        private void ExecuteSaveCommand(Object obj)
        {
            //No Function
        }

        private void ExecuteDeleteCommand(Object obj)
        {
            //No Function
        }

        private bool BlockExecution(Object obj)
        {
            return false;
        } 

        private bool IsAdminAuthorizeExecution(object obj)
        {
            if(user != null)
            {
                return user.IsAdmin;
            }
            else
            {
                return false;
            }
        }
    }
}

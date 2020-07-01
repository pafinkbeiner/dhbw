using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Navigation;
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
            socket = new FleetServiceClient();
            fleetManagementView = new FleetManagementView();
            fleetManagementViewModel = new FleetManagementViewModel()
            {
                LogoutCommand = new RelayCommand(ExecuteLogoutCommand),

                NewCommand = new RelayCommand(ExecuteNewCommand),
                SaveCommand = new RelayCommand(ExecuteSaveCommand),
                DeleteCommand = new RelayCommand(ExecuteDeleteCommand),

                OpenHomeCommand = new RelayCommand(ExecuteOpenHomeCommand),
                OpenCostMonthCommand = new RelayCommand(ExecuteOpenCostMonthCommand),
                OpenCostBusinessAreaCommand = new RelayCommand(ExecuteOpenCostBusinessAreaCommand),
                OpenVehiclesCommand = new RelayCommand(ExecuteOpenVehiclesCommand),
                OpenEmployeesCommand = new RelayCommand(ExecuteOpenEmployeesCommand),
                OpenBusinessAreasCommand = new RelayCommand(ExecuteOpenBusinessAreasCommand),
                OpenUserCommand = new RelayCommand(ExecuteOpenUserCommand)
            };

            fleetManagementViewModel.ActiveViewModel = new HomeViewController(null).Initialize();
            fleetManagementView.DataContext = fleetManagementViewModel;
            
            LoginWindowController loginWindowController = new LoginWindowController();
            user = loginWindowController.LoginUser(socket);

            if (user != null) {

                fleetManagementViewModel.ActiveViewModel = new HomeViewController(user).Initialize();
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

        }

        private void ExecuteOpenHomeCommand(object obj)
        {
            var homeViewController = new HomeViewController(user);

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand);

            fleetManagementViewModel.ActiveViewModel = homeViewController.Initialize();
        }

        private void ExecuteOpenCostMonthCommand(object obj)
        {
            var costMonthViewController = new CostMonthViewController();

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand);

            fleetManagementViewModel.ActiveViewModel = costMonthViewController.Initialize();
        }
        private void ExecuteOpenCostBusinessAreaCommand(object obj)
        {
            var costBusinessAreaViewController = new CostBusinessAreaViewController();

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand);

            fleetManagementViewModel.ActiveViewModel = costBusinessAreaViewController.Initialize();
        }
        private void ExecuteOpenVehiclesCommand(object obj)
        {
            var openVehiclesViewController = new VehiclesViewController();

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand);

            fleetManagementViewModel.ActiveViewModel = openVehiclesViewController.Initialize();
        }
        private void ExecuteOpenEmployeesCommand(object obj)
        {
            var employeesViewController = new EmployeesViewController();

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewEmployeeCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveEmployeeCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteEmployeeCommand);

            fleetManagementViewModel.ActiveViewModel = employeesViewController.Initialize();
            (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees = new ObservableCollection<Employee>(socket.GetAllEmployees());
            (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).BusinessUnits = socket.GetAllBusinessUnits().ToList();

            //Persist Entry State Employees
            (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).entryEmployees = (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees.ToList();
        }
        private void ExecuteOpenBusinessAreasCommand(object obj)
        {
            var businessAreasViewController = new BusinessAreasViewController();

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewBusinessAreaCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveBusinessAreaCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteBusinessAreaCommand);

            fleetManagementViewModel.ActiveViewModel = businessAreasViewController.Initialize();
            (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas = new ObservableCollection<BusinessUnit>(socket.GetAllBusinessUnits());

            //Persist Entry State BusinessAreas
            (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).entryBusinessArea = (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas.ToList();
        }
        private void ExecuteOpenUserCommand(object obj)
        {
            var userViewController = new UserViewController();

            fleetManagementViewModel.NewCommand = new RelayCommand(ExecuteNewUserCommand);
            fleetManagementViewModel.SaveCommand = new RelayCommand(ExecuteSaveUserCommand);
            fleetManagementViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteUserCommand);

            fleetManagementViewModel.ActiveViewModel = userViewController.Initialize();
            (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users = new ObservableCollection<User>(socket.getAllUsers());

            //Persist Entry State Users
            (fleetManagementViewModel.ActiveViewModel as UserViewModel).entryUsers = (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users.ToList();
        }

        private void ExecuteNewCommand(Object obj)
        {
            MessageBox.Show("Execute New Command");
        }

        private void ExecuteSaveCommand(Object obj)
        {
            MessageBox.Show("Execute Save Command");
        }

        private void ExecuteDeleteCommand(Object obj)
        {
            MessageBox.Show("Execute Delete Command");
        }

        ////////////////////  USER  //////////////////
        private void ExecuteNewUserCommand(Object obj)
        {
            AddUserController addUserController = new AddUserController();
            User user = addUserController.AddUser();
            if (user == null) return;
            socket.AddUser(user);
            //Fetch new Users
            fleetManagementViewModel.ActiveViewModel = new UserViewController().Initialize();
            (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users = new ObservableCollection<User>(socket.getAllUsers());
            //Change Entry List
            (fleetManagementViewModel.ActiveViewModel as UserViewModel).entryUsers = (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users.ToList();
        }

        private void ExecuteSaveUserCommand(Object obj)
        {
            if ((fleetManagementViewModel.ActiveViewModel as UserViewModel).SelectedUser != null)
            {
                //If Lists are equaly long
                if ((fleetManagementViewModel.ActiveViewModel as UserViewModel).Users.Count == (fleetManagementViewModel.ActiveViewModel as UserViewModel).entryUsers.Count)
                {
                    //Change every Input
                    for (int i = 0; i < (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users.Count; i++)
                    {
                        //if((fleetManagementViewModel.ActiveViewModel as UserViewModel).entryUsers[i] != (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users[i])
                        socket.ChangeUser((fleetManagementViewModel.ActiveViewModel as UserViewModel).entryUsers[i], (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users[i]);
                    }

                    //Fetch new Users
                    fleetManagementViewModel.ActiveViewModel = new UserViewController().Initialize();
                    (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users = new ObservableCollection<User>(socket.getAllUsers());
                    //Change Entry List
                    (fleetManagementViewModel.ActiveViewModel as UserViewModel).entryUsers = (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users.ToList();
                }
            }
        }

        private void ExecuteDeleteUserCommand(Object obj)
        {
            if ((fleetManagementViewModel.ActiveViewModel as UserViewModel).SelectedUser != null)
            {
                socket.DeleteUser((fleetManagementViewModel.ActiveViewModel as UserViewModel).SelectedUser);
                //Fetch new Users
                fleetManagementViewModel.ActiveViewModel = new UserViewController().Initialize();
                (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users = new ObservableCollection<User>(socket.getAllUsers());
                //Change Entry List
                (fleetManagementViewModel.ActiveViewModel as UserViewModel).entryUsers = (fleetManagementViewModel.ActiveViewModel as UserViewModel).Users.ToList();
            }
        }
        ///////////////////////////////////////////////
        /////////////  BUSINESSAREA  /////////////////
        private void ExecuteNewBusinessAreaCommand(Object obj)
        {
            AddBusinessAreaController addBusinessAreaController = new AddBusinessAreaController();
            BusinessUnit businessUnit = addBusinessAreaController.AddBusinessArea();
            if (businessUnit == null) return;
            socket.AddBusinessUnit(businessUnit);

            //Fetch new BusinessAreas
            fleetManagementViewModel.ActiveViewModel = new BusinessAreasViewController().Initialize();
            (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas = new ObservableCollection<BusinessUnit>(socket.GetAllBusinessUnits());

            //Persist Entry State BusinessAreas
            (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).entryBusinessArea = (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas.ToList();
        }

        private void ExecuteSaveBusinessAreaCommand(Object obj)
        {
            if ((fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).SelectedBusinessArea != null)
            {
                //If Lists are equaly long
                if ((fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas.Count == (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).entryBusinessArea.Count)
                {
                    //Change every Input
                    for (int i = 0; i < (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas.Count; i++)
                    {
                        socket.ChangeBusinessUnit((fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).entryBusinessArea[i], (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas[i]);
                    }

                    //Fetch new BusinessAreas
                    fleetManagementViewModel.ActiveViewModel = new BusinessAreasViewController().Initialize();
                    (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas = new ObservableCollection<BusinessUnit>(socket.GetAllBusinessUnits());

                    //Persist Entry State BusinessAreas
                    (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).entryBusinessArea = (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas.ToList();
                }
            }
        }

        private void ExecuteDeleteBusinessAreaCommand(Object obj)
        {
            if ((fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).SelectedBusinessArea != null)
            {
                socket.DeleteBusinessUnit((fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).SelectedBusinessArea);
                //Fetch new BusinessAreas
                fleetManagementViewModel.ActiveViewModel = new BusinessAreasViewController().Initialize();
                (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas = new ObservableCollection<BusinessUnit>(socket.GetAllBusinessUnits());

                //Persist Entry State BusinessAreas
                (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).entryBusinessArea = (fleetManagementViewModel.ActiveViewModel as BusinessAreasViewModel).BusinessAreas.ToList();
            }
        }

        ///////////////////////////////////////////////
        //////////////////  EMPLOYEE  /////////////////

        private void ExecuteNewEmployeeCommand(Object obj)
        {
            AddEmployeeController addEmployeeController = new AddEmployeeController();
            Employee employee = addEmployeeController.AddEmployee(socket);
            if (employee == null) return;
            socket.AddEmployee(employee);

            //Fetch Employees
            fleetManagementViewModel.ActiveViewModel = new EmployeesViewController().Initialize();
            (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees = new ObservableCollection<Employee>(socket.GetAllEmployees());
            (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).BusinessUnits = socket.GetAllBusinessUnits().ToList();

            //Persist Entry State Employees
            (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).entryEmployees = (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees.ToList();
        }

        private void ExecuteSaveEmployeeCommand(Object obj)
        {
            if ((fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).SelectedEmployee != null)
            {
                //If Lists are equaly long
                if ((fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees.Count == (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).entryEmployees.Count)
                {
                    //Change every Input
                    for (int i = 0; i < (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees.Count; i++)
                    {
                        socket.ChangeEmployee((fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).entryEmployees[i], (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees[i]);
                    }

                    //Fetch Employees
                    fleetManagementViewModel.ActiveViewModel = new EmployeesViewController().Initialize();
                    (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees = new ObservableCollection<Employee>(socket.GetAllEmployees());
                    (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).BusinessUnits = socket.GetAllBusinessUnits().ToList();

                    //Persist Entry State Employees
                    (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).entryEmployees = (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees.ToList();
                }
            }
        }

        private void ExecuteDeleteEmployeeCommand(Object obj)
        {
            if ((fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).SelectedEmployee != null)
            {
                socket.DeleteEmployee((fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).SelectedEmployee);
                //Fetch new BusinessAreas
                fleetManagementViewModel.ActiveViewModel = new BusinessAreasViewController().Initialize();
                (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees = new ObservableCollection<Employee>(socket.GetAllEmployees());
                (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).BusinessUnits = socket.GetAllBusinessUnits().ToList();

                //Persist Entry State BusinessAreas
                (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).entryEmployees = (fleetManagementViewModel.ActiveViewModel as EmployeesViewModel).Employees.ToList();
            }
        }
    }
}

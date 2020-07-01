using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Navigation;
using Aufgabe_12.Framework;
using Aufgabe_12_Client.CustomerServiceProxy;
using Aufgabe_12_Client.ViewModels;

namespace Aufgabe_12_Client.Controllers
{
    public class MainWindowController
    {
        private CustomerServiceClient _socket;
        public MainWindowViewModel _mViewModel { get; set; }

        public bool CanExecuteSearchCommand(object obj)
        {
            return _mViewModel.SearchQuery != null;
        }
        public bool CanExecuteDeleteCommand(object obj)
        {
            return _mViewModel.SelectedModel != null;
        }

        public void ExecuteEmptyCommand(object obj)
        {
            _mViewModel.Models.Clear();
        }

        public void ExecuteDeleteCommand(object obj)
        {
            Customer deleteCustomer = _mViewModel.SelectedModel;
            _socket.RemoveCustomer(deleteCustomer);
            ExecuteLoadCommand(obj);
        }

        public void ExecuteLoadCommand(object obj)
        {
            this.ExecuteEmptyCommand(obj);
            foreach (Customer customer in _socket.GetAllCustomers())
            {
                _mViewModel.Models.Add(customer);
            }
        }
        public void ExecuteSearchCommand(object obj)
        {
            ExecuteEmptyCommand(obj);
            if (_mViewModel.SearchQuery.Equals(""))
            {
                this.ExecuteLoadCommand(obj);
            }
            foreach (Customer customer in _socket.GetCustomers(_mViewModel.SearchQuery))
            {
                _mViewModel.Models.Add(customer);
            }
        }

        public void ExecuteNewCommand(object obj)
        {
            AddCustomerController newModel = new AddCustomerController();
            Customer newCustomer = newModel.AddCustomer();
            if (newCustomer == null) return;
            _socket.AddCustomer(newCustomer);
            ExecuteLoadCommand(obj);

        }
        public void Initialize()
        {
            _socket = new CustomerServiceClient();
            _mViewModel = new MainWindowViewModel();
            _mViewModel.LoadCommand = new RelayCommand(ExecuteLoadCommand);
            _mViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand, CanExecuteDeleteCommand);
            _mViewModel.ClearCommand = new RelayCommand(ExecuteEmptyCommand);
            _mViewModel.NewCommand = new RelayCommand(ExecuteNewCommand);
            _mViewModel.SearchCommand = new RelayCommand(ExecuteSearchCommand, CanExecuteSearchCommand);
            MainWindow mainWindow = new MainWindow();
            mainWindow.DataContext = _mViewModel;
            mainWindow.ShowDialog();
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using Aufgabe_12.Framework;
using Aufgabe_12_Client.CustomerServiceProxy;
using Aufgabe_12_Client.ViewModels;
using Aufgabe_12_Client.Views;

namespace Aufgabe_12_Client.Controllers
{
    public class AddCustomerController
    {
        private AddCustomer _mView;
        public Customer AddCustomer()
        {
            _mView = new AddCustomer();

            AddCustomerViewModel cViewModel = new AddCustomerViewModel();
            cViewModel.Model = new Customer();
            cViewModel.OkCommand = new RelayCommand(ExecuteOkCommand);
            cViewModel.CancelCommand = new RelayCommand(ExecuteCancelCommand);

            _mView.DataContext = cViewModel;
            return _mView.ShowDialog() == true ? cViewModel.Model : null;
        }

        public void ExecuteOkCommand(object obj)
        {
            _mView.DialogResult = true;
            _mView.Close();
        }
        public void ExecuteCancelCommand(object obj)
        {
            _mView.DialogResult = false;
            _mView.Close();
        }
    }
}

using Aufgabe_13.Framework;
using Aufgabe_13.Models;
using Aufgabe_13.ViewModels;
using Aufgabe_13.Views;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_13.Controllers
{
    class MainWindowController
    {
        public MainWindowViewModel mViewModel { get; set; }
        private Repository<Customer> mCustomerRepository;

        public void ExecuteAddCommand(object obj)
        {
            WindowAddController winAddCtr = new WindowAddController();
            Customer customer = winAddCtr.AddCustomer();
            if (customer != null)
            {
                mViewModel.Models.Add(customer);
                mCustomerRepository.Save(customer);

            }
        }

        public void ExecuteDeleteCommand(object obj)
        {
            var delCustomer = mViewModel.SelectedModel;

            if (mViewModel.SelectedModel != null)
            {
                mViewModel.Models.Remove(delCustomer);
                mCustomerRepository.Delete(delCustomer);
            }
        }

        public bool CanExecuteDeleteCommand(object obj)
        {
            if (mViewModel.SelectedModel != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public void Initialize()
        {
            mCustomerRepository = new Repository<Customer>(@"Database/CustomerSample.db");
            mViewModel = new MainWindowViewModel();
            mViewModel.AddCommand = new RelayCommand(ExecuteAddCommand);
            mViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand, CanExecuteDeleteCommand);
            mViewModel.Models = new ObservableCollection<Customer>(mCustomerRepository.GetAll());

            MainWindow view = new MainWindow();
            view.DataContext = mViewModel;
            view.ShowDialog();
        }
    }
}

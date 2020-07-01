using Aufgabe_11.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Aufgabe_11.Models;
using Aufgabe_11.Framework;
using Aufgabe_11.Views;
using Beispiel_1.Framework;

namespace Aufgabe_11.Controllers
{
    class MainWindowController
    {
        public MainWindowViewModel mViewModel { get; set; }

        public void ExecuteAddCommand(object obj)
        {
            WindowAddController winAddCtr = new WindowAddController();
            Employee emp = winAddCtr.AddEmployee();
            if (emp != null)
            {
                mViewModel.Models.Add(emp);
            }
        }

        public void ExecuteDeleteCommand(object obj)
        {
            if (mViewModel.SelectedModel != null)
            {
                mViewModel.Models.Remove(mViewModel.SelectedModel);
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
            mViewModel = new MainWindowViewModel();
            mViewModel.AddCommand = new RelayCommand(ExecuteAddCommand);
            mViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand, CanExecuteDeleteCommand);

            MainWindow view = new MainWindow();
            view.DataContext = mViewModel;
            view.ShowDialog();
        }
    }
}

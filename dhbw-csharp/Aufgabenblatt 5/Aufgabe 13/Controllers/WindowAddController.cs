using Aufgabe_13.Framework;
using Aufgabe_13.Models;
using Aufgabe_13.ViewModels;
using Aufgabe_13.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_13.Controllers
{
    class WindowAddController
    {
        public WindowAdd mView { get; set; }

        public void ExecuteOkCommand(object obj)
        {
            mView.DialogResult = true;
            mView.Close();
        }

        public void ExecuteCancelCommand(object obj)
        {
            mView.DialogResult = false;
            mView.Close();
        }

        public Customer AddCustomer()
        {
            mView = new WindowAdd();

            WindowAddViewModel winAdM = new WindowAddViewModel();
            winAdM.Model = new Customer();
            winAdM.OkCommand = new RelayCommand(ExecuteOkCommand);
            winAdM.CancelCommand = new RelayCommand(ExecuteCancelCommand);

            mView.DataContext = winAdM;

            if (mView.ShowDialog() == true)
            {
                return winAdM.Model;
            }
            else
            {
                return null;
            }
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Aufgabe_11.Models;
using Aufgabe_11.ViewModels;
using Aufgabe_11.Views;
using Beispiel_1.Framework;

namespace Aufgabe_11.Controllers
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

        public Employee AddEmployee()
        {
            mView = new WindowAdd();

            WindowAddViewModel winAdM = new WindowAddViewModel();
            winAdM.Model = new Employee();
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

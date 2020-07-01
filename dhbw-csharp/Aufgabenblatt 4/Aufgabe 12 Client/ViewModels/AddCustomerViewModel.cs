using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using Aufgabe_12.Framework;
using Aufgabe_12_Client.CustomerServiceProxy;

namespace Aufgabe_12_Client.ViewModels
{
    public class AddCustomerViewModel: ViewModelBase
    {
        public Customer Model { get; set; }

        public string FirstName
        {
            get => Model.FirstName;
            set
            {
                Model.FirstName = value;
                OnPropertyChanged();
            }
        }

        public string LastName
        {
            get => Model.LastName;
            set
            {
                Model.LastName = value;
                OnPropertyChanged();
            }
        }
        public ICommand OkCommand { get; set; }
        public ICommand CancelCommand { get; set; }
    }
}

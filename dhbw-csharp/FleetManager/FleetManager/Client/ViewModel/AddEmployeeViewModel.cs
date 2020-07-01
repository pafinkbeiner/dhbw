using Client.FleetServiceReference;
using Client.Helper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Client.ViewModel
{
    public class AddEmployeeViewModel: ViewModelBase
    {
        public ICommand AddCommand { get; set; }

        private Employee employee = new Employee();
        public Employee Employee
        {
            get
            {
                return employee;
            }
            set
            {
                employee = value;
                OnPropertyChanged();
            }
        }

        public List<BusinessUnit> BusinessUnits { get; set; }
    }
}

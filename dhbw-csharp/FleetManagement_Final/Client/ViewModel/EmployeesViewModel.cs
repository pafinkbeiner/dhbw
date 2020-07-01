using Client.FleetServiceReference;
using Client.Helper;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client.ViewModel
{
    public class EmployeesViewModel : ViewModelBase
    {
        public ObservableCollection<Employee> Employees { get; set; }

        private Employee selectedEmployee;
        public Employee SelectedEmployee
        {
            get => selectedEmployee;
            set
            {
                selectedEmployee = value;

                if (selectedBusinessUnit != null)
                {
                    //selectedBusinessUnit = value.BusinessUnitId;
                    SelectedBusinessUnit = BusinessUnits.Single(x => x.Id == selectedEmployee.BusinessUnitId.Id);
                }
                    

                OnPropertyChanged();
            }
        }

        public ObservableCollection<BusinessUnit> BusinessUnits { get; set; }

        private BusinessUnit selectedBusinessUnit;
        public BusinessUnit SelectedBusinessUnit
        {
            get => selectedBusinessUnit;
            set
            {
                selectedBusinessUnit = value;

                if(selectedEmployee != null)
                    selectedEmployee.BusinessUnitId = value;

                OnPropertyChanged();
            }
        }
    }
}

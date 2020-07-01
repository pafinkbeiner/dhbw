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
    public class AddBusinessAreaViewModel : ViewModelBase
    {
        public ICommand AddCommand { get; set; }

        private BusinessUnit businessUnit = new BusinessUnit();
        public BusinessUnit BusinessUnit
        {
            get
            {
                return businessUnit;
            }
            set
            {
                businessUnit = value;
                OnPropertyChanged();
            }
        }
    }
}

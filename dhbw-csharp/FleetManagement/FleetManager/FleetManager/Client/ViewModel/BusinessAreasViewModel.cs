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
    public class BusinessAreasViewModel : ViewModelBase
    {
        public  ObservableCollection<BusinessUnit> BusinessAreas{ get; set; }

        public List<BusinessUnit> entryBusinessArea { get; set; }

        private BusinessUnit selectedBusinessArea;
        public BusinessUnit SelectedBusinessArea
        {
            get => selectedBusinessArea;
            set
            {
                selectedBusinessArea = value;
                OnPropertyChanged();
            }
        }

    }
}

using Client.Helper;
using Client.Models;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client.ViewModel
{
    public class CostMonthViewModel: ViewModelBase
    {
        public ObservableCollection<CostMontlyModel> Costs { get; set; }
    }
}

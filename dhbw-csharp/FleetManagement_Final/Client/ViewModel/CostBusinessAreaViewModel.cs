using Client.Helper;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Client.Models;

namespace Client.ViewModel
{
    public class CostBusinessAreaViewModel: ViewModelBase
    {
        //public ObservableCollection<CostBusinessAreaModel> Costs { get; set; }

        private IEnumerable<CostBusinessAreaModel> _costs;
        public IEnumerable<CostBusinessAreaModel> Costs
        {
            get => _costs;
            set => _costs = value;
        }
    }
}
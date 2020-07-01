using Client.FleetServiceReference;
using Client.Helper;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client.Controller
{
    public class CostBusinessAreaViewController : SubmoduleController
    {
        private FleetServiceClient socket;
        private CostBusinessAreaViewModel costBusinessAreaViewModel;

        public override ViewModelBase Initialize()
        {
            GetData();
            costBusinessAreaViewModel = new CostBusinessAreaViewModel()
            {
                
            };
            return costBusinessAreaViewModel;
        }

        public CostBusinessAreaViewController(FleetServiceClient socket)
        {
            this.socket = socket;
        }

        private void GetData()
        {

        }
    }
}

using Client.Helper;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client.Controller
{
    public class CostMonthViewController : SubmoduleController
    {
        public override ViewModelBase Initialize()
        {
            return new CostMonthViewModel();
        }
    }
}

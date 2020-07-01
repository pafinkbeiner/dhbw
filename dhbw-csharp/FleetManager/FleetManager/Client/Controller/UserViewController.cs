using Client.FleetServiceReference;
using Client.Helper;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Client.Controller
{
    public class UserViewController : SubmoduleController
    {

        public override ViewModelBase Initialize()
        {
            return new UserViewModel();
        }

    }
}

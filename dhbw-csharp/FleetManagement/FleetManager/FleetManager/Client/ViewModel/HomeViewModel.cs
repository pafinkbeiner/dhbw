using Client.Helper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Client.ViewModel
{
    public class HomeViewModel: ViewModelBase
    {
        public ICommand ChangePasswordCommand { get; set; }
    }
}

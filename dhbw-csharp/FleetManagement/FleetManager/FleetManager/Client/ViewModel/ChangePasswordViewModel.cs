using Client.Helper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Client.ViewModel
{
    public class ChangePasswordViewModel: ViewModelBase
    {
        public string Password { get; set; } = "";
        public string RepPassword { get; set; } = "";
        public string NewPassword { get; set; } = "";
        public ICommand ChangePasswordCommand { get; set; }
    }
}

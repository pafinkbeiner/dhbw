using Client.Helper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Client.ViewModel
{
    public class LoginViewModel: ViewModelBase
    {
        public String Username { get; set; } = "";
        public String Password { get; set; } = "";
        public ICommand LoginCommand { get; set; }
    }
}

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
    public class AddUserViewModel: ViewModelBase
    {
        public ICommand AddCommand { get; set; }

        private User user = new User();
        public User User
        {
            get
            {
                return user;
            }
            set
            {
                user = value;
                OnPropertyChanged();
            }
        }
    }
}

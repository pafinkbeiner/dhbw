using Client.FleetServiceReference;
using Client.Helper;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client.ViewModel
{
    public class UserViewModel : ViewModelBase
    {
        public ObservableCollection<User> Users { get; set; }

        public List<User> entryUsers { get; set; }

        private User selectedUser;
        public User SelectedUser 
        {
            get => selectedUser;
            set
            {
                selectedUser = value;
                OnPropertyChanged();
            }
        }
    }
}

using Client.FleetServiceReference;
using Client.Helper;
using Client.View;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client.Controller
{
    public class AddUserController
    {
        public AddUserWindow addUserWindow;
        public AddUserViewModel addUserViewModel;

        public User AddUser()
        {
            addUserWindow = new AddUserWindow();
            addUserViewModel = new AddUserViewModel() 
            {
                AddCommand = new RelayCommand(ExecuteAddCommand),
            };
            addUserWindow.DataContext = addUserViewModel;
            return addUserWindow.ShowDialog() == true ? addUserViewModel.User : null;
        }

        private void ExecuteAddCommand(object obj)
        {
            addUserWindow.DialogResult = true;
            addUserWindow.Close();
        }
    }
}

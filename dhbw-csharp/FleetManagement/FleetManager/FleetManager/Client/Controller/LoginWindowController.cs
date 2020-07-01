using Client.FleetServiceReference;
using Client.Helper;
using Client.View;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Client.Controller
{
    public class LoginWindowController
    {
        private LoginViewModel loginViewModel;
        private LoginWindow loginWindow;
        private FleetServiceClient socket;
        private User user;

        public User LoginUser(FleetServiceClient socket)
        {
            this.socket = socket;
            loginWindow = new LoginWindow();
            loginViewModel = new LoginViewModel()
            {
                LoginCommand = new RelayCommand(ExecuteLoginCommand)
            };

            loginWindow.DataContext = loginViewModel;

            if (loginWindow.ShowDialog() == true)
            {
                return user;
            }
            else
            {
                return null;
            }
        }

        private void ExecuteLoginCommand(object obj)
        {
            var username = loginViewModel.Username;
            var password = loginViewModel.Password;
            user = socket.CanUserLogin(username, password);
            //user = new User() {
             //   Username = "test", Firstname = "paul", Lastname= "Finkbeiner", IsAdmin = true, Id = 0, Version = 0
            //};
            if (user != null)
            {
                loginWindow.DialogResult = true;
                loginWindow.Close();
            }
            else
            {
                MessageBox.Show("Login fehlgeschlagen");
            }
        }
    }
}

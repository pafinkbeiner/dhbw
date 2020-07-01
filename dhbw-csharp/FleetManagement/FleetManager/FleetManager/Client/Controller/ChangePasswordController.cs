using Client.FleetServiceReference;
using Client.Helper;
using Client.View;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;
using System.Windows.Navigation;

namespace Client.Controller
{
    public class ChangePasswordController
    {

        private ChangePasswordViewModel changePasswordViewModel;
        private ChangePasswordWindow changePasswordWindow;
        private FleetServiceClient socket;
        private User user;

        public void ChangePassword(FleetServiceClient socket, User user)
        {
            this.socket = socket;
            this.user = user;

            changePasswordViewModel = new ChangePasswordViewModel() 
            { 
                ChangePasswordCommand = new RelayCommand(ExecutedChangePasswordCommand)
            };
            changePasswordWindow = new ChangePasswordWindow();
            changePasswordWindow.DataContext = changePasswordViewModel;

            //Eventuell noch True/False abfangen
            changePasswordWindow.ShowDialog();
        }

        private void ExecutedChangePasswordCommand(Object obj)
        {
            var password = changePasswordViewModel.Password;
            var repPassword = changePasswordViewModel.RepPassword;
            var newPassword = changePasswordViewModel.NewPassword;

            if (newPassword != repPassword) MessageBox.Show("Passwörter stimmen nicht überein!");
            

            bool result = socket.ChangePassword(user.Username, password, newPassword);

            if (result)
            {
                changePasswordWindow.DialogResult = true;
                changePasswordWindow.Close();
            }
            else
            {
                MessageBox.Show("Login war nicht erfolgreich");
            }
        }
    }
}

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

            changePasswordWindow.ShowDialog();
        }

        private void ExecutedChangePasswordCommand(Object obj)
        {
            var password = changePasswordViewModel.Password;
            var repPassword = changePasswordViewModel.RepPassword;
            var newPassword = changePasswordViewModel.NewPassword;

            if (newPassword != repPassword) MessageBox.Show("Passwörter stimmen nicht überein!");

            bool result = false;

            if (password != String.Empty && repPassword != String.Empty && newPassword != String.Empty)
            {
                result = socket.ChangePassword(user.Username, password, newPassword);
            }
            else
            {
                changePasswordWindow.DialogResult = false;
                changePasswordWindow.Close();
            }

            if (result)
            {
                changePasswordWindow.DialogResult = true;
                changePasswordWindow.Close();
                MessageBox.Show("Das Passwort wurde erfolgreich geändert");

            }
            else
            {
                MessageBox.Show("Fehler bei der Eingabe des Passwortes!");
            }
        }
    }
}

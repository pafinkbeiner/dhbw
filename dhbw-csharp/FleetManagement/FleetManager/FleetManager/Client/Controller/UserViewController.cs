using Autofac;
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

        private FleetServiceClient socket;
        private UserViewModel userViewModel;
        private User user;
        private FleetManagementController parent;

        public override ViewModelBase Initialize()
        {
            userViewModel = new UserViewModel()
            {
                Users = new ObservableCollection<User>(socket.getAllUsers()),
                entryUsers = socket.getAllUsers().ToList()
            };
            return userViewModel;
        }

        public UserViewController(FleetServiceClient socket, User user, FleetManagementController parent)
        {
            this.socket = socket;
            this.user = user;
            this.parent = parent;
        }

        public void ExecuteNewUserCommand(Object obj)
        {
            AddUserController addUserController = App.Container.Resolve<AddUserController>();
            User user = addUserController.AddUser();
            if (user == null) return;
            var result = socket.AddUser(user);
            if (result == false) MessageBox.Show("Fehler beim hinzufügen des Benutzers!");
            parent.restartUserCommmand();
        }

        public void ExecuteSaveUserCommand(Object obj)
        {
            if (userViewModel.SelectedUser != null)
            {
                //If Lists are equaly long
                if (userViewModel.Users.Count == userViewModel.entryUsers.Count)
                {
                    //Change every Input
                    for (int i = 0; i < userViewModel.Users.Count; i++)
                    {
                        if(userViewModel.entryUsers[i] != userViewModel.Users[i])
                        {
                            var result = socket.ChangeUser(userViewModel.entryUsers[i], userViewModel.Users[i]);
                            if (result == false) MessageBox.Show("Fehler beim Ändern des Benutzers!");
                        }
                    }

                    parent.restartUserCommmand();
                }
            }
        }

        public void ExecuteDeleteUserCommand(Object obj)
        {
            if (userViewModel.SelectedUser != null)
            {
                var result = socket.DeleteUser(userViewModel.SelectedUser);
                if (result == false) MessageBox.Show("Fehler beim Löschen des Benutzers!");
                parent.restartUserCommmand();
            }
        }

        public bool CanExecuteDeleteCommand(Object obj)
        {
            return (userViewModel.SelectedUser != null) ? true : false;
        }
    }
}

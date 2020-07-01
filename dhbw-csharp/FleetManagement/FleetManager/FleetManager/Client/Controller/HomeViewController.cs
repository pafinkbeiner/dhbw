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
    public class HomeViewController: SubmoduleController
    {
        private FleetServiceClient socket;
        private User user;
        HomeViewModel homeViewModel;

        public HomeViewController(User user)
        {
            this.user = user;
        }

        public override ViewModelBase Initialize()
        {
            socket = new FleetServiceClient();
            homeViewModel = new HomeViewModel()
            {
                ChangePasswordCommand = new RelayCommand(ExecuteChangePasswordCommand)
            };

            return homeViewModel;
        }

        private void ExecuteChangePasswordCommand(Object obj)
        {
            ChangePasswordController changePasswordController = new ChangePasswordController();
            changePasswordController.ChangePassword(socket, user);
        }
    }
}

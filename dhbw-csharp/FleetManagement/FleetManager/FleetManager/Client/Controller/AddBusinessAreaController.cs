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
    public class AddBusinessAreaController
    {

        public AddBusinessAreaWindow addBusinessAreaWindow;
        public AddBusinessAreaViewModel addBusinessAreaViewModel;

        public BusinessUnit AddBusinessArea()
        {
            addBusinessAreaWindow = new AddBusinessAreaWindow();
            addBusinessAreaViewModel = new AddBusinessAreaViewModel()
            {
                AddCommand = new RelayCommand(ExecuteAddCommand),
            };
            addBusinessAreaWindow.DataContext = addBusinessAreaViewModel;
            return addBusinessAreaWindow.ShowDialog() == true ? addBusinessAreaViewModel.BusinessUnit : null;
        }

        private void ExecuteAddCommand(object obj)
        {
            addBusinessAreaWindow.DialogResult = true;
            addBusinessAreaWindow.Close();
        }

    }
}

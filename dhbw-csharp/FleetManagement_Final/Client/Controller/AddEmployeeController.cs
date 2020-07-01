using Client.FleetServiceReference;
using Client.Helper;
using Client.View;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Client.Controller
{
    public class AddEmployeeController
    {
        public AddEmployeeWindow addEmployeeWindow;
        public AddEmployeeViewModel addEmployeeViewModel;

        public Employee AddEmployee(FleetServiceClient socket)
        {
            addEmployeeWindow = new AddEmployeeWindow();
            addEmployeeViewModel = new AddEmployeeViewModel()
            {
                AddCommand = new RelayCommand(ExecuteAddCommand),
                BusinessUnits = socket.GetAllBusinessUnits().ToList()
            };
            addEmployeeWindow.DataContext = addEmployeeViewModel;
            return addEmployeeWindow.ShowDialog() == true ? addEmployeeViewModel.Employee : null;
        }

        private void ExecuteAddCommand(object obj)
        {
            addEmployeeWindow.DialogResult = true;
            addEmployeeWindow.Close();
        }

    }
}

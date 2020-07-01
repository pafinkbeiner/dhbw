using Client.FleetServiceReference;
using Client.Helper;
using Client.View;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client.Controller
{
    public class AddRelationController
    {
        public AddRelationWindow addRelationWindow;
        public AddRelationViewModel addRelationViewModel;

        public VehicleToEmployeeRelation AddRelation(FleetServiceClient socket, Vehicle vehicle)
        {
            addRelationWindow = new AddRelationWindow();
            addRelationViewModel = new AddRelationViewModel()
            {
                AddCommand = new RelayCommand(ExecuteAddCommand),
                CancelCommand = new RelayCommand(ExecuteCancelCommand),
                Employees = new ObservableCollection<Employee>(socket.GetAllEmployees()),
                Vehicle = vehicle
            };
            addRelationWindow.DataContext = addRelationViewModel;

            if (addRelationWindow.ShowDialog() == true)
            {
                var relation = addRelationViewModel.Relation;
                relation.EmployeeId = addRelationViewModel.SelectedEmployee;
                relation.VehicleId = vehicle;
                return relation;
            }
            else
            {
                return null;
            }
        }

        private void ExecuteAddCommand(object obj)
        {
            addRelationWindow.DialogResult = true;
            addRelationWindow.Close();
        }

        private void ExecuteCancelCommand(object obj)
        {
            addRelationWindow.DialogResult = false;
            addRelationWindow.Close();
        }
    }
}

using Client.FleetServiceReference;
using Client.Helper;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.ServiceModel.Channels;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Forms;

namespace Client.Controller
{
    public class VehiclesViewController : SubmoduleController
    {

        private FleetServiceClient socket;
        private VehiclesViewModel vehiclesViewModel;
        private FleetManagementController parent;

        public override ViewModelBase Initialize()
        {
            vehiclesViewModel = new VehiclesViewModel()
            {
                Vehicles = new ObservableCollection<Vehicle>(socket.GetAllVehicles()),
                entryVehicles = socket.GetAllVehicles().ToList(),
                AddEmployeeToVehicle = new RelayCommand(ExecuteAddEmployeeToVehicleCommand),
                RemoveEmployeeFromVehicle = new RelayCommand(ExecuteRemoveEmployeeFromVehicleCommand),
                vehiclesViewController = this
            };
            return vehiclesViewModel;
        }

        public VehiclesViewController(FleetServiceClient socket, FleetManagementController parent)
        {
            this.socket = socket;
            this.parent = parent;
        }

        public void ExecuteNewVehicleCommand(Object obj)
        {
            AddVehicleController addVehicleController = new AddVehicleController();
            Vehicle vehicle = addVehicleController.AddVehicle();
            if (vehicle == null) return;
            var result = socket.AddVehicle(vehicle);
            if (result == false) System.Windows.MessageBox.Show("Fehler beim Hinzufügen der Fahrzeuge!");

            parent.restartVehicleCommand();
        }

        public void ExecuteSaveVehicleCommand(Object obj)
        {
            if (vehiclesViewModel.SelectedVehicle != null)
            {
                //If Lists are equaly long
                if (vehiclesViewModel.Vehicles.Count == vehiclesViewModel.entryVehicles.Count)
                {
                    //Change every Input
                    for (int i = 0; i < vehiclesViewModel.Vehicles.Count; i++)
                    {
                        if (vehiclesViewModel.entryVehicles[i] != vehiclesViewModel.Vehicles[i])
                        {
                            var result = socket.ChangeVehicle(vehiclesViewModel.entryVehicles[i], vehiclesViewModel.Vehicles[i]);
                            if (result == false) System.Windows.MessageBox.Show("Fehler beim Ändern der Fahrzeuge!");
                        }
                    }
                    parent.restartVehicleCommand();
                }
            }
        }

        public void ExecuteDeleteVehicleCommand(Object obj)
        {

            var result = socket.DeleteVehicle(vehiclesViewModel.SelectedVehicle);
            if (result == false) System.Windows.MessageBox.Show("Fehler beim Löschen des Fahrzeuges!");
            parent.restartVehicleCommand();

        }

        public bool CanExecuteDeleteCommand(Object obj)
        {
            return (vehiclesViewModel.SelectedVehicle != null) ? true : false;
        }

        private void ExecuteAddEmployeeToVehicleCommand(Object obj)
        {
            if(vehiclesViewModel.SelectedVehicle != null)
            {
                var relation = new AddRelationController().AddRelation(socket, vehiclesViewModel.SelectedVehicle);
                var result = socket.AddVehicleToEmployeeRelation(relation);
                if (result == false) System.Windows.MessageBox.Show("Fehler beim Hinzufügen der Relation");
            }

            parent.restartVehicleCommand();
        }

        private void ExecuteRemoveEmployeeFromVehicleCommand(Object obj)
        {
            if (vehiclesViewModel.SelectedVehicleToEmployeeRelation != null)
            {
                DialogResult dialogResult = (DialogResult)System.Windows.MessageBox.Show("Sind Sie sicher, dass Sie die Verknüpfung zum ausgewählten Mitarbeiter entfernen wollen?", "Relation Löschen", (MessageBoxButton)MessageBoxButtons.YesNo);
                if(dialogResult == DialogResult.Yes)
                {
                    var result = socket.DeleteVehicleToEmployeeRelation(vehiclesViewModel.SelectedVehicleToEmployeeRelation);
                    if (result == false) System.Windows.MessageBox.Show("Fehler beim Löschen der Relation");
                }
                else if (dialogResult == DialogResult.No)
                {
                    return;
                }

                parent.restartVehicleCommand();
            }
        }

        public void GetUsersToVehicle(Vehicle vehicle)
        {
            vehiclesViewModel.VehicleToEmployeeRelations.Clear();

            var relation = socket.GetRelationFromVehicle(vehicle);

            if (relation != null)
            {
                foreach (var rel in relation)
                {
                    vehiclesViewModel.VehicleToEmployeeRelations.Add(rel);
                }
            }

        } 
    }
}

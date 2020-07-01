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
    public class BusinessAreasViewController : SubmoduleController
    {

        private FleetServiceClient socket;
        private BusinessAreasViewModel businessAreaViewModel;
        private FleetManagementController parent;

        public override ViewModelBase Initialize()
        {
            businessAreaViewModel = new BusinessAreasViewModel()
            {
                BusinessAreas = new ObservableCollection<BusinessUnit>(socket.GetAllBusinessUnits()),
                entryBusinessArea = socket.GetAllBusinessUnits().ToList()
            };
            return businessAreaViewModel;
        }

        public BusinessAreasViewController(FleetServiceClient socket, FleetManagementController parent)
        {
            this.socket = socket;
            this.parent = parent;
        }

        public void ExecuteNewBusinessAreaCommand(Object obj)
        {
            AddBusinessAreaController addBusinessAreaController = App.Container.Resolve<AddBusinessAreaController>();
            BusinessUnit businessUnit = addBusinessAreaController.AddBusinessArea();
            if (businessUnit == null) return;
            var result = socket.AddBusinessUnit(businessUnit);
            if (result == false) MessageBox.Show("Fehler beim Hinzufügen des Geschäftsbereiches!");
            parent.restartBusinessUnitCommand();
        }

        public void ExecuteSaveBusinessAreaCommand(Object obj)
        {
            if (businessAreaViewModel.SelectedBusinessArea != null)
            {
                //If Lists are equaly long
                if (businessAreaViewModel.BusinessAreas.Count == businessAreaViewModel.entryBusinessArea.Count)
                {
                    //Change every Input
                    for (int i = 0; i < businessAreaViewModel.BusinessAreas.Count; i++)
                    {
                        if(businessAreaViewModel.entryBusinessArea[i] != businessAreaViewModel.BusinessAreas[i])
                        {
                            var result = socket.ChangeBusinessUnit(businessAreaViewModel.entryBusinessArea[i], businessAreaViewModel.BusinessAreas[i]);
                            if (result == false) MessageBox.Show("Fehler beim Ändern des Geschäftsbereiches!");
                        }
                    }
                    parent.restartBusinessUnitCommand();
                }
            }
        }

        public void ExecuteDeleteBusinessAreaCommand(Object obj)
        {
            if (businessAreaViewModel.SelectedBusinessArea != null)
            {
                var result = socket.DeleteBusinessUnit(businessAreaViewModel.SelectedBusinessArea);
                if (result == false) MessageBox.Show("Fehler beim Löschen des Geschäftsbereiches!");
                parent.restartBusinessUnitCommand();
            }
        }

        public bool CanExecuteDeleteCommand(Object obj)
        {
            return (businessAreaViewModel.SelectedBusinessArea != null) ? true : false;
        }

    }
}

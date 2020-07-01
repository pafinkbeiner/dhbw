﻿using Client.FleetServiceReference;
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
    public class AddVehicleController
    {
        public AddVehicleWindow addVehicleWindow;
        public AddVehicleViewModel addVehicleViewModel;

        public Vehicle AddVehicle()
        {
            addVehicleWindow = new AddVehicleWindow();
            addVehicleViewModel = new AddVehicleViewModel()
            {
                AddCommand = new RelayCommand(ExecuteAddCommand),
            };
            addVehicleWindow.DataContext = addVehicleViewModel;
            return addVehicleWindow.ShowDialog() == true ? addVehicleViewModel.Vehicle : null;
        }

        private void ExecuteAddCommand(object obj)
        {
            addVehicleWindow.DialogResult = true;
            addVehicleWindow.Close();
        }
    }
}

﻿using Autofac;
using Client.Controller;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace Client
{
    /// <summary>
    /// Interaktionslogik für "App.xaml"
    /// </summary>
    public partial class App : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            var builder = new ContainerBuilder();

            var fleetManagementController = new FleetManagementController();
            fleetManagementController.Initialize();
        }
    }
}

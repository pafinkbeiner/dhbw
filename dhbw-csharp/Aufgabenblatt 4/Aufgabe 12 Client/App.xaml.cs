using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;
using Aufgabe_12_Client.Controllers;

namespace Aufgabe_12_Client
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            MainWindowController mWCtr = new MainWindowController();
            mWCtr.Initialize();
        }
    }
}

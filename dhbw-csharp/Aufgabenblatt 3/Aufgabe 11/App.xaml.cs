using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;
using Aufgabe_11.Controllers;

namespace Aufgabe_11
{
    /// <summary>
    /// Interaktionslogik für "App.xaml"
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

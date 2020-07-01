using System.Windows;
using Aufgabe_14.Interfaces;

namespace Aufgabe_14.Views
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window, IView
    {
        public MainWindow()
        {
            InitializeComponent();
        }
    }
}

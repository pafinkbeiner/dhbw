using System.Windows;
using Aufgabe_14.Interfaces;

namespace Aufgabe_14.Views
{
    /// <summary>
    /// Interaction logic for AddMovieWindow.xaml
    /// </summary>
    public partial class AddMovieWindow : Window, IView
    {
        public AddMovieWindow()
        {
            InitializeComponent();
        }
    }
}

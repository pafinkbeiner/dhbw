using Aufgabe14.Framework;
using Aufgabe14.Interfaces.Controller;
using Aufgabe14.Interfaces.ViewModels;
using Aufgabe14.Models;
using Aufgabe14.Views;
using Autofac;

namespace Aufgabe14.Controller
{
    public class AddGenreViewController : IAddGenreViewController
    {
        private AddGenreView addGenreView;
        private IAddGenreViewModel addGenreViewModel;
        public Genre AddGenre()
        {
            addGenreView = new AddGenreView();
            addGenreViewModel = App.Container.Resolve<IAddGenreViewModel>();
            addGenreViewModel.Model = new Genre();
            addGenreViewModel.OkCommand = new RelayCommand(ExecuteOkCommand);
            addGenreViewModel.CancelCommand = new RelayCommand(ExecuteCancelCommand);

            addGenreView.DataContext = addGenreViewModel;
            return addGenreView.ShowDialog() == true ? addGenreViewModel.Model : null;
        }

        private void ExecuteOkCommand(object obj)
        {
            addGenreView.DialogResult = true;
            addGenreView.Close();
        }

        private void ExecuteCancelCommand(object obj)
        {
            addGenreView.DialogResult = false;
            addGenreView.Close();
        }
    }
}

using Aufgabe14.Framework;
using Aufgabe14.Interfaces.Controller;
using Aufgabe14.Interfaces.ViewModels;
using Aufgabe14.Models;
using Aufgabe14.Views;
using Autofac;

namespace Aufgabe14.Controller
{
    public class AddMovieViewController : IAddMovieViewController
    {
        private AddMovieView addMovieView;
        private IAddMovieViewModel addMovieViewModel;
        public Movie AddMovie()
        {
            addMovieView = new AddMovieView();
            addMovieViewModel = App.Container.Resolve<IAddMovieViewModel>();
            addMovieViewModel.Model = new Movie();
            addMovieViewModel.OkCommand = new RelayCommand(ExecuteOkCommand);
            addMovieViewModel.CancelCommand = new RelayCommand(ExecuteCancelCommand);

            addMovieView.DataContext = addMovieViewModel;
            return addMovieView.ShowDialog() == true ? addMovieViewModel.Model : null;
        }

        private void ExecuteOkCommand(object obj)
        {
            addMovieView.DialogResult = true;
            addMovieView.Close();
        }

        private void ExecuteCancelCommand(object obj)
        {
            addMovieView.DialogResult = false;
            addMovieView.Close();
        }
    }
}

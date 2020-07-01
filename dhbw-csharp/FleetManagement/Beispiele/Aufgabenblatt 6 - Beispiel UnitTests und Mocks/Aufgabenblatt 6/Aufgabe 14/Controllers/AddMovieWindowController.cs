using System.Collections.Generic;
using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;
using Aufgabe_14.Models;
using Aufgabe_14.ViewModels;
using Aufgabe_14.Views;
using Autofac;

namespace Aufgabe_14.Controllers
{
    public class AddMovieWindowController: IController
    {
	    private AddMovieWindow addMovieWindow;

	    public Movie AddMovie(List<Genre> genres)
        {
            var temp = new List<string>();
            foreach (var genre in genres)
            {
                temp.Add(genre.Name);
            }

            var addMovieViewModel = App.Container.Resolve<AddMovieWindowViewModel>();
            addMovieViewModel.Model = new Movie
            {
                Genre = new Genre()
            };
            addMovieViewModel.OkCommand = new RelayCommand(ExecuteOkCommand);
            addMovieViewModel.CancelCommand = new RelayCommand(ExecuteCancelCommand);
            addMovieViewModel.Genres = genres;
            addMovieViewModel.GenreNames = temp;

            addMovieWindow = App.Container.Resolve<AddMovieWindow>();
            addMovieWindow.DataContext = addMovieViewModel;
            return addMovieWindow.ShowDialog() == true ? addMovieViewModel.Model : null;
        }

	    private void ExecuteOkCommand(object obj)
	    {
		    addMovieWindow.DialogResult = true;
		    addMovieWindow.Close();
	    }

	    private void ExecuteCancelCommand(object obj)
	    {
		    addMovieWindow.DialogResult = false;
		    addMovieWindow.Close();
	    }
    }
}

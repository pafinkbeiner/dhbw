using Aufgabe14.Framework;
using Aufgabe14.Interfaces.Controller;
using Aufgabe14.Interfaces.Infrastructure;
using Aufgabe14.Interfaces.Models;
using Aufgabe14.Interfaces.ViewModels;
using Aufgabe14.ViewModels;
using Aufgabe14.Views;
using Autofac;

namespace Aufgabe14.Controller
{
    public class MainWindowController : IMainWindowController
    {
        private IMainWindowViewModel mainWindowViewModel;

        private IRepository<IMovie> repositoryMovie;
        private IRepository<IGenre> repositoryGenre;
        public void Initialize(IRepository<IMovie> movieRepo, IRepository<IGenre> genreRepo, bool isInTestMode)
        {
            repositoryMovie = movieRepo;
            repositoryGenre = genreRepo;
            if (!isInTestMode)
            {
                var view = new MainWindow();
                mainWindowViewModel = App.Container.Resolve<IMainWindowViewModel>();
                mainWindowViewModel.OpenGenreCommand = new RelayCommand(ExecuteOpenGenreCommand);
                mainWindowViewModel.OpenMovieCommand = new RelayCommand(ExecuteOpenMovieCommand);
                mainWindowViewModel.AddCommand = new RelayCommand(ExecuteAddCommand);
                mainWindowViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand, CanExecuteDeleteCommand);
                view.DataContext = mainWindowViewModel;
                ExecuteOpenMovieCommand(null);

                view.ShowDialog();
            }
        }
        
        public bool SafeDatabase(IRepository<IMovie> movieRepo, IRepository<IGenre> genreRepo, object obj)
        {
            if (movieRepo == null && genreRepo != null)
            {
                return repositoryGenre.Save((IGenre)obj);
            }
            return repositoryMovie.Save((IMovie)obj);
        }

        public bool DeleteDatabase(IRepository<IMovie> movieRepo, IRepository<IGenre> genreRepo, object obj)
        {
            if (movieRepo == null && genreRepo != null)
            {
                return repositoryGenre.Delete((IGenre)obj);
            }
            return repositoryMovie.Delete((IMovie)obj);
        }

        private void ExecuteAddCommand(object obj)
        {
            switch (mainWindowViewModel.ActiveViewModel)
            {
                case MovieViewModel mvm:
                    var addMovieModel = App.Container.Resolve<IAddMovieViewController>();
                    var newMovie = addMovieModel.AddMovie();
                    if (newMovie is null) return;
                    mvm.MovieModels.Add(newMovie);
                    SafeDatabase(repositoryMovie, null, newMovie);
                    UpdateMovieList();
                    break;
                case GenreViewModel gvm:
                    var addGenreModel = App.Container.Resolve<IAddGenreViewController>();
                    var newGenre = addGenreModel.AddGenre();
                    if (newGenre is null) return;
                    gvm.GenreModels.Add(newGenre);
                    SafeDatabase(null, repositoryGenre, newGenre);
                    UpdateGenreList();
                    break;
            }
        }

        private void ExecuteDeleteCommand(object obj)
        {
            switch (mainWindowViewModel.ActiveViewModel)
            {
                case MovieViewModel mvm:
                    var movieModel = mvm.ActualModel;
                    if (movieModel == null) return;
                    mvm.MovieModels.Remove(movieModel);
                    DeleteDatabase(repositoryMovie, null, movieModel);
                    UpdateMovieList();
                    break;
                case GenreViewModel gvm:
                    var genreModel = gvm.ActiveModel;
                    if (genreModel == null) return;
                    gvm.GenreModels.Remove(genreModel);
                    DeleteDatabase(null, repositoryGenre, genreModel);
                    UpdateGenreList();
                    break;
            }
        }

        private bool CanExecuteDeleteCommand(object obj)
        {
            switch (mainWindowViewModel.ActiveViewModel)
            {
                case MovieViewModel mvm:
                    return mvm.ActualModel != null;
                case GenreViewModel gvm:
                    return gvm.ActiveModel != null;
            }
            return false;
        }

        private void ExecuteOpenGenreCommand(object obj)
        {
            var genreViewController = App.Container.Resolve<IGenreViewController>();
            mainWindowViewModel.ActiveViewModel = genreViewController.Initialize();
            repositoryGenre.GetAll().ForEach(genre =>
            {
                (mainWindowViewModel.ActiveViewModel as GenreViewModel).GenreModels.Add(genre);
            });
        }
        private void ExecuteOpenMovieCommand(object obj)
        {
            var moviesViewController = App.Container.Resolve<IMovieViewController>();
            mainWindowViewModel.ActiveViewModel = moviesViewController.Initialize();
            repositoryMovie.GetAll().ForEach(movie =>
            {
                (mainWindowViewModel.ActiveViewModel as MovieViewModel).MovieModels.Add(movie);
            });
        }
        private void UpdateMovieList()
        {
            (mainWindowViewModel.ActiveViewModel as MovieViewModel).MovieModels.Clear();
            repositoryMovie.GetAll().ForEach(m =>
            {
                (mainWindowViewModel.ActiveViewModel as MovieViewModel).MovieModels.Add(m);
            });
        }
        private void UpdateGenreList()
        {
            (mainWindowViewModel.ActiveViewModel as GenreViewModel).GenreModels.Clear();
            repositoryGenre.GetAll().ForEach(m =>
            {
                (mainWindowViewModel.ActiveViewModel as GenreViewModel).GenreModels.Add(m);
            });
        }
    }
}

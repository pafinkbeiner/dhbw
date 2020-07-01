using System.Collections.ObjectModel;
using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;
using Aufgabe_14.Models;
using Aufgabe_14.ViewModels;
using Aufgabe_14.Views;
using Autofac;

namespace Aufgabe_14.Controllers
{
    class MainWindowController: IController
    {
        private MainWindowViewModel mMainWindowViewModel;
        private IRepository<Movie> mMovieRepository;
        private IRepository<Genre> mGenreRepository;

        public void Initialize()
        {
            mMovieRepository = App.Container.Resolve<IRepository<Movie>>();
            mGenreRepository = App.Container.Resolve<IRepository<Genre>>();
            var view = App.Container.Resolve<MainWindow>();
            var movieViewController = App.Container.Resolve<MovieViewController>();
            mMainWindowViewModel = App.Container.Resolve<MainWindowViewModel>();
            mMainWindowViewModel.ActiveViewModel = movieViewController.Initialize();
            mMainWindowViewModel.OpenMovieCommand = new RelayCommand(ExecuteOpenMovieCommand);
            mMainWindowViewModel.OpenGenreCommand = new RelayCommand(ExecuteOpenGenreCommand);
            mMainWindowViewModel.AddCommand = new RelayCommand(ExecuteAddCommand);
            mMainWindowViewModel.DeleteCommand = new RelayCommand(ExecuteDeleteCommand, CanExecuteDeleteCommand);

            var tempViewModel = (MovieViewModel) mMainWindowViewModel.ActiveViewModel;
            tempViewModel.Models = new ObservableCollection<Movie>(mMovieRepository.GetAll());
            mMainWindowViewModel.ActiveViewModel = tempViewModel;
            view.DataContext = mMainWindowViewModel;
            view.ShowDialog();
        }

        private void ExecuteOpenMovieCommand(object obj)
        {
            var movieViewController = App.Container.Resolve<MovieViewController>();
            mMainWindowViewModel.ActiveViewModel = movieViewController.Initialize();
            var tempViewModel = (MovieViewModel)mMainWindowViewModel.ActiveViewModel;
            tempViewModel.Models = new ObservableCollection<Movie>(mMovieRepository.GetAll());
            mMainWindowViewModel.ActiveViewModel = tempViewModel;
        }

        private void ExecuteOpenGenreCommand(object obj)
        {
            var genreViewController = App.Container.Resolve<GenreViewController>();
            mMainWindowViewModel.ActiveViewModel = genreViewController.Initialize();
            var tempViewModel = (GenreViewModel)mMainWindowViewModel.ActiveViewModel;
            tempViewModel.Models = new ObservableCollection<Genre>(mGenreRepository.GetAll());
            mMainWindowViewModel.ActiveViewModel = tempViewModel;
        }

        private void ExecuteAddCommand(object obj)
        {
            if (mMainWindowViewModel.ActiveViewModel.ToString().Contains("MovieViewModel")) { 
                var addMovieWindowController = App.Container.Resolve<AddMovieWindowController>();
                var ret = addMovieWindowController.AddMovie(mGenreRepository.GetAll());
                if (ret != null && ret.Genre.Name != null && ret.Title != null)
                {
                    var tempViewModel = (MovieViewModel)mMainWindowViewModel.ActiveViewModel;
                    tempViewModel.Models.Add(ret);
                    mMainWindowViewModel.ActiveViewModel = tempViewModel;
                    mMovieRepository.Save(ret);
                }
            }
            else
            {
                var addGenreWindowController = App.Container.Resolve<AddGenreWindowController>();
                var ret = addGenreWindowController.AddGenre();
                if (ret != null && ret.Name != null)
                {
                    var tempViewModel = (GenreViewModel)mMainWindowViewModel.ActiveViewModel;
                    tempViewModel.Models.Add(ret);
                    mMainWindowViewModel.ActiveViewModel = tempViewModel;
                    mGenreRepository.Save(ret);
                }
            }
        }

        private void ExecuteDeleteCommand(object obj)
        {
            if (mMainWindowViewModel.ActiveViewModel.ToString().Contains("MovieViewModel"))
            {
                var tempViewModel = (MovieViewModel)mMainWindowViewModel.ActiveViewModel;
                mMovieRepository.Delete(tempViewModel.SelectedModel);
                tempViewModel.Models.Remove(tempViewModel.SelectedModel);
                mMainWindowViewModel.ActiveViewModel = tempViewModel;
            }
            else
            {
                var tempViewModel = (GenreViewModel)mMainWindowViewModel.ActiveViewModel;
                var movies = mMovieRepository.GetAll();
                movies.RemoveAll(movie => movie.Genre.Name != tempViewModel.SelectedModel.Name);
                foreach (var movie in movies)
                {
                    mMovieRepository.Delete(movie);
                }
                mGenreRepository.Delete(tempViewModel.SelectedModel);
                tempViewModel.Models.Remove(tempViewModel.SelectedModel);
                mMainWindowViewModel.ActiveViewModel = tempViewModel;
            }
        }

        private bool CanExecuteDeleteCommand(object obj)
        {
            if (mMainWindowViewModel.ActiveViewModel.ToString().Contains("MovieViewModel"))
            {
                var tempViewModel = (MovieViewModel)mMainWindowViewModel.ActiveViewModel;
                return tempViewModel.SelectedModel != null;
            }
            else
            {
                var tempViewModel = (GenreViewModel) mMainWindowViewModel.ActiveViewModel;
                return tempViewModel.SelectedModel != null;
            }
        }
    }
}

using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Windows.Input;
using Aufgabe14.Infrastructure;
using Aufgabe14.Interfaces.Models;
using Aufgabe14.Interfaces.ViewModels;
using Aufgabe14.Models;

namespace Aufgabe14.ViewModels
{
    public class AddMovieViewModel : ViewModelBase, IOkCancelCommand, IAddMovieViewModel
    {
        private readonly Repository<IGenre> genreRepository = new Repository<IGenre>(@"Database/Movies.db");
        private ObservableCollection<IMovie> observableCollection = new ObservableCollection<IMovie>();
        public Movie Model { get; set; }
        public ICommand OkCommand { get; set; }
        public ICommand CancelCommand { get; set; }
        public List<IGenre> Genres => genreRepository.GetAll();

        public ObservableCollection<IMovie> Movies
        {
            get => observableCollection;
            set
            {
                if (value == observableCollection) return;
                observableCollection = value;
                OnPropertyChanged();
            }
        }
        public string Titel
        {
            get => Model.Titel;
            set
            {
                Model.Titel = value;
                OnPropertyChanged();
            }
        }

        public Genre Genre
        {
            get => Model.Genre;
            set
            {
                if (value == Model.Genre) return;
                Model.Genre = value;
                OnPropertyChanged();
            }
        }
    }
}

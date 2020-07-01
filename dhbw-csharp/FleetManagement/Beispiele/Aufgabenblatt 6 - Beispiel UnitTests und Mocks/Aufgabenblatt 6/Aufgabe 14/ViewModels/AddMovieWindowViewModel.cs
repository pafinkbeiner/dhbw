using System.Collections.Generic;
using System.Windows.Input;
using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;
using Aufgabe_14.Models;

namespace Aufgabe_14.ViewModels
{
    public class AddMovieWindowViewModel: ViewModelBase, IViewModel
    {
        public Movie Model { get; set; }
        public ICommand OkCommand { get; set; }
        public ICommand CancelCommand { get; set; }
        public List<string> GenreNames { get; set; }
        public List<Genre> Genres { get; set; }

        public string Name
        {
            get { return Model == null ? null : Model.Title;}
            set
            {
                if (Model == null || Model.Title == value)
                    return;

                Model.Title = value;
                OnPropertyChanged();
            }
        }

        public string Genre
        {
            get
            {
                if (Model == null || Model.Genre == null)
                    return null;
                

                return Model.Genre.Name;
                
            }
            set
            {
                if (Model == null || Model.Genre == null || Model.Genre.Name == value)
                    return;

                foreach (var genre in Genres)
                {
                    if (genre.Name == value)
                    {
                        Model.Genre = genre;
                    }
                }
                OnPropertyChanged();
            }
        }
    }
}

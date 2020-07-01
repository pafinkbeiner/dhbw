using System.Collections.ObjectModel;
using Aufgabe14.Infrastructure;
using Aufgabe14.Interfaces.Models;
using Aufgabe14.Interfaces.ViewModels;
using Aufgabe14.Models;

namespace Aufgabe14.ViewModels
{
    public class GenreViewModel : ViewModelBase, IGenreViewModel
    {
        private Genre activeModel;
        public ObservableCollection<IGenre> GenreModels { get; set; } = new ObservableCollection<IGenre>();
        public Genre ActiveModel
        {
            get => activeModel;
            set
            {
                if (Equals(value, activeModel)) return;
                activeModel = value;
                OnPropertyChanged();
            }
        }
    }
}

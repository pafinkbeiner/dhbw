using System.Collections.ObjectModel;
using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;
using Aufgabe_14.Models;

namespace Aufgabe_14.ViewModels
{
    public class MovieViewModel: ViewModelBase, IViewModel
    {

	    public ObservableCollection<Movie> Models { get; set; }

        private Movie _selectedModel;
        public Movie SelectedModel
        {
            get => _selectedModel;
            set
            {
                if (_selectedModel == value)
                    return;

                _selectedModel = value;
                OnPropertyChanged();
            }
        }

    }
}

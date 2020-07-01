using System.Collections.ObjectModel;
using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;
using Aufgabe_14.Models;

namespace Aufgabe_14.ViewModels
{
    public class GenreViewModel: ViewModelBase, IViewModel
    {
	    public ObservableCollection<Genre> Models { get; set; }

        private Genre _selectedModel;
        public Genre SelectedModel
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

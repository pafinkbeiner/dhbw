using System.Windows.Input;
using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;
using Aufgabe_14.Models;

namespace Aufgabe_14.ViewModels
{
    public class AddGenreWindowViewModel: ViewModelBase, IViewModel
    {
        public Genre Model { get; set; }
        public ICommand OkCommand { get; set; }
        public ICommand CancelCommand { get; set; }

        public string Name
        {
            get { return Model == null ? null : Model.Name;}
            set
            {
                if (Model == null || Model.Name == value)
                    return;

                Model.Name = value;
                OnPropertyChanged();
            }
        }
    }
}

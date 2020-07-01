using System.Windows.Input;
using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;

namespace Aufgabe_14.ViewModels
{
    public class MainWindowViewModel : ViewModelBase, IViewModel
    {
        private ViewModelBase mActiveViewModel;
        public ICommand OpenMovieCommand { get; set; }
        public ICommand OpenGenreCommand { get; set; }
        public ICommand AddCommand { get; set; }
        public ICommand DeleteCommand { get; set; }

        public ViewModelBase ActiveViewModel
        {
            get { return mActiveViewModel; }
            set
            {
                if (mActiveViewModel == value)
                    return;

                mActiveViewModel = value;
                OnPropertyChanged();
            }
        }
    }
}

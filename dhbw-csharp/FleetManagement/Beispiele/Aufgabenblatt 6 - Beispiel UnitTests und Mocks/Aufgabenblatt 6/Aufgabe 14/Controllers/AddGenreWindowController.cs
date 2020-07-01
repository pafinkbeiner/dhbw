using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;
using Aufgabe_14.Models;
using Aufgabe_14.ViewModels;
using Aufgabe_14.Views;
using Autofac;

namespace Aufgabe_14.Controllers
{
    public class AddGenreWindowController: IController
    {
	    private AddGenreWindow addGenreView;

	    public Genre AddGenre()
        {
            var addGenreViewModel = App.Container.Resolve<AddGenreWindowViewModel>();

            addGenreViewModel.Model = new Genre();
            addGenreViewModel.OkCommand = new RelayCommand(ExecuteOkCommand);
            addGenreViewModel.CancelCommand = new RelayCommand(ExecuteCancelCommand);
            addGenreView = App.Container.Resolve<AddGenreWindow>();
            addGenreView.DataContext = addGenreViewModel;
            return addGenreView.ShowDialog() == true ? addGenreViewModel.Model : null;
        }

        private void ExecuteOkCommand(object obj)
        {
	        addGenreView.DialogResult = true;
	        addGenreView.Close();
        }

        private void ExecuteCancelCommand(object obj)
        {
	        addGenreView.DialogResult = false;
	        addGenreView.Close();
        }
    }
}

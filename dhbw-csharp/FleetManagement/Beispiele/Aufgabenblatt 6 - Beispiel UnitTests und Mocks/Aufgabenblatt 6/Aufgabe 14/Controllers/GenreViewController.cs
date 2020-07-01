using Aufgabe_14.Frameworks;
using Aufgabe_14.ViewModels;
using Autofac;

namespace Aufgabe_14.Controllers
{
    public class GenreViewController: SubmoduleController
    {
        public override ViewModelBase Initialize()
        {
            return App.Container.Resolve<GenreViewModel>();
        }
    }
}

using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;

namespace Aufgabe_14.Controllers
{
    public abstract class SubmoduleController: IController
    {
        public abstract ViewModelBase Initialize();
    }
}

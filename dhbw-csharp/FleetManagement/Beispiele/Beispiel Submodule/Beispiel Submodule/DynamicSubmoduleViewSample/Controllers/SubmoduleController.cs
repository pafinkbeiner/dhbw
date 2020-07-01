using DynamicSubmoduleViewSample.Infrastructure;

namespace DynamicSubmoduleViewSample.Controllers
{
	public abstract class SubmoduleController
	{
		public abstract ViewModelBase Initialize();
	}
}
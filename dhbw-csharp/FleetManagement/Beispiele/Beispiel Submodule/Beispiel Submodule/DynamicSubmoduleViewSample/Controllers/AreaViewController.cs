using DynamicSubmoduleViewSample.Infrastructure;
using DynamicSubmoduleViewSample.ViewModels;

namespace DynamicSubmoduleViewSample.Controllers
{
	public class AreaViewController : SubmoduleController
	{
		public override ViewModelBase Initialize()
		{
			return new AreaViewModel();
		}
	}
}
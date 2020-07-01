using DynamicSubmoduleViewSample.Infrastructure;
using DynamicSubmoduleViewSample.ViewModels;

namespace DynamicSubmoduleViewSample.Controllers
{
	public class CustomerViewController : SubmoduleController
	{
		public override ViewModelBase Initialize()
		{
			return new CustomerViewModel();
		}
	}
}
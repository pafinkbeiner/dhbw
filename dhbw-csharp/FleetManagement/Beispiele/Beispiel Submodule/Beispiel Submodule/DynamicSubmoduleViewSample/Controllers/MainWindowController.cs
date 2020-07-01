using DynamicSubmoduleViewSample.Infrastructure;
using DynamicSubmoduleViewSample.ViewModels;

namespace DynamicSubmoduleViewSample.Controllers
{
	public class MainWindowController
	{
		private MainWindowViewModel mMainWindowViewModel;

		public void Initialize()
		{
			var view = new MainWindow();
			mMainWindowViewModel = new MainWindowViewModel
			{
				OpenAreaCommand = new RelayCommand(ExecuteOpenAreaCommand),
				OpenCustomerCommand = new RelayCommand(ExecuteOpenCustomerCommand)
			};
			view.DataContext = mMainWindowViewModel;

			view.ShowDialog();
		}

		private void ExecuteOpenCustomerCommand(object obj)
		{
			var customerViewController = new CustomerViewController();
			mMainWindowViewModel.ActiveViewModel = customerViewController.Initialize();
		}

		private void ExecuteOpenAreaCommand(object obj)
		{
			var areaViewController = new AreaViewController();
			mMainWindowViewModel.ActiveViewModel = areaViewController.Initialize();
		}
	}
}
using System.Windows.Input;
using DynamicSubmoduleViewSample.Infrastructure;

namespace DynamicSubmoduleViewSample.ViewModels
{
	public class MainWindowViewModel : ViewModelBase
	{
		private ViewModelBase mActiveViewModel;
		public ICommand OpenCustomerCommand { get; set; }
		public ICommand OpenAreaCommand { get; set; }

		public ViewModelBase ActiveViewModel
		{
			get { return mActiveViewModel; }

			set
			{
				if (mActiveViewModel == value)
					return;

				mActiveViewModel = value;
				OnPropertyChanged("ActiveViewModel");
			}
		}
	}
}
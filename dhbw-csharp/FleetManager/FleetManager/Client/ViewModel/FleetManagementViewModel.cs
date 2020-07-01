using Client.Helper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Client.ViewModel
{
    public class FleetManagementViewModel: ViewModelBase
    {
		private ViewModelBase mActiveViewModel;
		public ICommand OpenHomeCommand { get; set; }
		public ICommand OpenCostMonthCommand { get; set; }
		public ICommand OpenCostBusinessAreaCommand { get; set; }
		public ICommand OpenVehiclesCommand { get; set; }
		public ICommand OpenEmployeesCommand { get; set; }
		public ICommand OpenBusinessAreasCommand { get; set; }
		public ICommand OpenUserCommand { get; set; }
		public ICommand LogoutCommand { get; set; }

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

		private ICommand newCommand;
		public ICommand NewCommand 
		{
			get => newCommand;
			set 
			{
				newCommand = value;
				OnPropertyChanged();
			}
		}
		private ICommand saveCommand;
		public ICommand SaveCommand 
		{
			get => saveCommand;
            set
            {
				saveCommand = value;
				OnPropertyChanged();
			}
		}
		private ICommand deleteCommand;
		public ICommand DeleteCommand
		{
			get => deleteCommand;
			set
			{
				deleteCommand = value;
				OnPropertyChanged();
			}
		}
	}
}

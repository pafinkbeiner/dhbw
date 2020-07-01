using System.Windows;
using System.Windows.Controls;
using Client.FleetServiceReference;
using Client.ViewModel;

namespace Client.View
{
	public class SubmoduleSelector : DataTemplateSelector
	{
		public override DataTemplate SelectTemplate(object item, DependencyObject container)
		{
			var contentControl = (container as FrameworkElement);
			
			if (item is HomeViewModel) return contentControl.FindResource("homeViewTemplate") as DataTemplate;
			if (item is CostMonthViewModel) return contentControl.FindResource("costMonthViewTemplate") as DataTemplate;
			if (item is CostBusinessAreaViewModel) return contentControl.FindResource("costBusinessAreaViewTemplate") as DataTemplate;
			if (item is VehiclesViewModel) return contentControl.FindResource("vehiclesViewTemplate") as DataTemplate;
			if (item is EmployeesViewModel) return contentControl.FindResource("employeesViewTemplate") as DataTemplate;
			if (item is BusinessAreasViewModel) return contentControl.FindResource("businessAreasViewTemplate") as DataTemplate; 
			if (item is UserViewModel) return contentControl.FindResource("userViewTemplate") as DataTemplate;
			return null;
		}
	}
}
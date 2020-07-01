using System.Windows;
using System.Windows.Controls;
using DynamicSubmoduleViewSample.ViewModels;

namespace DynamicSubmoduleViewSample.Views
{
	public class SubmoduleSelector : DataTemplateSelector
	{
		public override DataTemplate SelectTemplate(object item, DependencyObject container)
		{
			var contentControl = (container as FrameworkElement);
			
			if (item is CustomerViewModel)
				return contentControl.FindResource("customerViewTemplate") as DataTemplate;

			if (item is AreaViewModel)
				return contentControl.FindResource("areaViewTemplate") as DataTemplate;

			return null;
		}
	}
}
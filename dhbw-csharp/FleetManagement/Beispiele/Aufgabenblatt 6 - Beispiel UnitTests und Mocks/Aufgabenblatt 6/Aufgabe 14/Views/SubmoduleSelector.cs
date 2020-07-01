using System.Windows;
using System.Windows.Controls;
using Aufgabe_14.ViewModels;

namespace Aufgabe_14.Views
{
    public class SubmoduleSelector : DataTemplateSelector
    {
        public override DataTemplate SelectTemplate(object item, DependencyObject container)
        {
            var contentControl = (container as FrameworkElement);

            if (item is MovieViewModel) 
	            return contentControl?.FindResource("movieViewTemplate") as DataTemplate;

            if (!(item is GenreViewModel)) 
	            return null;

            return contentControl?.FindResource("genreViewTemplate") as DataTemplate;
        }
    }
}

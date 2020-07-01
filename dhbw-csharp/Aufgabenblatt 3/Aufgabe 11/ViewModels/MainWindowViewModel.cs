using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using Aufgabe_11.Framework;
using Aufgabe_11.Models;

namespace Aufgabe_11.ViewModels
{
    class MainWindowViewModel: ViewModelBase
    {
        public ObservableCollection<Employee> Models { get; set; } = new ObservableCollection<Employee>();

        private Employee _selectedModel;
        public Employee SelectedModel
        {
            get => _selectedModel;
            set
            {
                _selectedModel = value;
                OnPropertyChanged();
            }
        }

        public ICommand AddCommand { get; set; }
        public ICommand DeleteCommand { get; set; }
    }
}

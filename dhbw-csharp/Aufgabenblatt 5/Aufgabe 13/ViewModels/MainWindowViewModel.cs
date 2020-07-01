using Aufgabe_13.Framework;
using Aufgabe_13.Models;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Aufgabe_13.ViewModels
{
    class MainWindowViewModel: ViewModelBase
    {
        public ObservableCollection<Customer> Models { get; set; } = new ObservableCollection<Customer>();

        private Customer _selectedModel;
        public Customer SelectedModel
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

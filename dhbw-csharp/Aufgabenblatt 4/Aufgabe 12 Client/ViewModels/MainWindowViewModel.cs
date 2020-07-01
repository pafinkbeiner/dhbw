using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using Aufgabe_12.Framework;
using Aufgabe_12_Client.CustomerServiceProxy;

namespace Aufgabe_12_Client.ViewModels
{
    public class MainWindowViewModel: ViewModelBase
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

        private string _searchQuery;
        public string SearchQuery
        {
            get => _searchQuery;
            set
            {
                _searchQuery = value;
                OnPropertyChanged();
            }
        }

        public ICommand ClearCommand { get; set; }
        public ICommand LoadCommand { get; set; }
        public ICommand NewCommand { get; set; }
        public ICommand DeleteCommand { get; set; }
        public ICommand SearchCommand { get; set; }
    }
}

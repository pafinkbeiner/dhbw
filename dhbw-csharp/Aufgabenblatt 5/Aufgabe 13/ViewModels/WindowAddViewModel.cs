using Aufgabe_13.Framework;
using Aufgabe_13.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Aufgabe_13.ViewModels
{
    class WindowAddViewModel: ViewModelBase
    {
        public Customer Model { get; set; }
        public ICommand OkCommand { get; set; }
        public ICommand CancelCommand { get; set; }

        public Array Genders => Enum.GetValues(typeof(Gender));

        public string Firstname
        {
            get => Model.Firstname;
            set
            {
                Model.Firstname = value;
                OnPropertyChanged();
            }
        }

        public string Lastname
        {
            get => Model.Surname;
            set
            {
                Model.Surname = value;
                OnPropertyChanged();
            }
        }

        public Gender Gender
        {
            get => Model.Gender;
            set
            {
                Model.Gender = value;
                OnPropertyChanged();
            }
        }
        public string Street
        {
            get => Model.Address.Street;
            set
            {
                Model.Address.Street = value;
                OnPropertyChanged();
            }
        }
        public string StreetNumber
        {
            get => Model.Address.StreetNumber;
            set
            {
                Model.Address.StreetNumber = value;
                OnPropertyChanged();
            }
        }
        public int PostCode
        {
            get => Model.Address.PostCode;
            set
            {
                Model.Address.PostCode = value;
                OnPropertyChanged();
            }
        }
        public string City
        {
            get => Model.Address.City;
            set
            {
                Model.Address.City = value;
                OnPropertyChanged();
            }
        }
    }
}

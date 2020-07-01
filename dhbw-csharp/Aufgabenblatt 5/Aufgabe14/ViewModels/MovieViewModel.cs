﻿using System.Collections.ObjectModel;
using Aufgabe14.Infrastructure;
using Aufgabe14.Interfaces.Models;
using Aufgabe14.Interfaces.ViewModels;
using Aufgabe14.Models;

namespace Aufgabe14.ViewModels
{
    public class MovieViewModel : ViewModelBase, IMovieViewModel
    {
        private Movie actualModel;
        public ObservableCollection<IMovie> MovieModels { get; set; } = new ObservableCollection<IMovie>();

        public Movie ActualModel
        {
            get => actualModel;
            set
            {
                if (Equals(value, actualModel)) return;
                actualModel = value;
                OnPropertyChanged();
            }
        }
    }
}

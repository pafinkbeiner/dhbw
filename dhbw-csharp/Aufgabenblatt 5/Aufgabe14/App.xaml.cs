using Aufgabe14.Controller;
using Aufgabe14.Infrastructure;
using Aufgabe14.Interfaces.Controller;
using Aufgabe14.Interfaces.Infrastructure;
using Aufgabe14.Interfaces.Models;
using Aufgabe14.Interfaces.ViewModels;
using Aufgabe14.Models;
using Aufgabe14.ViewModels;
using Autofac;
using System.Windows;

namespace Aufgabe14
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        public static IContainer Container { get; private set; }

        protected override void OnStartup(StartupEventArgs e)
        {
            base.OnStartup(e);

            ContainerBuilder containerBuilder = new ContainerBuilder();

            containerBuilder.RegisterType<MainWindowController>().As<IMainWindowController>();
            containerBuilder.RegisterGeneric(typeof(Repository<>)).As(typeof(IRepository<>));
            containerBuilder.RegisterType<Genre>().As<IGenre>();
            containerBuilder.RegisterType<Movie>().As<IMovie>();
            containerBuilder.RegisterType<AddGenreViewModel>().As<IAddGenreViewModel>();
            containerBuilder.RegisterType<AddMovieViewModel>().As<IAddMovieViewModel>();
            containerBuilder.RegisterType<GenreViewModel>().As<IGenreViewModel>();
            containerBuilder.RegisterType<MainWindowViewModel>().As<IMainWindowViewModel>();
            containerBuilder.RegisterType<MovieViewModel>().As<IMovieViewModel>();
            containerBuilder.RegisterType<AddGenreViewController>().As<IAddGenreViewController>();
            containerBuilder.RegisterType<AddMovieViewController>().As<IAddMovieViewController>();
            containerBuilder.RegisterType<GenresViewController>().As<IGenreViewController>();
            containerBuilder.RegisterType<MoviesViewController>().As<IMovieViewController>();

            Container = containerBuilder.Build();

            IMainWindowController mainController = Container.Resolve<IMainWindowController>();

            mainController.Initialize(Container.Resolve<IRepository<IMovie>>(new NamedParameter("databaseFile", @"Database/Movies.db")),
                Container.Resolve<IRepository<IGenre>>(new NamedParameter("databaseFile", @"Database/Movies.db")), false);
        }
    }
}

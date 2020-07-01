using System.Linq;
using System.Reflection;
using System.Windows;
using Aufgabe_14.Controllers;
using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;
using Aufgabe_14.Models;
using Aufgabe_14.ViewModels;
using Aufgabe_14.Views;
using Autofac;
using IContainer = Autofac.IContainer;

namespace Aufgabe_14
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        public static IContainer Container { get; private set; }
        protected override void OnStartup(StartupEventArgs e)
        {
            var containerBuilder = new ContainerBuilder();

            containerBuilder.RegisterType<Genre>();
            containerBuilder.RegisterType<Movie>();
            containerBuilder.RegisterType<AddGenreWindowController>();
            containerBuilder.RegisterType<AddMovieWindowController>();
            containerBuilder.RegisterType<GenreViewController>();
            containerBuilder.RegisterType<MovieViewController>();
            containerBuilder.RegisterType<MainWindowController>();
            containerBuilder.RegisterType<SubmoduleController>();
            containerBuilder.RegisterType<AddGenreWindowViewModel>();
            containerBuilder.RegisterType<AddMovieWindowViewModel>();
            containerBuilder.RegisterType<GenreViewModel>();
            containerBuilder.RegisterType<MovieViewModel>();
            containerBuilder.RegisterType<MainWindowViewModel>();
            containerBuilder.RegisterType<AddGenreWindow>();
            containerBuilder.RegisterType<AddMovieWindow>();
            containerBuilder.RegisterType<GenreView>();
            containerBuilder.RegisterType<MovieView>();
            containerBuilder.RegisterType<MainWindow>();
            containerBuilder.Register(c => new Repository<Movie>(@"Database\Movies.db")).As<IRepository<Movie>>();
            containerBuilder.Register(c => new Repository<Genre>(@"Database\Movies.db")).As<IRepository<Genre>>();

            Container = containerBuilder.Build();
            base.OnStartup(e);
            var mwc = Container.Resolve<MainWindowController>();
            mwc.Initialize();
        }
    }
}

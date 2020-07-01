using System.Reflection;
using FluentNHibernate.Cfg;
using FluentNHibernate.Cfg.Db;
using NHibernate;

namespace Aufgabe_14.Frameworks
{
    public static class NHibernateHelper
    {
        private static ISessionFactory mSessionFactory;

        private static ISessionFactory SessionFactory
        {
            get
            {
                if (mSessionFactory == null)
                    InitializeSessionFactory();

                return mSessionFactory;
            }
        }
        public static string DatabaseFile { get; set; }

        public static ISession OpenSession()
        {
            return SessionFactory.OpenSession();
        }

        private static void InitializeSessionFactory()
        {
            mSessionFactory = Fluently.Configure()
                .Database((SQLiteConfiguration.Standard).UsingFile(DatabaseFile).ShowSql())
                .Mappings(m => m.FluentMappings.AddFromAssembly(Assembly.GetExecutingAssembly())
                    .Conventions.Add(FluentNHibernate.Conventions.Helpers.DefaultLazy.Never()))
                .BuildSessionFactory();
        }
    }
}

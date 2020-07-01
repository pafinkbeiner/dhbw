using System.Reflection;
using FluentNHibernate.Cfg;
using FluentNHibernate.Cfg.Db;
using NHibernate;

namespace Server.DbConnetion
{
    public static class NHibernateHelper
    {
        private static ISessionFactory sessionFactory;
        public static string DatabaseFile { get; set; }

        private static ISessionFactory SessionFactory
        {
            get
            {
                if (sessionFactory == null)
                    InitializeSessionFactory();

                return sessionFactory;
            }
        }

        public static ISession OpenSession()
        {
            return SessionFactory.OpenSession();
        }

        private static void InitializeSessionFactory()
        {
            sessionFactory = Fluently.Configure()
                .Database(SQLiteConfiguration.Standard.UsingFile(DatabaseFile).ShowSql())
                .Mappings(m => m.FluentMappings.AddFromAssembly(Assembly.GetExecutingAssembly())
                    .Conventions.Add(FluentNHibernate.Conventions.Helpers.DefaultLazy.Never()))
                .BuildSessionFactory();
        }
    }
}

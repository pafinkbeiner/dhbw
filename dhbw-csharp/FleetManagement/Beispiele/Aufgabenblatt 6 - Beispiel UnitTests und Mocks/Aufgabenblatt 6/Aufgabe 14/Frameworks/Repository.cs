using System.Collections.Generic;
using Aufgabe_14.Interfaces;
using Exception = System.Exception;

namespace Aufgabe_14.Frameworks
{
    public class Repository<T>: IRepository<T> where T : class
    {
        public Repository(string databaseFile)
        {
            NHibernateHelper.DatabaseFile = databaseFile;
        }

        public List<T> GetAll()
        {
            using (var session = NHibernateHelper.OpenSession())
            {
                try
                {
                    var returnList = session.CreateCriteria<T>().List<T>();
                    return returnList as List<T>;
                }
                catch (Exception)
                {
                    return new List<T>();
                }
            }
        }

        public bool Delete(T entity)
        {
            try
            {
                using (var session = NHibernateHelper.OpenSession())
                {
                    using (var transaction = session.BeginTransaction())
                    {
                        session.Delete(entity);
                        transaction.Commit();
                    }
                }

                return true;
            }
            catch (Exception)
            {
                return false;
            }
        }

        public bool Save(T entity)
        {
            try
            {
                using (var session = NHibernateHelper.OpenSession())
                {
                    using (var transaction = session.BeginTransaction())
                    {
                        session.Save(entity);
                        transaction.Commit();
                    }
                }

                return true;
            }
            catch (Exception)
            {
                return false;
            }
        }
    }
}

﻿using System.Collections.Generic;

namespace Server.DbConnetion
{
    public class Repository<T> where T : class
    {
        public Repository(string dataBaseFile)
        {
            NHibernateHelper.DatabaseFile = dataBaseFile;
        }

        public List<T> GetAll()
        {
            using (var session = NHibernateHelper.OpenSession())
            {
                var returnList = session.CreateCriteria<T>().List<T>();
                return returnList as List<T>;
            }
        }

        public void Delete(T entity)
        {
            using (var session = NHibernateHelper.OpenSession())
            {
                using (var transaction = session.BeginTransaction())
                {
                    session.Delete(entity);
                    transaction.Commit();
                }
            }
        }

        public void Save(T entity)
        {
            using (var session = NHibernateHelper.OpenSession())
            {
                using (var transaction = session.BeginTransaction())
                {
                    session.Save(entity);
                    transaction.Commit();
                }
            }
        }
    }
}

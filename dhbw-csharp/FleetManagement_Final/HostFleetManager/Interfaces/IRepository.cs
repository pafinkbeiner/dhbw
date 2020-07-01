using System.Collections.Generic;

namespace HostFleetManager.Interfaces
{
    public interface IRepository<T>
    {
        void Delete(T entity);

        bool Save(T entity);

        List<T> GetAll();

        void Insert(T entity);
    }
}

using System.Collections.Generic;
using Aufgabe_14.Frameworks;

namespace Aufgabe_14.Interfaces
{
    public interface IRepository<T>
    {
        bool Delete(T entity);

        bool Save(T entity);

        List<T> GetAll();
    }
}

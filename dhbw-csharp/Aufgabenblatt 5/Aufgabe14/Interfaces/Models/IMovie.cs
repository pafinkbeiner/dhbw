using Aufgabe14.Models;

namespace Aufgabe14.Interfaces.Models
{
    public interface IMovie
    {
        string Titel { get; set; }
        Genre Genre { get; set; }
        int Id { get; set; }
    }
}

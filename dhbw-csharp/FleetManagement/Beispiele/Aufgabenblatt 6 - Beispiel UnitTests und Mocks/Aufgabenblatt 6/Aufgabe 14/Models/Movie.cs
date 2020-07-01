using Aufgabe_14.Interfaces;

namespace Aufgabe_14.Models
{
    public class Movie: ModelBase
    {
	    public Genre Genre { get; set; }
        public string Title { get; set; }
    }
}

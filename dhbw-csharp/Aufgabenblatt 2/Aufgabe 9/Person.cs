using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_9
{

    public delegate void NameChanged(object sender, EventArgs e);

    class Person
    { 
        public event Action<string> NameChanged;

        private string _firstName;
        public string FirstName
        {
            get => _firstName;
            set
            {
                _firstName = value;
                NameChanged?.Invoke($"Vorname: {FirstName}, Nachname: {LastName}");
            }
        }

        private string _lastName;
        public string LastName
        {
            get => _lastName;
            set
            {
                _lastName = value;
                NameChanged?.Invoke($"Vorname: {FirstName}, Nachname: {LastName}");
            }
        }

    }
}

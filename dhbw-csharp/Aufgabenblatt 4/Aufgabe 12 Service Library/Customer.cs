using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_12_Service_Library
{
    [DataContract]
    public class Customer
    {
        [DataMember]
        public string FirstName { get; set; }
        [DataMember]
        public string LastName { get; set; }
        public bool IsPremiumCustomer { get; set; }

        public override bool Equals(object obj)
        {
            return (obj is Customer c) && (this.FirstName == c.FirstName && this.LastName == c.LastName);
        }
    }
}

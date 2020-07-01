﻿using System.Runtime.Serialization;

namespace Server.Models
{
    [DataContract]
    public class Employee
    {
        [DataMember]
        public int Id { get; set; }

        [DataMember]
        public string FirstName { get; set; }

        [DataMember]
        public string LastName { get; set; }

        [DataMember]
        public int EmployeeNumber { get; set; }

        [DataMember]
        public string Salutation { get; set; }

        [DataMember]
        public string Title { get; set; }

        [DataMember]
        public BusinessUnit BusinessUnitId { get; set; }

        [DataMember]
        public int Version { get; set; }
    }
}

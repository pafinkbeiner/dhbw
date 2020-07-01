﻿using System;
using System.Runtime.Serialization;

namespace Server.Models
{
    [DataContract]
    public class Vehicle
    {
        [DataMember]
        public int Id { get; set; }

        [DataMember]
        public string LicensePlate { get; set; }

        [DataMember]
        public string Brand { get; set; }

        [DataMember]
        public string Model { get; set; }

        [DataMember]
        public decimal Insurance { get; set; }

        [DataMember]
        public DateTime LeasingFrom { get; set; }

        [DataMember]
        public DateTime LeasingTo { get; set; }

        [DataMember]
        public decimal LeasingRate { get; set; }

        [DataMember]
        public int Version { get; set; }
    }
}

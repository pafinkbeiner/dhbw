using System;
using System.Runtime.Serialization;

namespace Server.Models
{
    [DataContract]
    public class VehicleToEmployeeRelation
    {
        [DataMember]
        public int Id { get; set; }

        [DataMember]
        public DateTime StartDate { get; set; }

        [DataMember]
        public DateTime EndDate { get; set; }

        [DataMember]
        public Vehicle VehicleId { get; set; }

        [DataMember]
        public Employee EmployeeId { get; set; }
    }
}

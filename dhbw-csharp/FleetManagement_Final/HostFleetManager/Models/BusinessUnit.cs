using System.Runtime.Serialization;

namespace Server.Models
{
    [DataContract]
    public class BusinessUnit
    {
        [DataMember]
        public int Id { get; set; }

        [DataMember]
        public string Name { get; set; }

        [DataMember]
        public string Description { get; set; }

        [DataMember]
        public int Version { get; set; }
    }
}

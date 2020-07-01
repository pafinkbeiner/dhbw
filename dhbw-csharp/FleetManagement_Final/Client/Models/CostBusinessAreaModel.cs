using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Client.FleetServiceReference;

namespace Client.Models
{
    public class CostBusinessAreaModel
    {
        public string Month { get; set; }
        public BusinessUnit BusinessUnit { get; set; }
        public decimal Costs { get; set; }

        public string CostDisplay { get; set; }
    }
}

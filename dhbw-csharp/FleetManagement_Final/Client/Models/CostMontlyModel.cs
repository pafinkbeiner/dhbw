using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client.Models
{
    public class CostMontlyModel
    {
        public string Month { get; set; }
        public decimal Amount { get; set; }
        public decimal Cost { get; set; }
        public string CostDisplay { get; set; }
    }
}

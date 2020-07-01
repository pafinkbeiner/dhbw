using Client.FleetServiceReference;
using Client.Helper;
using Client.Models;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Globalization;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Navigation;

namespace Client.Controller
{
    public class CostMonthViewController : SubmoduleController
    {
        private FleetServiceClient socket;
        private CostMonthViewModel costMonthlyViewModel;
        public override ViewModelBase Initialize()
        {
            var costMonthly = GetData();
            costMonthlyViewModel = new CostMonthViewModel()
            {
                Costs = new ObservableCollection<CostMontlyModel>(costMonthly)
            };
            return costMonthlyViewModel;
        }

        public CostMonthViewController(FleetServiceClient socket)
        {
            this.socket = socket;
        }

        private List<CostMontlyModel> GetData()
        {
            var costMontly = new List<CostMontlyModel>();
            var vehicles = socket.GetAllVehicles();

            foreach (var vehicle in vehicles)
            {
                for (var iterator = vehicle.LeasingFrom; iterator < vehicle.LeasingTo; iterator = iterator.AddMonths(1))
                {
                    costMontly.Add(new CostMontlyModel()
                    {
                        Month = CultureInfo.CurrentCulture.DateTimeFormat.GetMonthName(iterator.Month) + " " + iterator.Year,
                        Amount = 1,
                        Cost = vehicle.Insurance / 12 + vehicle.LeasingRate,
                        CostDisplay = ""
                    });
                }
            }

            costMontly = costMontly
                .GroupBy(cm => cm.Month)
                .Select(gcm => new CostMontlyModel() {
                    Month = gcm.Key, 
                    Amount = gcm.Count(),
                    Cost = gcm.Sum(x => x.Cost),
                    CostDisplay = string.Format("€ {0}", gcm.Sum(z => z.Cost).ToString("0.00"))
                }
            ).OrderByDescending(x => x.Cost).ToList();

            return costMontly;
        }

    }
}

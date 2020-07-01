using Client.FleetServiceReference;
using Client.Helper;
using Client.Models;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
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

            //FilterOperations
            //var amountVehiclesJanuary = (from vehicle in vehicles
            //                              where vehicle.LeasingFrom.Month <= 1 && vehicle.LeasingTo.Month >= 1
            //                              select (vehicle.Id)).Count();
            //
            //var costVehiclesJanuary = (from vehicle in vehicles
            //                             where vehicle.LeasingFrom.Month <= 1 && vehicle.LeasingTo.Month >= 1
            //                             select (vehicle.Insurance)).Sum();

            foreach (var vehicle in vehicles)
            {
            
                //Operations
            
                costMontly.Add(new CostMontlyModel() 
                { 
                    Month = "Januar",
                    Amount = vehicle.Insurance,
                    Cost = vehicle.Insurance
                });
            }

            return costMontly; ;
        }
    }
}

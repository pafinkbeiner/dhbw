using Client.FleetServiceReference;
using Client.Helper;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Client.Models;
using System.Globalization;

namespace Client.Controller
{
    public class CostBusinessAreaViewController : SubmoduleController
    {
        private FleetServiceClient socket;
        private CostBusinessAreaViewModel costBusinessAreaViewModel;

        public override ViewModelBase Initialize()
        {
            List<CostBusinessAreaModel> data = GetCostsPerMonthPerBusinessUnit().ToList();
            costBusinessAreaViewModel = new CostBusinessAreaViewModel()
            {
                Costs = new ObservableCollection<CostBusinessAreaModel>(data)
            };
            return costBusinessAreaViewModel;
        }

        public CostBusinessAreaViewController(FleetServiceClient socket)
        {
            this.socket = socket;
        }

        public IEnumerable<CostBusinessAreaModel> GetCostsPerMonthPerBusinessUnit() => socket.GetAllBusinessUnits()
                .Join(socket.GetAllEmployees(), b => b.Id, e => e.BusinessUnitId.Id, (b, e) => new { BusinessUnit = b, Employee = e })
                .Join(socket.GetAllRelations(), be => be.Employee.Id, ve => ve.EmployeeId.Id, (be, ve) => new { BusinessUnitEmployee = be, VehicleEmployee = ve })
                .Join(socket.GetAllVehicles(), beve => beve.VehicleEmployee.VehicleId.Id, v => v.Id, (beve, v) => new { beve.BusinessUnitEmployee.BusinessUnit, beve.VehicleEmployee, Vehicle = v })
                .Select(m => new { m.BusinessUnit, Costs = GetCostsPerVehicle(m.VehicleEmployee, m.Vehicle) })
                .SelectMany(bv => bv.Costs.Select(c => new { VehicleCost = c, bv.BusinessUnit }))
                .GroupBy(cb => new { cb.VehicleCost.Month, cb.BusinessUnit })
                .Select(cb => new CostBusinessAreaModel() { Month = CultureInfo.CurrentCulture.DateTimeFormat.GetMonthName( cb.Key.Month.Month) +" "+ cb.Key.Month.Year , BusinessUnit = cb.Key.BusinessUnit, Costs = cb.Sum(c => c.VehicleCost.Costs) , CostDisplay= string.Format("€ {0}", cb.Sum(c => c.VehicleCost.Costs).ToString("0.00")) });
        
        
        private IEnumerable<(DateTime Month, int Count, decimal Costs)> GetCostsPerVehicle(VehicleToEmployeeRelation vehicleEmployee, Vehicle vehicle)
        {
            for (DateTime i = vehicleEmployee.StartDate; i < (vehicleEmployee?.EndDate ?? DateTime.Now); i = i.AddMonths(1))
            {
                yield return (new DateTime(i.Year, i.Month, 1), 1, vehicle.Insurance / 12 + vehicle.LeasingRate);
            }
        }

    }
}

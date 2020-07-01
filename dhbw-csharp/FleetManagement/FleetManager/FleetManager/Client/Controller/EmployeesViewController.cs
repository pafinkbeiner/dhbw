using Autofac;
using Client.FleetServiceReference;
using Client.Helper;
using Client.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Client.Controller
{
    public class EmployeesViewController : SubmoduleController
    {

        private FleetServiceClient socket;
        private EmployeesViewModel employeeAreaViewModel;
        private FleetManagementController parent;

        public EmployeesViewController( FleetServiceClient socket, FleetManagementController parent)
        {
            this.socket = socket;
            this.parent = parent;
        }

        public override ViewModelBase Initialize()
        {
            employeeAreaViewModel = new EmployeesViewModel()
            {
                Employees = new ObservableCollection<Employee>(socket.GetAllEmployees()),
                entryEmployees = socket.GetAllEmployees().ToList(),
                SelectedEmployee = null,
                BusinessUnits = new ObservableCollection<BusinessUnit>(socket.GetAllBusinessUnits()),
                SelectedBusinessUnit = null
            };
            return employeeAreaViewModel;
        }

        public void ExecuteNewEmployeeCommand(Object obj)
        {
            AddEmployeeController addEmployeeController = App.Container.Resolve<AddEmployeeController>();
            Employee employee = addEmployeeController.AddEmployee(socket);
            if (employee == null) return;
            var result = socket.AddEmployee(employee);
            if (result == false) MessageBox.Show("Fehler beim Hinzufügen des Mitarbeiters!");

            parent.restartEmployeeCommand();
        }

        public void ExecuteSaveEmployeeCommand(Object obj)
        {

            //var selectedEmp = employeeAreaViewModel.SelectedEmployee;

            //selectedEmp.BusinessUnitId = employeeAreaViewModel.SelectedBusinessUnit;

            foreach (Employee emp in employeeAreaViewModel.Employees)
            {
                foreach (Employee front in employeeAreaViewModel.entryEmployees)
                {
                    if (emp.Id == front.Id)
                    {

                        var result = socket.ChangeEmployee(front, emp);
                        if (result == false) MessageBox.Show("Fehler beim Ändern des Mitarbeiters!");
                    }
                }
            }

            //for (int i = 0; i < employeeAreaViewModel.Employees.Count; i++)
            //{
            //    if (employeeAreaViewModel.entryEmployees[i] != employeeAreaViewModel.Employees[i])
            //    {
            //        var result = socket.ChangeEmployee(employeeAreaViewModel.entryEmployees[i], employeeAreaViewModel.Employees[i]);
            //        if (result == false) MessageBox.Show("Fehler beim Ändern des Mitarbeiters!");
            //    }
            //}

            parent.restartEmployeeCommand();

        }

        public void ExecuteDeleteEmployeeCommand(Object obj)
        {
            var emp = employeeAreaViewModel.SelectedEmployee;

                var result = socket.DeleteEmployee(employeeAreaViewModel.SelectedEmployee);
                if (result == false) MessageBox.Show("Fehler beim Löschen des Mitarbeiters!");

                parent.restartEmployeeCommand();
        }

        public bool CanExecuteDeleteCommand(Object obj)
        {
            if (employeeAreaViewModel.SelectedEmployee != null)
            {
                if (socket.CanRemoveEmployee(employeeAreaViewModel.SelectedEmployee) == true)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }
}

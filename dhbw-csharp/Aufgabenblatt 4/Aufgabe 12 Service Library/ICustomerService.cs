using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace Aufgabe_12_Service_Library
{
    [ServiceContract]
    public interface ICustomerService
    {
        [OperationContract]
        bool AddCustomer(Customer c);

        [OperationContract]
        bool RemoveCustomer(Customer c);

        [OperationContract]
        List<Customer> GetAllCustomers();

        [OperationContract]
        List<Customer> GetCustomers(string s);

    }


}

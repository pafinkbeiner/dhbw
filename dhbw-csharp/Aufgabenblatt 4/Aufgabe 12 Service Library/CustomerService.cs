using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace Aufgabe_12_Service_Library
{

    [ServiceBehavior(InstanceContextMode = InstanceContextMode.Single)]
    public class CustomerService : ICustomerService
    {
        private List<Customer> mCustomers = new List<Customer>()
        {
            new Customer{FirstName = "Jens", LastName = "Mander", IsPremiumCustomer = true}, 
            new Customer{FirstName = "Hans", LastName = "Wurst", IsPremiumCustomer = false},
            new Customer{FirstName = "Guybrush", LastName = "Threepwod", IsPremiumCustomer = true}
        };

        public bool AddCustomer(Customer c)
        {
            if (mCustomers.Contains(c))
            {
                return false;
            }

            mCustomers.Add(c);
            return true;
            
        }

        public List<Customer> GetAllCustomers()
        {
            return mCustomers;
        }

        public List<Customer> GetCustomers(string s)
        {
            return (
                from customer in mCustomers
                where customer.LastName == s
                select customer
                )
                .ToList();
        }

        public bool RemoveCustomer(Customer c)
        {
            if (!mCustomers.Contains(c))
            {
                return false;
            }

            mCustomers.Remove(c);
            return true;
        }
    }
}

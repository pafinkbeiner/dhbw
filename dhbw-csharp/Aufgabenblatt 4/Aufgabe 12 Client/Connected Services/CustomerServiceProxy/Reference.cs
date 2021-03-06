﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Aufgabe_12_Client.CustomerServiceProxy {
    using System.Runtime.Serialization;
    using System;
    using System.Collections.Generic;

    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Customer", Namespace="http://schemas.datacontract.org/2004/07/Aufgabe_12_Service_Library")]
    [System.SerializableAttribute()]
    public partial class Customer : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string FirstNameField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string LastNameField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string FirstName {
            get {
                return this.FirstNameField;
            }
            set {
                if ((object.ReferenceEquals(this.FirstNameField, value) != true)) {
                    this.FirstNameField = value;
                    this.RaisePropertyChanged("FirstName");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string LastName {
            get {
                return this.LastNameField;
            }
            set {
                if ((object.ReferenceEquals(this.LastNameField, value) != true)) {
                    this.LastNameField = value;
                    this.RaisePropertyChanged("LastName");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="CustomerServiceProxy.ICustomerService")]
    public interface ICustomerService {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICustomerService/AddCustomer", ReplyAction="http://tempuri.org/ICustomerService/AddCustomerResponse")]
        bool AddCustomer(Aufgabe_12_Client.CustomerServiceProxy.Customer c);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICustomerService/AddCustomer", ReplyAction="http://tempuri.org/ICustomerService/AddCustomerResponse")]
        System.Threading.Tasks.Task<bool> AddCustomerAsync(Aufgabe_12_Client.CustomerServiceProxy.Customer c);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICustomerService/RemoveCustomer", ReplyAction="http://tempuri.org/ICustomerService/RemoveCustomerResponse")]
        bool RemoveCustomer(Aufgabe_12_Client.CustomerServiceProxy.Customer c);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICustomerService/RemoveCustomer", ReplyAction="http://tempuri.org/ICustomerService/RemoveCustomerResponse")]
        System.Threading.Tasks.Task<bool> RemoveCustomerAsync(Aufgabe_12_Client.CustomerServiceProxy.Customer c);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICustomerService/GetAllCustomers", ReplyAction="http://tempuri.org/ICustomerService/GetAllCustomersResponse")]
        Aufgabe_12_Client.CustomerServiceProxy.Customer[] GetAllCustomers();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICustomerService/GetAllCustomers", ReplyAction="http://tempuri.org/ICustomerService/GetAllCustomersResponse")]
        System.Threading.Tasks.Task<Aufgabe_12_Client.CustomerServiceProxy.Customer[]> GetAllCustomersAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICustomerService/GetCustomers", ReplyAction="http://tempuri.org/ICustomerService/GetCustomersResponse")]
        Aufgabe_12_Client.CustomerServiceProxy.Customer[] GetCustomers(string s);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICustomerService/GetCustomers", ReplyAction="http://tempuri.org/ICustomerService/GetCustomersResponse")]
        System.Threading.Tasks.Task<Aufgabe_12_Client.CustomerServiceProxy.Customer[]> GetCustomersAsync(string s);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface ICustomerServiceChannel : Aufgabe_12_Client.CustomerServiceProxy.ICustomerService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class CustomerServiceClient : System.ServiceModel.ClientBase<Aufgabe_12_Client.CustomerServiceProxy.ICustomerService>, Aufgabe_12_Client.CustomerServiceProxy.ICustomerService {
        
        public CustomerServiceClient() {
        }
        
        public CustomerServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public CustomerServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public CustomerServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public CustomerServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public bool AddCustomer(Aufgabe_12_Client.CustomerServiceProxy.Customer c) {
            return base.Channel.AddCustomer(c);
        }
        
        public System.Threading.Tasks.Task<bool> AddCustomerAsync(Aufgabe_12_Client.CustomerServiceProxy.Customer c) {
            return base.Channel.AddCustomerAsync(c);
        }
        
        public bool RemoveCustomer(Aufgabe_12_Client.CustomerServiceProxy.Customer c) {
            return base.Channel.RemoveCustomer(c);
        }
        
        public System.Threading.Tasks.Task<bool> RemoveCustomerAsync(Aufgabe_12_Client.CustomerServiceProxy.Customer c) {
            return base.Channel.RemoveCustomerAsync(c);
        }
        
        public Aufgabe_12_Client.CustomerServiceProxy.Customer[] GetAllCustomers() {
            return base.Channel.GetAllCustomers();
        }
        
        public System.Threading.Tasks.Task<Aufgabe_12_Client.CustomerServiceProxy.Customer[]> GetAllCustomersAsync() {
            return base.Channel.GetAllCustomersAsync();
        }
        
        public Aufgabe_12_Client.CustomerServiceProxy.Customer[] GetCustomers(string s) {
            return base.Channel.GetCustomers(s);
        }
        
        public System.Threading.Tasks.Task<Aufgabe_12_Client.CustomerServiceProxy.Customer[]> GetCustomersAsync(string s) {
            return base.Channel.GetCustomersAsync(s);
        }

        internal IEnumerable<object> AddCustomer(string search)
        {
            throw new NotImplementedException();
        }
    }
}

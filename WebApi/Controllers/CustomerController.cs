
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ClassLibrary1;

namespace WebApplication1.Controllers
{
    public class CustomerController : ApiController
    {
        [HttpGet]
        public Customer1 GetCustomer(int id)
        {
            CustReposit rep = new CustReposit();
            Customer1 c = rep.FindCustomer(id);
            return c;
        }
        [HttpPost]
     public String AddCustomer(CUSTOMER cust)
        {
            CustReposit rep = new CustReposit();
            int status = rep.AddCustomer(Convert.ToInt32(cust.CIF),cust.CUSTOMER_FNAME,cust.CUSTOMER_LNAME,
                Convert.ToDateTime(cust.CUSTOMER_DOB),cust.CUSTOMER_ADDRESS,cust.CUSTOMER_EMAIL);
                if(status>0)
            {
                return "Record Successfully Added";
            }
            return "Some error in adding customer";
                 
        }
    }
}

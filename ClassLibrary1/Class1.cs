using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibrary1
{

    public class CustReposit
    {
        public int AddCustomer(int cid, string cfname, string lname, DateTime cdob, string address,
            string email)
        {
            Entities context = new Entities();
            CUSTOMER c = new CUSTOMER { CIF = cid, CUSTOMER_FNAME = cfname, CUSTOMER_DOB = cdob,
                CUSTOMER_ADDRESS = address, CUSTOMER_EMAIL = email };
            context.CUSTOMERs.Add(c);
            int status = context.SaveChanges();
            return status;
        }
        public Customer1 FindCustomer(int cid)
        {
            Entities context = new Entities();
            CUSTOMER cust = context.CUSTOMERs.Where(c => c.CIF == cid).SingleOrDefault();
            Customer1 cust1 = new Customer1();
            cust1.CUSTOMER_ADDRESS = cust.CUSTOMER_ADDRESS;
            cust1.CUSTOMER_DOB = Convert.ToDateTime(cust.CUSTOMER_DOB);
            cust1.CUSTOMER_FNAME = cust.CUSTOMER_FNAME;
            cust1.CIF = cust.CIF;
            cust1.CUSTOMER_PHONE = cust.CUSTOMER_PHONE;
            cust1.CUSTOMER_EMAIL = cust.CUSTOMER_EMAIL;
            return cust1;
        }
      
  
        
    }
}

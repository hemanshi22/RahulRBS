import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import rbs.module.transaction.dao.DaoImplementation;

public class Test {

	public static void main(String[] args) {
		DaoImplementation d = new DaoImplementation();
		
				
		System.out.println(d.getTransactions(stringToDate("18-08-2016")));

	//  	System.out.println(d.getTransactions(stringToDate("18-08-2016"),stringToDate("20-08-2016")));
	//	System.out.println(d.getTransactions("FX"));
	//	System.out.println(d.getTransactions(1));
	}
	
	static Date stringToDate(String value){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date(date.getTime());
	}
}
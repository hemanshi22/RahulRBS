//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//
//import rbs.module.transaction.dao.DaoImplementation;
//
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Iterator;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Iterator;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//public class Test {
//
//	
//	public static void main(String[] args) {
//		
//		DaoImplementation d = new DaoImplementation();	
//		JSONParser parser = new JSONParser();
//
//		try {
//
//			Object obj = parser.parse(new FileReader("http://localhost:8080/final/rest/RestService/getbetweendates/2016-08-18/2016-08-20"));
//			JSONObject jsonObject = (JSONObject) obj;
//
//			String name = (String) jsonObject.get(jsonObject);
//			System.out.println(name);
////			JSONArray jsonObject = (JSONObject) obj;
////			System.out.println(obj);
////			String name = (String) jsonObject.get("name");
////			System.out.println(name);
////
////			long age = (Long) jsonObject.get("age");
////			System.out.println(age);
////
////			// loop array
////			JSONArray msg = (JSONArray) jsonObject.get("messages");
////			Iterator<String> iterator = msg.iterator();
////			while (iterator.hasNext()) {
////				System.out.println(iterator.next());
////			}
//
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (org.json.simple.parser.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//
//		
//	//	System.out.println(d.getTransactions(stringToDate("18-08-2016")));
//
//	//  	System.out.println(d.getTransactions(stringToDate("18-08-2016"),stringToDate("20-08-2016")));
//	//	System.out.println(d.getTransactions("FX"));
//	//	System.out.println(d.getTransactions(1));
//	}
//	
//	static Date stringToDate(String value){
//		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//		java.util.Date date = null;
//		try {
//			date = format.parse(value);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new Date(date.getTime());
//	}
//}
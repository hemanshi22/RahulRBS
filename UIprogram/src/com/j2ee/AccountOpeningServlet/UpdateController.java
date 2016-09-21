
package com.j2ee.AccountOpeningServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.account.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateAccount")
public class UpdateController extends HttpServlet {
private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                PrintWriter out= response.getWriter();
                //out.println("post");
         
        {
        	HttpSession session= request.getSession();
			String per= (String)session.getAttribute("per");
                try{
                	out.println("<html><body>");
                	out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
                	out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
                	out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.62.238.195:1521:rbsdb", "scott","rbs");
              //  Statement statement = connection.createStatement();
//                
//                out.println("connection created");
                	Connection c =DatabaseConnection.getConnection();
                	
                	Statement statement = c.createStatement();
                String btypeStr=request.getParameter("branchType");
                String nom=request.getParameter("nominee");
                int acc=Integer.parseInt(request.getParameter("acno"));
                //System.out.println(btypeStr);
                //System.out.println(acc);
               // out.println(btype);
              //  out.println(nom);
                
                
                
                if((btypeStr!=null)&&(btypeStr!=""))
                        {//System.out.println("1");
                	//System.out.println(btype);
                        try
                        {
                        	int btype=Integer.parseInt(btypeStr);
                        int nofr = statement.executeUpdate("update ACCOUNT_DETAILS set BRANCH_CODE="+btype+" where ACC_NO="+acc);
                        
                        if (nofr > 0){
                                    out.println("Updated Branch!");
                                   }
                            else{
                                    out.println("Couldn't update Branch");

                            }
                            }
                            catch(SQLException sqle){
                                    System.out.println(sqle.getMessage());
                            }
                        }
                
                if((nom!=null)&&(nom!=""))
                	
                    {//System.out.println(nom);
                	try
                    {//System.out.println("2");
                    int nofr = statement.executeUpdate("update ACCOUNT_DETAILS set NOMINEE_NAME='"+nom+"' where ACC_NO="+acc);
                    
                    if (nofr > 0){
                                out.println("Updated nominee!");
                    }
                    			else{
                                out.println("Couldn't update nominee");
                        }}
                        catch(SQLException sqle){
                                System.out.println(sqle.getMessage());
                        }
                    }

                
                
        }
                
                catch (ClassNotFoundException e) {
                out.println(e.getMessage());
                //out.println("cnfe");
        } catch (SQLException sqlException) {
                out.println(sqlException.getMessage());
               // out.println("sqle");
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                out.println("<center><form method='POST' action='mukul.jsp' ><input type='submit' value='Home' class='btn btn-primary'><input type='hidden' name='per' value='"+per+"'></form></center>");

        }

		
        }
}
        
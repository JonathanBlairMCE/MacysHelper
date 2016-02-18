package application;

import java.sql.*;

public class TestDBConnection {

    public static void main(String[] args) {
    	 SQLRequest(null);
    	
    }
    
    public static Boolean SQLRequest(String SQLString)//1st: create the connection to
	{
    	 String SQL_SERVER_CONNECTION_STRING = "jdbc:sqlserver://MT000XSSQL94;databaseName=SPManager;user=slfadmin;password=spmdadmin;";
		 Connection con = null; 
		 String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  try{
		  Class.forName(driver).newInstance();
		  con = DriverManager.getConnection(SQL_SERVER_CONNECTION_STRING);
		  Statement st = con.createStatement();
		  ResultSet res = st.executeQuery("SELECT * FROM dbo.ANDREW_CustomerDB");
		  res.next();
		  System.out.println(res);
		  //return res.getString("Name");
		  //con.close();
		  }
		  catch (SQLException s){
			  s.printStackTrace();
		  System.out.println("SQL code does not execute.");
		  }  
		  catch (Exception e){
		  e.printStackTrace();
		  }
		finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 
		return true;
		
	}
    
    

}

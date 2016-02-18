package application;

import java.sql.*;

public class TestDBConnection {

    public static void main(String[] args) {/*
        String Url = "jdbc:sqlserver://MT000XSSQL94;databaseName=SPManager;user=slfadmin;password=spmdadmin";       
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Trying to connect");
            Connection connection = DriverManager.getConnection(Url);

            System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
                    + connection.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    */}



/*public String testNormal() throws SQLException{
	  Connection con = null;
	  String url = "jdbc:sqlserver://MT000XSSQL94/";
	  String db = "SPManager";
	  String driver = "com.microsoft.sqlserver.jdbc";
	  String user = "slfadmin";
	  String pass = "spmdadmin";
	  try{
	  Class.forName(driver).newInstance();
	  con = DriverManager.getConnection(url+db, user, pass);
	  Statement st = con.createStatement();
	  ResultSet res = st.executeQuery("SELECT * FROM dbo.ANDREW_CustomerDB");
	  res.next();
	  System.out.println(res.getString("Name"));
	  //return res.getString("Name");
	  }
	  catch (SQLException s){
		  s.printStackTrace();
	  System.out.println("SQL code does not execute.");
	  }  
	  catch (Exception e){
	  e.printStackTrace();
	  }
	finally {
	con.close();
	}
	return "error";
	
}*/
    
    public static Boolean SQLRequest(String SQLString)//1st: create the connection to
	{
		 Connection con = null;
		  String url = "jdbc:sqlserver://MT000XSSQL94/";
		  String db = "SPManager";
		  String driver = "com.microsoft.sqlserver.jdbc";
		  String user = "slfadmin";
		  String pass = "spmdadmin";
		  try{
		  Class.forName(driver).newInstance();
		  con = DriverManager.getConnection(url+db, user, pass);
		  Statement st = con.createStatement();
		  ResultSet res = st.executeQuery("SELECT * FROM dbo.ANDREW_CustomerDB");
		  res.next();
		  System.out.println(res);
		  //return res.getString("Name");
		  con.close();
		  }
		  catch (SQLException s){
			  s.printStackTrace();
		  System.out.println("SQL code does not execute.");
		  }  
		  catch (Exception e){
		  e.printStackTrace();
		  }
		//finally {
		//con.close();
		//}
		 
		return true;
		
	}
    
    

}

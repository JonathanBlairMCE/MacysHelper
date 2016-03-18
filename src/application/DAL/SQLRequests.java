package application.DAL;
import application.Domain.Customer;
import application.Domain.StoreRow;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class SQLRequests
{

	public static final String TABLE_NAME = "dbo.ANDREW_CustomerDB"; //customer table
	public static final String LOCATION_TABLE = "dbo.SLLNG_ZN";//selling zone table
	public static Customer Customer_Customer = new Customer();
	public static Customer Employee_Customer = new Customer();
	public static Boolean isEmployee = false;
	public static final String SQL_SERVER_CONNECTION_STRING = "jdbc:sqlserver://MT000XSSQL94;databaseName=SPManager;user=slfadmin;password=spmdadmin;";
	public static Customer[] Queue = new Customer[1000];
	public static StoreRow[] StoreInfo = new StoreRow[]{};

	//done
	public static Boolean ADSecurityAuthenticate(String password, String username)
	{
		return true;
	}

	public static void StartEmployeeLogic()
	{
		new Thread(){
			@Override
			public void run() {
				while (true)
				{
					try
					{
						LoadQueue();
						Thread.sleep(3000);
						Customer acust = Queue[1];
					}
					catch (Exception ex)
					{

					}
				}
			}
		}.start();
	}

	public static Boolean DoRefresh()
	{
		//if (GetCustomerFromQueue(Customer_Customer.ID) != null && GetCustomerFromQueue(Customer_Customer.ID).ID != 0)
		//	return false;
		return true;
	}

	//done
	public static Boolean Submission(Customer customer)
	{

		Customer_Customer = customer;
		String SQLString = "";
		SQLString = "INSERT INTO " + TABLE_NAME +  " (Name, Gender, Store, Floor, Department, SearchItems, CustomerDescription, DateTime, Preselection, BodyType, Budget, Preferences, Comments) ";
		SQLString = SQLString + "VALUES (" +
				"'"+customer.Name+"'"  + ", " +
				"'"+customer.Gender+"'"  + ", " +
				customer.Store + ", " +
				customer.Floor + ", " +
				"'"+customer.Department+"'"  + ", " +
				"'"+customer.SearchItems+"'"  + ", " +
				"'"+customer.CustomerDescription+"'"  + ", " +
				"02/18/2016" + ", " +
				customer.Preselection + ", " +
				"'"+customer.BodyType+"'"  + ", " +
				customer.Budget + ", " +
				"'"+customer.Preferences+"'"  + ", " +
				"'"+customer.Comments+"'" +
				");";
		System.out.println(SQLString);

		return SQLRequest(SQLString);
	}

	//done
	public static Boolean Accept(int Cust_ID)
	{
		Employee_Customer = GetCustomerFromQueue(Cust_ID);
		String SQLString = "";
		SQLString = "DELETE FROM " + TABLE_NAME + " WHERE ID = " + Cust_ID;
		return SQLRequest(SQLString);
	}

	//TODO
	public static void LoadQueue()
	{
		GetCustomersSQL();
	}

	//done
	public static Boolean CancelAppointment()
	{
		return Accept(Customer_Customer.ID);
	}

	//done
	public static Customer GetCustomerFromQueue(int Cust_ID)
	{
		Customer[] parseQueue = Queue;
		for (int i = 0; i < parseQueue.length; i++)
		{
			if (parseQueue[i].ID == Cust_ID)
				return parseQueue[i];
		}
		return new Customer();
	}

	public static int[] GetFloors(int store)
	{
		if (StoreInfo == null || StoreInfo.length == 0)
			GetStoreInfo(71, store);
		int[] floors = new int[]{};
		int currentFloor = 0;
		for (int i = 0; i < StoreInfo.length && StoreInfo[i] != null; i++)
		{
			Boolean alreadyIn = false;
			for (int n = 0; n < floors.length; n++)
				if (StoreInfo[i] != null && floors[n] == StoreInfo[i].floor)
				{
					alreadyIn = true;
					break;
				}
			if (!alreadyIn)
			{
				int[] tempArray = floors;
				floors = new int[tempArray.length + 1];
				for (int b = 0; b < tempArray.length; b++)
				{
					floors[b] = tempArray[b];
				}
				floors[currentFloor] = StoreInfo[i].floor;
				currentFloor++;
			}
		}
		return floors;
	}

	public static String[] GetDepartments(int floor)//get the Departments from the JSON file
	{

		if (StoreInfo == null || StoreInfo.length == 0)
			GetStoreInfo(71, 3);
		String[] departments = new String[]{};
		for (int i = 0; i < StoreInfo.length; i++)
		{
			if (StoreInfo[i] != null && StoreInfo[i].floor == floor)
			{
				String[] tempArray = departments;
				departments = new String[tempArray.length + 1];
				for (int b = 0; b < tempArray.length; b++)
				{
					departments[b] = tempArray[b];
				}
				departments[departments.length-1] = StoreInfo[i].department.substring(StoreInfo[i].department.indexOf('-')+1);
			}
		}
		return departments;
	}

	public static void GetStoreInfo(int ZL_DIV_NBR, int ZL_STR_NBR)//get the row info for the store and save the info
	{
		String SQLString = "SELECT DISTINCT ZN_NAME, [FLR_NBR] FROM [SPManager].[dbo].[SLLNG_ZN] WHERE ZL_STORE_NBR = 3 AND ZL_DIVN_NBR = 71 ORDER BY FLR_NBR";

		String SQL_SERVER_CONNECTION_STRING = "jdbc:sqlserver://MT000XSSQL94;databaseName=SPManager;user=slfadmin;password=spmdadmin;";
		Connection con = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try
		{
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(SQL_SERVER_CONNECTION_STRING);
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(SQLString);
			StoreInfo = new StoreRow[1000];
			int i = 0;
			while (res.next())
			{
				StoreInfo[i] = new StoreRow();
				StoreInfo[i].floor = res.getInt("FLR_NBR");
				StoreInfo[i].department = res.getString("ZN_NAME");
				i++;
			}
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
	}

	public static void SaveInputFields()
	{

	}

	public static Customer[] GetCustomersSQL()//2nd populate rows with the customer data
	{
		String SQLString = "SELECT * FROM " + TABLE_NAME;

		String SQL_SERVER_CONNECTION_STRING = "jdbc:sqlserver://MT000XSSQL94;databaseName=SPManager;user=slfadmin;password=spmdadmin;";
		Connection con = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try
		{
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(SQL_SERVER_CONNECTION_STRING);
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(SQLString);

			int i = 0;
			while (res.next())
			{

				Queue[i] = new Customer();
				Queue[i].ID = res.getInt("ID") ;
				Queue[i].Name = res.getString("Name") ;
				Queue[i].Gender = res.getString("Gender");
				Queue[i].Store = res.getInt("Store");
				Queue[i].Department = res.getString("Department");
				Queue[i].SearchItems = res.getString("SearchItems");
				Queue[i].CustomerDescription = res.getString("CustomerDescription");
				Queue[i].DateTime = new Date();
				Queue[i].Preselection = res.getInt("Preselection");
				Queue[i].BodyType = res.getString("BodyType");
				Queue[i].Budget = res.getDouble("Budget");
				Queue[i].Preferences = res.getString("Preferences");
				Queue[i].Comments = res.getString("Comments");
				i++;
			}
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

		return new Customer[] {};
	}

	public static Boolean SQLRequest(String SQLString)//1st: create the connection to
	{
		Connection con = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try{
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(SQL_SERVER_CONNECTION_STRING);
			Statement st = con.createStatement();
			st.executeQuery(SQLString);
			//return res.getString("Name");
			//con.close();
			return true;
		}
		catch (SQLException s){
			//s.printStackTrace();
			//System.out.println("SQL code does not execute.");
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

		return false;
	}

}

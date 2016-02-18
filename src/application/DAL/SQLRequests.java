package application.DAL;
import application.Domain.Customer;
import application.Domain.StoreRow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SQLRequests
{

	public static final String TABLE_NAME = "dbo.ANDREW_CustomerDB"; //customer table
	public static final String LOCATION_TABLE = "dbo.SLLNG_ZN";//selling zone table
	public static Customer Customer_Customer = new Customer();
	public static Customer Employee_Customer = new Customer();
	public static Boolean isEmployee = false;
	public static final String SQL_SERVER_CONNECTION_STRING = "jdbc:sqlserver://MT000XSSQL94;databaseName=SPManager;user=slfadmin;password=spmdadmin;";
	public static Customer[] Queue = new Customer[]{};
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
	                	System.out.println("LoadedQueue");
	                	Thread.sleep(3000);
	                }
	                catch (Exception ex)
	                {

	                }
            	}
            }
        }.start();
	}

	//done
	public static Boolean Submission(Customer customer)
	{
		Customer_Customer = customer;
		String SQLString = "";
		SQLString = "INSERT INTO " + TABLE_NAME +  " (Name, Gender, Store, Floor, Department, SearchItems, CustomerDescription, DateTime, Preselection, BodyType, Budget, Preferences, Comments) ";
		SQLString = SQLString + "VALUES (" +
				customer.Name + ", " +
				customer.Gender + ", " +
				customer.Store + ", " +
				customer.Floor + ", " +
				customer.Department + ", " +
				customer.SearchItems + ", " +
				customer.CustomerDescription + ", " +
				customer.DateTime + ", " +
				customer.Preselection + ", " +
				customer.BodyType + ", " +
				customer.Budget + ", " +
				customer.Preferences + ", " +
				customer.Comments +
				");";

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
		String SQLString = "SELECT * FROM " + TABLE_NAME;

		Queue = new Customer[] {};
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
			GetStoreInfo(71, 3);
		int[] floors = new int[StoreInfo.length];
		for (int i = 0; i < StoreInfo.length; i++)
		{
			Boolean alreadyIn = false;
			for (int n = 0; n < floors.length; n++)
				if (floors[n] == StoreInfo[i].floor)
				{
					alreadyIn = true;
					break;
				}
			if (!alreadyIn)
				floors[i] = StoreInfo[i].floor;
		}
		return new int[] {0,1,2};
		//return floors;
	}

	public static String[] GetDepartments(int floor)//get the Departments from the JSON file
	{
		if (StoreInfo == null || StoreInfo.length == 0)
			GetStoreInfo(71, 3);
		String[] departments = new String[StoreInfo.length];
		for (int i = 0; i < StoreInfo.length; i++)
		{
			if (StoreInfo[i].floor == floor)
				departments[i] = StoreInfo[i].department;
		}
		return new String[] {"Mens Suits", "Womens Shoes", "Children"};
		//return departments;
	}

	public static void GetStoreInfo(int ZL_DIV_NBR, int ZL_STR_NBR)
	{
		String SQLString = "SELECT DISTINCT ZN_NAME, [FLR_NBR] FROM [SPManager].[dbo].[SLLNG_ZN] WHERE ZL_STORE_NBR = " + ZL_STR_NBR + " AND ZL_DIVN_NBR = "+ZL_DIV_NBR+" ORDER BY FLR_NBR";


		//StoreInfo =
	}

	public static void SaveInputFields()
	{

	}

	public static Customer[] GetCustomersSQL()//2nd
	{

		return new Customer[] {};
	}

	public static Boolean SQLRequest(String SQLString)//1st: create the connection to
	{
		try
        {
			 Statement stm = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(SQL_SERVER_CONNECTION_STRING);
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM dbo.ANDREW_CustomerDB");
            String[] result = new String[20];
            if(rs!=null){
                while (rs.next()){
                    for(int i = 0; i <result.length ;i++)
                    {
                        for(int j = 0; j <result.length;j++)
                        {
                            result[j]=rs.getString(i);
                        System.out.println(result[j]);
                        }
                    }
                }
            }

            //String result = new result[20];

        } catch (Exception e)
        {
            e.printStackTrace();
        }
		finally {

	    }

		return true;
	}


}

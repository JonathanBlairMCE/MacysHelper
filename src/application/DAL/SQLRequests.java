package application.DAL;
import application.Domain.Customer;
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
	public static final String SQL_SERVER_CONNECTION_STRING = "jdbc:sqlserver://MT000XSSQL94;databaseName=SPManager;user=slfadmin;password=spmdadmin;";
	public static Customer[] Queue = new Customer[]{};

	//done
	public static Boolean ADSecurityAuthenticate(String password, String username)
	{
		return true;
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

		return new int[] {};
	}

	public static String[] GetDepartments()//get the Departments from the JSON file
	{

		return new String[]{};
	}

	public static void SaveInputFields()
	{

	}

	public static void LoadQueue()//2nd
	{
		String SQLString = "SELECT * FROM " + TABLE_NAME;

		//Queue = GetCustomersSQL();
		//return new Customer[] {};
	}

	public static Boolean SQLRequest(String SQLString)//1st: create the connection to
	{
		try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(SQL_SERVER_CONNECTION_STRING);
            Statement stm = con.createStatement();
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

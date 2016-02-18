package application.DAL;
import application.Domain.Customer;

public class SQLRequests
{
	public static final String TABLE_NAME = "ANDREW_Cust";
	public static Customer Customer_Customer = new Customer();
	public static Customer Employee_Customer = new Customer();

	public static Boolean ADSecurityAuthenticate(String password, String username)
	{
		return true;
	}

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

	public static Boolean Accept(int Cust_ID)
	{
		String SQLString = "";
		SQLString = "DELETE FROM " + TABLE_NAME + " WHERE ID = " + Cust_ID;
		return SQLRequest(SQLString);
	}

	public static Customer[] LoadQueue()
	{

		return new Customer[] {};
	}

	public static Boolean CancelAppointment()
	{
		return Accept(Customer_Customer.ID);
	}

	public static Customer FullApptDetails(int Cust_ID)
	{

		return new Customer();
	}

	public static void SaveInputFields()
	{

	}

	public static Customer[] GetCustomersSQL()
	{

		return new Customer[] {};
	}

	public static Boolean SQLRequest(String SQLString)
	{

		return true;
	}


}

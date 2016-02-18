package application.DAL;
import application.Domain.Customer;

public class SQLRequests
{
	public static Boolean ADSecurityAuthenticate(String password, String username)
	{
		return true;
	}

	public static Boolean Submission(Customer customer)
	{

		return true;
	}

	public static Boolean Accept(int Cust_ID)
	{

		return true;
	}

	public static Customer[] LoadQueue()
	{

		return new Customer[] {};
	}

	public static Boolean CancelAppointment()
	{

		return true;
	}

	public static Customer FullApptDetails(int Cust_ID)
	{

		return new Customer();
	}

	public static void SaveInputFields()
	{

	}
	}


}

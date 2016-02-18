package application.DAL;

public class RefreshQueueTask extends Thread
{
	public void run()
	{
		while (true)
		{
			try
			{
				System.out.println("HEY");
				Thread.sleep(3000);
			}
			catch (Exception ex)
			{

			}
		}
	}
}

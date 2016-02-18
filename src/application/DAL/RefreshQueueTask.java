package application.DAL;

public class RefreshQueueTask extends Thread
{
	public void run()
	{
		while (true)
		{
			try
			{
				SQLRequests.LoadQueue();
				Thread.sleep(3000);
			}
			catch (Exception ex)
			{

			}
		}
	}
}

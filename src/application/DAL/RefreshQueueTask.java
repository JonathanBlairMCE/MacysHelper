package application.DAL;

import application.Domain.Customer;

public class RefreshQueueTask extends Thread
{
	public Customer[] previousQueue = new Customer[]{};
	public void run()
	{
		while (true)
		{
			try
			{
				SQLRequests.LoadQueue();
				Thread.sleep(3000);
				Customer[] parseQueue = SQLRequests.Queue;
				if (previousQueue == parseQueue)
				{

				}
			}
			catch (Exception ex)
			{

			}
		}
	}
}

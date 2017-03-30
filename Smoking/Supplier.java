import java.util.*;
import java.util.concurrent.*;

public class Supplier extends Smoker
{
  private final static int PREPARE_TIME = 1000;

	Semaphore tobacco = new Semaphore(0, true);
	Semaphore paper = new Semaphore(1, true);
	Semaphore matches = new Semaphore(2, true);
	Semaphore supplier = new Semaphore(3, true);

  Random rand = new Random();

	public synchronized boolean grabSupplies(Cigarette paper, Cigarette tobacco, Cigarette matches)
	{
    int prepareTime = 500;
    Thread.sleep(prepareTime);
		boolean ret = false;
    int flip = rand.nextInt(2);

    if(flip == 0)
    {
      System.out.println("Supplier putting paper on the table..");
      m_paper.release();

      System.out.println("Supplier putting matches on the table..");
      m_matches.release();
      ret = true;
    }

    else if (flip == 1)
    {
      System.out.println("Supplier putting tobacco on the table..");
      m_tobacco.release();

      System.out.println("Supplier putting matches on the table..");
      m_matches.release();
      ret = true;
    }

    else if (flip == 2)
    {
      System.out.println("Supplier putting tobacco on the table..");
      m_tobacco.release();

      System.out.println("Supplier putting paper on the table..");
      m_paper.release();
      ret = true;
    }
		return ret;
	}

	public synchronized void letGo(Cigarette paper, Cigarette tobacco, Cigarette matches)
	{
		paper.release();
		tobacco.release();
		matches.release();
	}

}

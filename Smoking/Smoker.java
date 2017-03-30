import java.util.*;
import java.util.concurrent.*;

public abstract class Smoker implements Callable<Boolean>
{

  	private final static int SMOKE_TIME = 1000;

protected final Semaphore m_tobacco;
protected final Semaphore m_paper;
protected final Semaphore m_matches;
protected final Semaphore m_supplier;

private final String m_name;

  public Smoker(Semaphore t, Semaphore p, Semaphore m, Semaphore s)
  {
      m_tobacco = t;
      m_paper = p;
      m_matches = m;
      m_supplier = s;
  }

  public Boolean call() throws Exception
  {
    try
    {
      int smokeTime = 500;
      while (true)
      {
        cigarette.acquire();
        if(this.tryAcquire())
        {
          System.out.printf("%s has all of the supplies...%n", m_name);
          Thread.sleep(smokeTime);
          m_supplier.release();
        }
        else
          this.release();
      }
    }

    catch (Exception e)
    {
        e.printStackTrace();
    }
  }

}

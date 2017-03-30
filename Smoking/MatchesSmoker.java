import java.util.concurrent.*;
public class MatchesSmoker implements Callable<Boolean>
{
	private final static int SMOKE_TIME = 1000;
  private final Cigarette m_paper;
	private final Cigarette m_tobacco;
  private final Cigarette m_matches;
	private final Supplier m_supplier;
	private final String m_name;

	public MatchesSmoker(String name, Supplier supplier, Cigarette paper, Cigarette tobacco, Cigarette matches)
	{
    m_paper = paper;
    m_tobacco = tobacco;
    m_matches = matches;
		m_name = name;
		m_supplier = supplier;
	}

  @Override
	public Boolean call()
	{
		try
		{
			int smokeTime = 500;
			while (true)
			{
				m_tobacco.acquire();
				if(m_paper.tryAcquire())
				{
					System.out.printf("%s has all of the supplies...%n", m_name);
					Thread.sleep(smokeTime);
					m_supplier.release();
				}
				else
				 	m_matches.release();
			}
		}

		catch (Exception e)
		{
				e.printStackTrace();
		}

		System.out.printf("%s is done smoking...%n", m_name);
		m_supplier.grabSupplies(m_paper, m_tobacco, m_matches);
		return true;
	}
}

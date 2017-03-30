import java.util.*;
import java.util.concurrent.*;

public class Cigarette
{
	private boolean m_taken;

	public Cigarette()
	{
		m_taken = false;
	}
	
	public synchronized boolean grab()
	{
		if (m_taken)
			return false;
		else
			m_taken = true;
		return m_taken;
	}

	public synchronized void release()
	{
		m_taken = false;
	}

	@Override
	public String toString()
	{ return String.format("Supply: %s", m_taken);}

}

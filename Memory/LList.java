import java.util.Iterator;
import java.util.NoSuchElementException;

public class LList<K> extends Comparable<K>,T> implements IList<K, T>, Iterable<T>
{
	private Node m_head;
	private int m_count;

	public LList()
	{
		m_head = new Node(null, null);
		m_count = 0;
		//node starts with a hole say 100mb
		//storing a class
	}

	@Override
	public void add(K key, T item)
	{
		Node n = new Node(key, item);
		Node loc = _findInsertLoc(key);
		Node temp = loc.m_next;
		loc.m_next = n;
		n.m_next = temp;
		m_count++;
	}

	@Override
	public boolean remove(K key)
	{
		Node loc = _findNodeLoc(key);
		if (loc == null)
		{
			return false;
		}
		else
		{
			loc.m_next = loc.m_next.m_next;
			m_count--;
			return true;
		}
	}

	@Override
	public T find(K key)
	{
		Node n = _findNodeLoc(key);
		if (n != null)
		{
			n = n.m_next;
		}
		if (n == null)
			return null;
		else
			return n.m_data;
	}

	@Override
	public boolean isEmpty()
	{
		return m_count == 0;
	}

	@Override
	public int getSize()
	{
		return m_count;
	}
/*
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer("[");
		if (!isEmpty())
		{
			Node node = m_head.m_next;
			sb.append(node.m_data.toString());
			while (node.m_next != null)
			{
				node = node.m_next;
				sb.append(", ");
				sb.append(node.m_data.toString());
			}
		}
		sb.append("]");
		return sb.toString();
	}
*/
	@Override
	public Iterator<T> iterator()
	{
		return new LIterator();
	}

	private Node _findInsertLoc(K key)
	{
		Node ret = m_head;
		while (ret.m_next != null)
		{
			if (ret.m_next.m_key.compareTo(key) <= 0)
			{
				break;
			}
			ret = ret.m_next;
		}
		return ret;
	}

	private Node _findNodeLoc(K key)
	{
		Node ret = null;
		Node cur = m_head;
		while (cur.m_next != null)
		{
			if (cur.m_next.m_key.compareTo(key) == 0)
			{
				ret = cur;
				break;
			}
			cur = cur.m_next;
		}
		return ret;
	}

	private class Node
	{
		private K m_key;
	 	private T m_data;
	 	private Node m_next;

		public Node(K id, T data)
		{
			m_key = key;
			m_data = data;
			m_next = null;
		}
	}

	private class LIterator implements Iterator<T>
	{
		private int m_loc = 0;

		@Override
		public boolean hasNext()
		{
			return (m_loc < getSize());
		}

		@Override
		public T next()
		{
			if (m_loc == getSize())
				throw new NoSuchElementException();

			Node cur = m_head;
			for (int i = 0; i <= m_loc; i++)
				cur = cur.m_next;
			m_loc++;
			return cur.m_data;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

}

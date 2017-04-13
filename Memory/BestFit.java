public class BestFit implements ISwapper
{
  public void init(int memSize)
  {
    for(int id = 0; id < m_count; id++)
    {
      if(memSize % m_data == 0)
      {
        return id;
      }
    }
  }
  public boolean load(IProcess p, IMemory mem) throws BlueScreenException
  {

  }
  public void unload(IProcess p, IMemory mem) throws BlueScreenException
  {
    if(key == id)
    {
      remove();
    }
  }
}

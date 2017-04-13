public class FirstFit implements ISwapper
{
  public void init(int memSize)
  {
    if(memSize > size)
    {
      add(id, size);
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
  //going thru to see where it is a hole and fits
}

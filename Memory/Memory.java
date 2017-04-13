public class Memory implements IMemory
{
  //starts at 0 -127
  public void load(IProcess p, int start, int end) throws BlueScreenException;
  {
    //pass process which is 0-9 (1)
  }
  public void unload(IProcess p) throws BlueScreenException
  {
    //passing a process
    //
  }
  public int getSize()
  {
    return size;
  }
  public void dump();
}

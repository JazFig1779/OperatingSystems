public interface IMemory
{
  public void load(IProcess p, int start, int end) throws BlueScreenException;
  public void unload(IProcess p) throws BlueScreenException;
  public int getSize();
  public void dump();

  //class block
  //string m_type - hole or process
  //id
  //sizes (int)
  //start and end (int)
  //check is process is null ----all in linked list
}

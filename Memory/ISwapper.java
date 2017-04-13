public interface ISwapper
{
  public void init(int memSize);
  public boolean load(IProcess p, IMemory mem) throws
  BlueScreenException;
  public void unload(IProcess p, IMemory mem) throws
  BlueScreenException;
}

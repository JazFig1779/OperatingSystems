public class Process implements IProcess
{
  public int getSize()
  {
    //10mb
    //no more hole, now a 10mb Process
    //0-9 is first node, next 10-99, no load in mem

    //5mb 2 process 10-14
    //hole of 15-99

    //20mb 3 process 15-34
    //hole of 35-99
    return size;
  }
  public int getId()
  {
    return id;
    //id of 1
    //id 2
    //id 3
  }
}

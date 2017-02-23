import java.io.*;
import java.util.*;

public class Master
{
  public static void main(String args[]) throws Exception
  {
    new Master().go();
  }

  private void go() throws Exception
  {
    System.out.println();
    List<Process> list = new ArrayList<Process>();
    for (int i = 0; i < 10; i++)
    {
      System.out.printf("Starting process %d ...%n",i);
      Process p = new ProcessBuilder("java", "Worker").start();
      int Xpt = i;
      int Ypt = Xpt + 10;
      sendParameters(p, Xpt, Ypt);
      list.add(p);
    }

    for (Process p : list)
    {
      getPoint(p);
    }
  }

  private void sendParameters(Process p, int Xpt, int Ypt) throws Exception
  {
    System.out.printf("Sending parameters for range %d-%d to process ...%n",Xpt,Ypt);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream(), "UTF-8"));
    pw.println(Xpt);
    pw.println(Ypt);
    pw.flush();
  }

  private void getPoint(Process p) throws Exception
  {
    p.waitFor();
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
    String line = br.readLine();
    while (line != null)
    {
      System.out.println(line);
      line = br.readLine();

    }
  }
}

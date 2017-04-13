import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main
{
  public static void main(String[] args)
  {
	   (new Main()).go();
  }

  private void go() throws Exception
  {
    Block block = new Block(0, 100);
    LList<K> list = new LList<K>(block);
  }
}

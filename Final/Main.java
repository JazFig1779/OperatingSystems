import java.util.*;
import java.util.concurrent.*;

public class Main
{
  private final static pair = 1;

  public static void main(String[] args)
  {
    (new Main()).go();
  }

  public void go()
  {
    Scanner in = new Scanner(System.in);
    System.out.println("How many numbers would you like to generate? ");
    int n = in.nextInt();
    int[] generator = new int[n];

    for(int i = 0; i < n; i++)
    {
      Random rand = new Random();
      int nums = rand.nextInt(10);
      generator[i] = nums;
    }

    List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
		for (int i = 0; i < n; i++)
		{
			Callable<Integer> task = new MyThread(generator[i], generator[i+1]);
			tasks.add(task);
		}

		ExecutorService executor = Executors.newFixedThreadPool(n/2);
		List<Future<Integer>> futures = executor.invokeAll(tasks);

		int[] sortedNums = new int[];
		for (Future<Double> f : futures)
		{

		}

		executor.shutdown();

		System.out.printf("Sorted Numbers = %s%n", sortNums);
  //  System.out.println(Arrays.toString(generator));
  }

  public class MyThread implements Callable<Integer>
  {
    private static int m_id = 0;
    private int m_code;
    private int m_start;
    private int m_end;
    private List<Integer> sortedNums;

    public MyThread(int start, int end)
    {
      m_code = m_id++;
      m_start = start;
      m_end = end;
      m_pair = pair;
    }

    @Override
    public Double call()
    {
      System.out.printf("Thread %s: working group %s%n", m_code, m_pair);
      int intial = 0;
      double total = 0.0;
      for (int i = 0; i < n; i++)
      {//where to sort
        if (generator[i] < generator[i+1])
          sortedNums.add(i);
        intial++;
      }

      System.out.printf("Thread %s: chunk = %s%n", m_code, total);

      return total;
    }

  }
}

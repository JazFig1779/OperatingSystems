import java.util.*;
import java.util.concurrent.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		List<Callable<Boolean>> smokers = new ArrayList<Callable<Boolean>>();
		List<Callable<Boolean>> supplier = new ArrayList<Callable<Boolean>>();
		smokers.add(new PaperSmoker("Paper Smoker", supplier));
		smokers.add(new TobaccoSmoker("Tobacco Smoker", supplier));
		smokers.add(new MatchesSmoker("Matches Smoker", supplier));
		supplier.add(new Supplier(smokers));

		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.invokeAll(smokers, supplier);
		executor.shutdown();
	}
}

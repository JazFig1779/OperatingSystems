public class SnailShell
{

	public static void main(String[] args) throws IOException
	{

		System.out.print("Welcome to Snail Shell!\n");

		while(true)
		{
			Scanner input = new Scanner(System.in);
			String command;
			System.out.print("snailShell>");
				command = input.next();

				if(command.equals("l") || command.equals("list"))
				{
						printList();
				}

			if(command.equals("u") || command.equals("up"))
			{
					String newDirectory;
					File file = new File("SnailShell.java");
					newDirectory = file.getAbsoluteFile().getParent();
					System.out.println(newDirectory);
					continue;
			}

			if(command.equals("w") || command.equals("wai"))
			{
					String currentDirectory;
					File file = new File("SnailShell.java");
					currentDirectory = file.getAbsolutePath();
					System.out.println(currentDirectory);
					continue;
			}

			if(command.equals("e") || command.equals("exit"))
			{
				System.out.print("bye");
				System.exit(0);
			}

			if(command.equals("h")) // || unknown
			{
				System.out.print("(l)ist: lists contents of current directory\n");
				System.out.print("(d)own [dir]: moves into the specified child directory\n");
				System.out.print("(u)p: moves to the parent directory\n");
				System.out.print("(w)ai: prints the current directory\n");
				System.out.print("(e)xit: exits the shell\n");
				System.out.print("(h)elp: prints a list of the supported commands\n");
				continue;
			}
		}
	}

	private static void printList()
	{
		try
		{
			File f = new File("C:/Users/Jasmin/Documents/2017/OperatingSytems/Shell");
			File[] files = f.listFiles();

			for(File a : files)
			{
				System.out.println(a);
			}
		}
		catch (Exception e)
		{
						e.printStackTrace();
		}
	}
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AssemblyParser {
	public static void main(String[] args) throws IOException {
		ArrayList<Line> memory = new ArrayList<Line>();
		// Stores commands and data
		try {
			BufferedReader reader = new BufferedReader(new FileReader("assembly.txt"));
			String test = "";
			while ((test = reader.readLine()) != null) {
				// Splits the line into an array
				String[] textarray = test.split(" ");
				// Line object to add into array
				Line loader = new Line(textarray);
				//adds line into memory
				memory.add(loader);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] data_storage = new String[16];
		//Keeps track of end filled addresses
		int data_amount = 0;
		int end_block;
		// loop through memory and display a text version of it
		for (int i = 0; i < data_storage.length; i++) {
			System.out.print("\n" + convertToBinary(4,i) + "|");
			if (i < memory.size()) {
				if (memory.get(i).getData() != null) {
					//Farthest empty address
					end_block = (data_storage.length - data_amount - 1);
					//Sets farthest address with proper data
					data_storage[end_block] = memory.get(i).getData();
					memory.get(i).setData("" + end_block);
					//increment the farthest address to indicate it's full
					data_amount += 1;
				}
				//prints command line in binary format
				System.out.print(memory.get(i));
			}
			if (data_storage[i] != null) {
				//prints the binary value of inserted integer into end addresses
				System.out.print(convertToBinary(8,Integer.parseInt(data_storage[i])));
			}
		}
	}
	//Formats binary numbers to the proper place holders
	public static String convertToBinary(int place, int binary){
		String output = String.format("%"+place+"s", Integer.toBinaryString(binary)).replace(' ', '0');
		return output;
	}

}

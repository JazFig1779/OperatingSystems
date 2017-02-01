public class Line {
	// 
	private String command;
	private String data;

	public Line() {

	}

	public Line(String[] text) {
		command = text[0];
		if (text.length == 2) {
			data = text[1];
		}
	}

	//setters and getters for data and command
	public String getCommand() {
		return this.command;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String input) {
		this.data = input;
	}

	public void setCommand(String input) {
		this.command = input;
	}
	//Convert's assembly command to binary for printing
	@SuppressWarnings("static-access")
	public String toString() {
		switch (this.command) {
		case "LDA":
			command = "0000";
			break;
		case "ADD":
			command = "0001";
			break;
		case "SUB": 
			command = "0010";
			break;
		case "OUT":
			command = "1110";
			break;
		case "HLT": 
			command = "1111";
			break;
		}
		//if the data portion of the line is not null get the binary value of data
		if (data != null) {
			data = Integer.toBinaryString(Integer.parseInt(data));
		}
		//if the data is empty replace data with X's
		if (data == null){
			data = "XXXX";
		}
		//Prints the binary version of the command
		String output = this.getCommand()+ "" + this.getData();
		return output;

	}
}
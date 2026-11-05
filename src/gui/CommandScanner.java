package gui;
import java.util.Scanner;
public class CommandScanner {
	
	private static final Scanner SCANNER = new Scanner(System.in);

	private CommandScanner() {
    }

	public static int readInt(int max){
		while (true){
			if (SCANNER.hasNextInt()){
			int index = SCANNER.nextInt();
			if (index > 0 && index <= max) {
				return index;
			}
		} else {
			SCANNER.next();
		}
		MessageViewer.println(data.MessageCatalog.COMMAND_ERROR_LOG);
		}
	}
}

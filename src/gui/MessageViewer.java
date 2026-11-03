package gui;

import java.util.List;
public class MessageViewer {
	
	public static void println(String message) {
		
		System.out.println(message);
	}

	public static void print(String message) {
		
		System.out.print(message);
	}

	public static void printf(String format, Object... args){

		System.out.printf(format, args);
	}

	public static void commandSelectMessage(List<? extends data.Named> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf(data.MessageCatalog.COMMAND_SELECT, i + 1, list.get(i).getName());
		}
	}

}

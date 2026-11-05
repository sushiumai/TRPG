package gui;

import java.util.List;
import java.util.function.Function;
public class MessageViewer {
	private MessageViewer(){}
	
	public static void println(String message) {
		
		System.out.println(message);
	}

	public static void print(String message) {
		
		System.out.print(message);
	}

	public static void printf(String format, Object... args){

		System.out.printf(format, args);
	}

	private static <T> void printNumberedList(List<T> list, Function<T, String> formatter) {

		for (int i = 0; i < list.size(); i++) {
			String format = formatter.apply(list.get(i));
			printf(data.MessageCatalog.COMMAND_SELECT, i + 1, format);
		}
	}

	public static void showTargets(List<? extends character.Character> targets) {

		printNumberedList(targets, c-> c.getName());
	}

	public static void showSkills(List<? extends skill.Skill> skills) {

		printNumberedList(skills, s-> String.format("%s (MP: %d)", s.getName(), s.getMpCost()));
	}
	

}

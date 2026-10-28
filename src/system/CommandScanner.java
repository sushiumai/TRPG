package system;
import java.util.List;
import java.util.Scanner;

import character.Character;
public class CommandScanner {
	
	public static BattleAction battleCommand(Character c, List<? extends Character> party) {
		Scanner scanner = new Scanner(System.in);
		int command = 0;
		while (true) {

			gui.MessageViewer.println(data.MessageCatalog.FIRST_COMMAND_LOG);
			command = scanner.nextInt();
			
			if (command == 1 || command == 2) {
				break;
			}
			gui.MessageViewer.println(data.MessageCatalog.COMMAND_ERROR_LOG);
		}
		if (command == 1) {
			while (true) {
				gui.MessageViewer.println(data.MessageCatalog.ATTACK_TARGET);
				for (int i = 0; i < party.size(); i++) {
					gui.MessageViewer.println(String.format(data.MessageCatalog.TARGET_SELECT, i,  party.get(i).getName()));
				}
				command = scanner.nextInt();
				
				if (command < party.size()) {
					break;
				}
				gui.MessageViewer.println(data.MessageCatalog.COMMAND_ERROR_LOG);
			}
			
			//いったん通常攻撃を割り当てている
			return new PhysicalAction(c, party.get(command), data.SkillMaster.NORMAL_ATTACK);
			
		}
		if (command == 2) {
			return new GuardAction(c);
		}
		return new PhysicalAction(c, party.get(0), data.SkillMaster.NORMAL_ATTACK);
	}

}

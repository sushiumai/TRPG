package system.battle.controller;

import character.Character;
import character.Enemy;
import character.Player;
import data.SkillMaster;
import java.util.List;
import system.battle.action.PhysicalAction;
public class BattleController {
	
	private BattleController() {
	}
	
	public static void startBattle(List<Player> allies, List<Enemy> enemies) {

		gui.MessageViewer.println(data.MessageCatalog.ENCOUNT_LOG);

		while (TurnController.isPartyAlive(allies) && TurnController.isPartyAlive(enemies)) {

			TurnController.turnControll(allies, enemies);

		}
		judgeBattleResult(allies, enemies);
	}

	private static void judgeBattleResult(List<Player> allies, List<Enemy> enemies) {
			if (TurnController.isPartyAlive(allies)) {

				gui.MessageViewer.println(data.MessageCatalog.WIN_LOG);

				int totalExp = 0;
				for (Enemy enemy : enemies) {
					if (enemy.getHp() <= 0) {
						totalExp += enemy.getDropExp();
					}
				}
				for (Player ally : allies) {
					system.GrowthSystem.giveExp(ally, totalExp);
				}
			} else {
				gui.MessageViewer.println(data.MessageCatalog.LOSE_LOG);
				//TODO負けた後の処理は未実装

			}

	}
	

	

}

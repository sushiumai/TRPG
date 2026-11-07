package system.battle.controller;

import character.Enemy;
import character.Player;
import skill.Skill;
import system.LevelUpResult;

import java.util.List;
public class BattleController {
	
	private BattleController() {
	}
	
	public static void startBattle(List<Player> allies, List<Enemy> enemies) {

		gui.MessageViewer.println(data.MessageCatalog.ENCOUNTER_LOG);

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
					gui.MessageViewer.printf(data.MessageCatalog.EXP_LOG, totalExp);
					LevelUpResult result = system.GrowthSystem.giveExp(ally, totalExp);
					if (result.isLevelUp()) {
						gui.MessageViewer.printf(data.MessageCatalog.LEVEL_UP_LOG, ally.getName(), result.newLevel());
					}
					for (Skill skill : result.learnedSkills()) {
						gui.MessageViewer.printf(data.MessageCatalog.SKILL_LEARN_LOG, ally.getName(), skill.getName());
					}
				}
			} else {
				gui.MessageViewer.println(data.MessageCatalog.LOSE_LOG);
				//TODO負けた後の処理は未実装

			}

	}
	

	

}

package system;

import java.util.List;

import character.Character;
import character.Enemy;
import character.Player;
import data.SkillMaster;
public class BattleController {
	
	private TurnController manager;
	
	public BattleController() {
		this.manager = new TurnController();
	}
	
	public void startBattle(List<Player> playerParty, List<Enemy> enemyParty) {
		
		gui.MessageViewer.println(data.MessageCatalog.ENCOUNT_LOG);
		
		while (isPartyAlive(playerParty) && isPartyAlive(enemyParty)) {
			
			for (Character ally : playerParty) {
				
                // ※敵のターゲット選びはとりあえず敵チームの先頭(0番目)にしています
                manager.addAction(new PhysicalAction(ally, enemyParty.get(0), SkillMaster.DOUBLE_SLASH));
                
			}
			for (Character enemy : enemyParty) {
                manager.addAction(new PhysicalAction(enemy, playerParty.get(0), SkillMaster.NORMAL_ATTACK));
			}
			
			manager.startTurn();
			
		}
		
		if (isPartyAlive(playerParty)) {
			
			gui.MessageViewer.println(data.MessageCatalog.WIN_LOG);
			
			int totalExp = 0;
			for (Enemy enemy : enemyParty) {
				if (enemy.getHp() <= 0) {
					totalExp += enemy.getDropExp();
				}
			}
			for (Player ally : playerParty) {
				system.GrowthSystem.giveExp(ally, totalExp);
			}
		} else {
			gui.MessageViewer.println(data.MessageCatalog.LOSE_LOG);
			
		}
	}
	
	private boolean isPartyAlive(List<? extends Character> party) {
		
		for (Character c : party) {
			if (c.getHp() > 0) {
				
				return true;
			}
		}
		
		return false;
	}
	

}

package system;

import character.Character;
import character.Enemy;
import character.Player;
import data.SkillMaster;
import java.util.List;
public class BattleController {
	
	private final TurnController manager;
	
	public BattleController() {
		this.manager = new TurnController();
	}
	
	public void startBattle(List<Player> allies, List<Enemy> enemies) {
		
		gui.MessageViewer.println(data.MessageCatalog.ENCOUNT_LOG);
		
		while (isPartyAlive(allies) && isPartyAlive(enemies)) {
			
			for (Character ally: allies) {
				
                manager.addAction(BattleCommandController.selectAction(ally, enemies, allies));
                
			}
			
			//敵の動きはいったん固定している
			for (Character enemy : enemies) {
                manager.addAction(new PhysicalAction(enemy, SkillMaster.NORMAL_ATTACK, List.of(allies.get(0))));
			}
			
			manager.startTurn();
			
		}
		
		if (isPartyAlive(allies)) {
			
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

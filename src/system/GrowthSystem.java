package system;

import character.Player;

public class GrowthSystem {
	
	public static final int[] EXP_TABLE = {
			0,
			0, 7, 23, 47, 110,					//Lv5
			220, 450, 800, 1300, 2000,			//Lv10
			2900, 4000, 5500, 7500, 10000,		//Lv15
			13000, 17000, 21000, 25000, 29000,	//Lv20
			33000, 37000, 41000, 45000, 49000,	//Lv25
			53000, 57000, 61000, 65000, 69000	//Lv30
	};
	
	private static final int MAX_LEVEL = 30;
	
	public static void giveExp(Player target, int earnedExp) {
		
		target.setExp(earnedExp);
		
		while (target.getLevel() < MAX_LEVEL && target.getExp() >= EXP_TABLE[target.getLevel() + 1]) {
			
			target.setLevel();
			
			target.updateStats(target.getLevel());
			
		}
		
	}

}

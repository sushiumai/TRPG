package system;
import character.Player;
import skill.Skill;

public class GrowthSystem {

	private GrowthSystem(){}
	
	private static final int[] EXP_TABLE = {
			0,
			0, 7, 23, 47, 110,					//Lv5
			220, 450, 800, 1300, 2000,			//Lv10
			2900, 4000, 5500, 7500, 10000,		//Lv15
			13000, 17000, 21000, 25000, 29000,	//Lv20
			33000, 37000, 41000, 45000, 49000,	//Lv25
			53000, 57000, 61000, 65000, 69000	//Lv30
	};
	
	private static final int MAX_LEVEL = 30;

	public static int getExpToNextLevel(int level, int currentExp) {
		if (level >= MAX_LEVEL) {
			return 0;
		}
		return EXP_TABLE[level + 1] - currentExp;
	}
	
	public static void giveExp(Player target, int earnedExp) {
		
		target.setExp(target.getExp() + earnedExp);
		gui.MessageViewer.println(String.format(data.MessageCatalog.EXP_LOG, earnedExp));
		
		while (target.getLevel() < MAX_LEVEL && target.getExp() >= EXP_TABLE[target.getLevel() + 1]) {
			
			target.levelUp();
			
			gui.MessageViewer.println(String.format(data.MessageCatalog.LEVEL_UP_LOG, target.getName(), target.getLevel()));
			
			target.updateStatus(target.getLevel());
			learnSkill(target);
		}
		
	}

	public static void learnSkill(Player target){
		for (Skill skill : data.SkillMaster.getSkillsToLearn(target.getJob(), target.getLevel())) {
				target.learnSkill(skill);
				gui.MessageViewer.println(String.format(data.MessageCatalog.SKILL_LEARN_LOG, target.getName(), skill.getName()));
		}
	}

}

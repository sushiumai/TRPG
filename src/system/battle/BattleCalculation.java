package system.battle;
import character.Character;
public class BattleCalculation {
	
	private BattleCalculation(){}
	
	public static int calculateDamage(Character actor, Character target, double multiplier) {
		int baseDamage = (actor.getPower() /2) - (target.getDefense() / 4);
		int finalDamage = (int)(baseDamage * multiplier);
		if (target.isDefending()) {
			finalDamage = finalDamage / 2;
		}
		return Math.max(finalDamage, 1);
	}

}

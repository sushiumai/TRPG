package system;
import character.Character;
public class BattleCalculation {
	
	
	
	public static int calculateDamage(Character actor, Character target, double multiplier) {
		int baseDamage = (actor.getPower() /2) - (target.getDefence() / 4);
		int finalDamage = (int)(baseDamage * multiplier);
		if (actor.isDefending()) {
			finalDamage = finalDamage / 2;
		}
		return Math.max(finalDamage, 1);
	}

}

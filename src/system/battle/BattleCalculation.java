package system.battle;
import character.Character;
import condition.GuardCondition;

public class BattleCalculation {
	
	private BattleCalculation(){}

	public static int calculateDamage(Character actor, Character target, double multiplier) {
		int baseDamage = (actor.getTotalPower() /2) - (target.getDefense() / 4);
		int finalDamage = (int)(baseDamage * multiplier);
		if (target.hasCondition(GuardCondition.class)) {
			finalDamage = finalDamage / 2;
		}
		return Math.max(finalDamage, 1);
	}

}

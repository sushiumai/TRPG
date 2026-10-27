package system;

import character.Character;
import skill.PhysicalSkill;

public class PhysicalAction extends BattleAction {
	private PhysicalSkill skill;

	public PhysicalAction(Character actor, Character target, PhysicalSkill skill) {
		super(actor, target);
		this.skill = skill;
	}

	@Override
	protected void execute() {

		if (actor.getMp() < skill.getMpCost()) {
			return;
		}
		actor.reduceMp(skill.getMpCost());
		int damage = system.BattleCalculation.calculateDamage(actor, target, skill.getMultiplier());
		target.reduceHp(damage);
	}

}

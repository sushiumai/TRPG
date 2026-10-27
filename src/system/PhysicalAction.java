package system;

import character.Character;
import data.SkillMaster;
import skill.PhysicalSkill;

public class PhysicalAction extends BattleAction {
	private PhysicalSkill skill;

	public PhysicalAction(Character actor, Character target, PhysicalSkill skill) {
		super(actor, target);
		this.skill = skill;
	}

	@Override
	protected void execute() {
		if (this.actor.getHp() <= 0) {
			return;
		}

		if (this.actor.getMp() < this.skill.getMpCost()) {
			this.skill = SkillMaster.NORMAL_ATTACK;
		}
		this.actor.reduceMp(this.skill.getMpCost());
		System.out.println(actor.getName() + "の" + skill.getName());
		for (int i = 1 ; i <= skill.getCount() ; i++ ) {
			int damage = system.BattleCalculation.calculateDamage(actor, target, skill.getMultiplier());
			target.reduceHp(damage);
			System.out.println(target.getName() + "に" + damage + "ダメージ");
			
		}
		
	}
	
}


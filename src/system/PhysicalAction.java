package system;

import character.Character;
import data.MessageCatalog;
import data.SkillMaster;
import gui.MessageViewer;
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
		MessageViewer.println(String.format(MessageCatalog.SKILL_LOG, this.actor.getName(), this.skill.getName()));
		for (int i = 0 ; i < skill.getCount() ; i++ ) {
			int damage = system.BattleCalculation.calculateDamage(actor, target, skill.getMultiplier());
			target.reduceHp(damage);
			MessageViewer.println(String.format(MessageCatalog.HIT_LOG, this.target.getName(), damage));
			
		}
	}
	
}


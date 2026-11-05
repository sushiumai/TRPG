package system.battle.action;

import character.Character;
import data.MessageCatalog;
import data.SkillMaster;
import gui.MessageViewer;
import skill.PhysicalSkill;
import system.battle.BattleCalculation;

public class PhysicalAction extends BattleAction {
	private PhysicalSkill skill;

	public PhysicalAction(Character actor, PhysicalSkill skill, java.util.List<? extends Character> targets) {
		super(actor, targets);
		this.skill = skill;
	}

	@Override
	public void execute() {
		if (this.actor.getHp() <= 0) {
			return;
		}

		this.actor.reduceMp(this.skill.getMpCost());
		MessageViewer.println(String.format(MessageCatalog.SKILL_LOG, this.actor.getName(), this.skill.getName()));
		for (int i = 0; i < this.skill.getCount(); i++){
			for (Character target : this.getTargets()) {
				applyDamage(target);
			}
		}
	}

	private void applyDamage(Character target) {
		int damage = BattleCalculation.calculateDamage(this.actor, target, this.skill.getMultiplier());
		target.reduceHp(damage);
		MessageViewer.println(String.format(data.MessageCatalog.DAMAGE_LOG, target.getName(), damage));
	}
	
}

package system.battle.action;

import character.Character;
import character.Enemy;
import data.MessageCatalog;
import gui.MessageViewer;
import skill.PhysicalSkill;
import system.battle.BattleCalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhysicalAction extends BattleAction {
	private PhysicalSkill skill;

	public PhysicalAction(Character actor, PhysicalSkill skill, java.util.List<? extends Character> targets) {
		super(actor, targets);
		this.skill = skill;
	}

	@Override
	public void execute(List<Enemy> enemies) {
		this.updateTargets(enemies);
		this.actor.reduceMp(this.skill.getMpCost());
		MessageViewer.printf(MessageCatalog.SKILL_LOG, this.actor.getName(), this.skill.getName());
		for (int i = 0; i < this.skill.getCount(); i++){
			for (Character target : this.getTargets()) {
				applyDamage(target);

			}
		}
	}

	private void applyDamage(Character target) {
		if (target.isDead()) {
			return;
		}
		int damage = BattleCalculation.calculateDamage(this.actor, target, this.skill.getMultiplier());
		target.reduceHp(damage);
		if (target.isDead()){
			if (target instanceof Enemy){
				MessageViewer.printf(MessageCatalog.KILL_LOG, target.getName());
			} else {
				MessageViewer.printf(MessageCatalog.SLAIN_LOG, target.getName());
			}
		}
		MessageViewer.printf(data.MessageCatalog.DAMAGE_LOG, target.getName(), damage);
	}
	//TODO:敵行動時、target.isDeadで敵が敵を殴る挙動になる
	private void updateTargets(List<Enemy> enemies){
		this.targets.removeIf(Character::isDead);
		List<Enemy> aliveEnemies = new ArrayList<>(enemies);
		aliveEnemies.removeIf(Character::isDead);
		if (this.targets.isEmpty()) {
			Random random = new Random();
			int index = random.nextInt(aliveEnemies.size());
			this.setTargets(List.of(aliveEnemies.get(index)));
		}

	}
	
}

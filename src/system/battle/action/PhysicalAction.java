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
		List<Enemy> aliveEnemies = this.updateTargets(enemies);
		this.actor.reduceMp(this.skill.getMpCost());
		MessageViewer.printf(MessageCatalog.SKILL_LOG, this.actor.getName(), this.skill.getName());
		for (int i = 0; i < this.skill.getCount(); i++){
			for (Character target : this.getTargets()) {
				applyDamage(target);
		for (Enemy enemy : aliveEnemies) {
			if (enemy.isDead()) {
				MessageViewer.printf(MessageCatalog.KILL_LOG, enemy.getName());
			}
		}
			}
		}
	}

	private void applyDamage(Character target) {
		int damage = BattleCalculation.calculateDamage(this.actor, target, this.skill.getMultiplier());
		target.reduceHp(damage);
		MessageViewer.printf(data.MessageCatalog.DAMAGE_LOG, target.getName(), damage);
	}
	private List<Enemy> updateTargets(List<Enemy> enemies){
		this.targets.removeIf(Character::isDead);
		List<Enemy> aliveEnemies = new ArrayList<>(enemies);
		aliveEnemies.removeIf(Character::isDead);
		if (this.targets.isEmpty()) {
			Random random = new Random();
			int index = random.nextInt(enemies.size());
			this.setTargets(List.of(enemies.get(index)));
		}
		return aliveEnemies;

	}
	
}

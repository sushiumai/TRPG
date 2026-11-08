package app;

import character.Enemy;
import character.EnemyFactory;
import character.Player;
import common.Job;
import data.EnemyMaster;
import item.WeaponFactory;
import java.util.ArrayList;
import java.util.List;
import system.battle.controller.BattleController;

public class Main {

	public static void main(String[] args) {

		Player hero = character.PlayerFactory.createPlayer(Job.HERO);
		hero.equip(WeaponFactory.createOldSword());
		List<Player> playerParty = new ArrayList<>();
		playerParty.add(hero);
		system.GrowthSystem.giveExp(hero, 100);

		List<Enemy> enemyParty = new ArrayList<>();
		enemyParty.add(EnemyFactory.createEnemy(EnemyMaster.SLIME));
		enemyParty.add(EnemyFactory.createEnemy(EnemyMaster.SLIME));

		BattleController.startBattle(playerParty, enemyParty);

		
	}

}
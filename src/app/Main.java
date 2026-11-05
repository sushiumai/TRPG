package app;

import character.Enemy;
import character.EnemyFactory;
import character.Hero;
import character.Player;
import item.WeaponFactory;
import java.util.ArrayList;
import java.util.List;
import system.battle.controller.BattleController;

public class Main {

	public static void main(String[] args) {

		Hero hero = new Hero();
		hero.equip(WeaponFactory.createOldSword());
		List<Player> playerParty = new ArrayList<>();
		playerParty.add(hero);
		system.GrowthSystem.giveExp(hero, 100);

		List<Enemy> enemyParty = new ArrayList<>();
		enemyParty.add(EnemyFactory.createSlime());

		BattleController.startBattle(playerParty, enemyParty);

		
	}

}
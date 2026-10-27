import java.util.ArrayList;
import java.util.List;

import character.Enemy;
import character.Hero;
import character.Player;
import data.EnemyFactory;
import system.BattleController;

public class Main {

	public static void main(String[] args) {

		Hero hero = new Hero();

		List<Player> playerParty = new ArrayList<>();
		playerParty.add(hero);

		List<Enemy> enemyParty = new ArrayList<>();
		enemyParty.add(EnemyFactory.createSlime());

		BattleController battle = new BattleController();
		battle.startBattle(playerParty, enemyParty);

		System.out.println(hero.getHp());
		
	}

}
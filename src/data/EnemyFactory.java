package data;

import character.Enemy;

public class EnemyFactory {

	//Enemy(int maxHp, int maxMp, int power, int magicPower,int defense, int speed, String name, int dropExp)

	public static Enemy createSlime() {
		return new Enemy(10, 0, 7, 0, 4, 3, "青スライム", 3);
		
	}

}

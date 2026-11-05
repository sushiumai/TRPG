package character;

import data.EnemyMaster;

public class EnemyFactory {
	private EnemyFactory() {
    }

	public static Enemy createEnemy(EnemyMaster enemyMaster) {
		return new Enemy(enemyMaster);
	}

}

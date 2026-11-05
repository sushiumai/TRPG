package character;

import data.EnemyMaster;
public class Enemy extends Character {

	protected int dropExp;

	public Enemy(EnemyMaster enemyMaster) {

		super(enemyMaster.getBaseStatus(), enemyMaster.getName());
		this.dropExp = enemyMaster.getDropExp();
	}
	
	public int getDropExp() {
		return this.dropExp;
	}

}

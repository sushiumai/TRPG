package character;

import data.EnemyMaster;

public class EnemyFactory {
	private EnemyFactory() {
    }

	public static Enemy createEnemy(EnemyMaster enemyMaster) {
		return new Enemy(enemyMaster);
	}

	//敵リストを受け取り、同名の敵が2体以上いる場合のみ A, B, C... を付与してリネームするメソッド
	public static void renameDuplicateEnemies(java.util.List<Enemy> enemies) {
		java.util.Map<String, Integer> nameCountMap = new java.util.HashMap<>();
		for (Enemy enemy : enemies) {
			String name = enemy.getName();
			nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
		}
		java.util.Map<String, Integer> nameIndexMap = new java.util.HashMap<>();
		for (Enemy enemy : enemies) {
			String name = enemy.getName();
			if (nameCountMap.get(name) >= 2) {
				int index = nameIndexMap.getOrDefault(name, 0);
				char suffix = (char) ('A' + index);
				enemy.setName(name + " " + suffix);
				nameIndexMap.put(name, index + 1);
			}
		}
	}

}

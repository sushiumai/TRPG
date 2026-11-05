package data;

public enum EnemyMaster {

    SLIME(new BattleStatus(10, 0, 7, 0, 4, 3), "青スライム", 3);

    private final BattleStatus baseStatus;
    private final String name;
    private final int dropExp;

    EnemyMaster(BattleStatus battleStatus, String name, int dropExp) {
        this.baseStatus = battleStatus;
        this.name = name;
        this.dropExp = dropExp;
    }

    public BattleStatus getBaseStatus() {
        return this.baseStatus;
    }
    public int getMaxHp() {
        return this.baseStatus.maxHp();
    }
    public int getMaxMp() {
        return this.baseStatus.maxMp();
    }
    public int getPower() {
        return this.baseStatus.power();
    }
    public int getMagicPower() {
        return this.baseStatus.magicPower();
    }
    public int getDefense() {
        return this.baseStatus.defense();
    }
    public int getSpeed() {
        return this.baseStatus.speed();
    }
    public String getName() {
        return this.name;
    }
    public int getDropExp() {
        return this.dropExp;
    }
}

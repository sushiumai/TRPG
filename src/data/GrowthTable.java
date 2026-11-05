package data;

public class GrowthTable {
    private final int[] hp;
    private final int[] mp;
    private final int[] power;
    private final int[] magicPower;
    private final int[] defense;
    private final int[] speed;

    public GrowthTable(int[] hp, int[] mp, int[] power, int[] magicPower, int[] speed) {
        this.hp = hp;
        this.mp = mp;
        this.power = power;
        this.magicPower = magicPower;
        this.speed = speed;
        //DFはSPDの半分とする
        this.defense = new int[speed.length];
        for (int i = 0; i < speed.length; i++) {
            this.defense[i] = speed[i] / 2;
        }
    }
    public BattleStatus getStatusAtLevel(int level) {
        int l = Math.clamp(level, 1, hp.length - 1);
        return new BattleStatus(hp[l], mp[l], power[l], magicPower[l], defense[l], speed[l]);
    }
}

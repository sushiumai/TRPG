package item;

public enum Equipment {

    HANDS(0, 0, "素手", WeaponType.HANDS),
    OLDSWORD(4, 2, "古びた剣", WeaponType.SWORD),
    OLDWAND(2, 4, "古びた杖", WeaponType.WAND),
    OLDDAGGER(3, 3, "古びたダガー", WeaponType.DAGGER);


    int power;
    int magicPower;
    String name;
    WeaponType type;
    Equipment(int power, int magicPower, String name, WeaponType type) {
        this.power = power;
        this.magicPower = magicPower;
        this.name = name;
        this.type = type;
    }

    public int getPower() {
        return this.power;
    }
    public int getMagicPower() {
        return this.magicPower;
    }
    public String getName() {
        return this.name;
    }
    public WeaponType getType() {
        return this.type;
    }
}

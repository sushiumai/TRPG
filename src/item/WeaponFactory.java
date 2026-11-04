package item;

public class WeaponFactory {

	//Weapon(int power, int magicPower, String name, WeaponType type)
	
	public static Weapon createHands() {
		return new Weapon(0, 0, "素手", WeaponType.NONE);
	}

	public static Weapon createOldSword() {
		return new Weapon(4, 2, "古びた剣", WeaponType.SWORD);

	}

	public static Weapon createOldWand() {
		return new Weapon(2, 4, "古びた杖", WeaponType.WAND);
	}

	public static Weapon createOldDagger() {
		return new Weapon(3, 3, "古びたダガー", WeaponType.DAGGER);
	}

}

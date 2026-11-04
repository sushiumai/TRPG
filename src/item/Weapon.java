package item;

public class Weapon {
	
	private int power;
	private int magicPower;
	private WeaponType type;
	private String name;
	
	public Weapon(int power, int magicPower, String name, WeaponType type) {
		
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

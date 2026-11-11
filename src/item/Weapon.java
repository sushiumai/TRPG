package item;

public class Weapon implements Item {
	
	private final int power;
	private final int magicPower;
	private final WeaponType type;
	private final String name;
	
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

	@Override
	public String getName() {
		return this.name;
	}
	public WeaponType getType() {
		return this.type;
	}

}

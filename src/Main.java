
import character.Hero;
import system.GrowthSystem;
public class Main {

	public static void main(String[] args) {
		
		Hero hero = new Hero();
		GrowthSystem.giveExp(hero, 100);
		System.out.println(hero.getHp());
		System.out.println(hero.getLevel());
		System.out.println(hero.getExp());
		
		/*MainScreen screen = new MainScreen();
		screen.setVisible(true);*/

	}

}

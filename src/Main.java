
import character.BlueSlime;
import character.Hero;
import system.BattleAction;
import system.GrowthSystem;
public class Main {

	public static void main(String[] args) {
		
		Hero hero = new Hero();
		GrowthSystem.giveExp(hero, 100);
		System.out.println(hero.getHp());
		System.out.println(hero.getLevel());
		System.out.println(hero.getExp());
		
		BlueSlime blueSlime = new BlueSlime();
		System.out.println(blueSlime.getName() + blueSlime.getMagicPower());
		
		BattleAction heroAction = new BattleAction(hero, blueSlime, "ハヤブサ斬り");
		System.out.println(heroAction.getTarget().getName());
		
		/*MainScreen screen = new MainScreen();
		screen.setVisible(true);*/

	}

}

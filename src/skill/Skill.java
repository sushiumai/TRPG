package skill;

public abstract class Skill {

	//変数の定義	
	private int magicStrength;
	private int mpCost;
	private int learnLevel;
	private String element;
	private String learnCharacter;	
	
	public Skill(int mpCost, int learnLevel, String element,  String learnCharacter) {
		
		this.mpCost = mpCost;
		this.learnLevel = learnLevel;
		this.element = element;
		this.learnCharacter = learnCharacter;
		
		
	}
	
	//ゲッターの定義
	public int getMagicStrength() {
		return this.magicStrength;
	}
	public int getMpCost() {
		return this.mpCost;
	}
	public int getlearnLevel() {
		return this.learnLevel;
	}
	public String getElement() {
		return this.element;
	}
	public String getLearnCharacter() {
		return this.learnCharacter;
	}
	
}

package skill;

public abstract class Skill {

	//変数の定義	
	protected String name;
	protected int mpCost;
	protected int learnLevel;
	
	public Skill(String name, int mpCost, int learnLevel) {
		
		this.name = name;
		this.mpCost = mpCost;
		this.learnLevel = learnLevel;
		
	}
	
	
	public int getMpCost() {
		return this.mpCost;
	}
	public int getlearnLevel() {
		return this.learnLevel;
	}
	public String getName() {
		return this.name;
	}

}

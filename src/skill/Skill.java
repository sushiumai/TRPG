package skill;

import data.Element;

public abstract class Skill {

	//変数の定義	
	protected int mpCost;
	protected int learnLevel;
	protected Element element;
	
	public Skill(int mpCost, int learnLevel) {
		
		this.mpCost = mpCost;
		this.learnLevel = learnLevel;
		
	}
	
	
	public int getMpCost() {
		return this.mpCost;
	}
	public int getlearnLevel() {
		return this.learnLevel;
	}

}

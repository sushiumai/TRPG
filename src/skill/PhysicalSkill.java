package skill;

import common.Element;

public class PhysicalSkill extends Skill {
	int count;
	double multiplier;
	Element element;

	public PhysicalSkill(String name, int mpCost, int learnLevel, int count, Element element, double multiplier, skill.TargetType targetType, common.Job... learnJobs) {

		super(name, mpCost, learnLevel, targetType, learnJobs);
		this.element = element;
		this.multiplier = multiplier;
		this.count = count;

	}
	//通常攻撃用
	public PhysicalSkill(String name, int mpCost, int count, Element element, double multiplier, skill.TargetType targetType){

		super(name, mpCost, targetType);
		this.element = element;
		this.multiplier = multiplier;
		this.count = count;
	}


	public double getMultiplier() {
		return this.multiplier;
	}

	public Element getElement() {
		return this.element;
	}
	public int getCount() {
		return this.count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	

}

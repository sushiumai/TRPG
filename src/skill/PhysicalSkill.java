package skill;

import data.Element;

public class PhysicalSkill extends Skill {
	int count;
	double multiplier;
	Element element;

	public PhysicalSkill(String name, int mpCost, int learnLevel, int count, Element element, double multiplier) {

		super(name, mpCost, learnLevel);
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

}

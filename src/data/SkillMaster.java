package data;

import skill.PhysicalSkill;

public class SkillMaster {

	//PhysicalSkill(String name, int mpCost, int learnLevel, int count, Element element, double multiplier)

	public static final PhysicalSkill NORMAL_ATTACK = new PhysicalSkill("こうげき", 0, 1, 1, Element.NONE, 1.0);
	public static final PhysicalSkill DOUBLE_SLASH = new PhysicalSkill("連続斬り", 4, 3, 2, Element.NONE, 0.7);
}

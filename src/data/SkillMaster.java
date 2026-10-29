package data;

import java.util.ArrayList;
import java.util.List;
import skill.PhysicalSkill;
import skill.Skill;
public class SkillMaster {
	private static final List<Skill> ALL_SKILLS = new ArrayList<>();

	//PhysicalSkill(String name, int mpCost, int learnLevel, int count, Element element, double multiplier)

	public static final PhysicalSkill NORMAL_ATTACK = register(new PhysicalSkill("こうげき", 0, 1, 1, Element.NONE, 1.0, data.Job.HERO, data.Job.THIEF, data.Job.MAGE, data.Job.PRIEST));
	public static final PhysicalSkill DOUBLE_SLASH = register(new PhysicalSkill("連続斬り", 4, 3, 2, Element.NONE, 0.7, data.Job.HERO));

	private static <T extends Skill> T register(T skill) {
		ALL_SKILLS.add(skill);
		return skill;
	}

	public static List<Skill> getSkillsToLearn(data.Job job, int level) {
		return ALL_SKILLS.stream()
				.filter(skill -> skill.getLearnLevel() == level)
				.filter(skill -> skill.canLearn(job, level))
				.toList();
	}
}

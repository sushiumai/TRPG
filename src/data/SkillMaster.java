package data;

import common.Element;
import common.Job;
import java.util.ArrayList;
import java.util.List;
import skill.GuardSkill;
import skill.PhysicalSkill;
import skill.Skill;

public class SkillMaster {
	private static final List<Skill> ALL_SKILLS = new ArrayList<>();

	//PhysicalSkill(String name, int mpCost, int learnLevel, int count, Element element, double multiplier)

	public static final PhysicalSkill NORMAL_ATTACK = new PhysicalSkill("通常攻撃", 0, 1, Element.NONE, 1.0, skill.TargetType.ENEMY);
	public static final PhysicalSkill DOUBLE_SLASH = register(new PhysicalSkill("連続斬り", 4, 3, 2, Element.NONE, 0.7, skill.TargetType.ENEMY, common.Job.HERO));

	public static final skill.GuardSkill GUARD = new GuardSkill("防御", 0, skill.TargetType.SELF);

	private static <T extends Skill> T register(T skill) {
		ALL_SKILLS.add(skill);
		return skill;
	}

	public static List<Skill> getSkillsToLearn(Job job, int level) {
		return ALL_SKILLS.stream()
				.filter(skill -> skill.getLearnLevel() == level)
				.filter(skill -> skill.canLearn(job, level))
				.toList();
	}
}

package system;

import skill.Skill;

import java.util.List;

public record LevelUpResult(
        boolean isLevelUp,
        int newLevel,
        List<Skill> learnedSkills
) {

}

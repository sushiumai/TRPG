package skill;

public class GuardSkill extends Skill {
    public GuardSkill(String name, int mpCost, int learnLevel, skill.TargetType targetType, common.Job... learnJobs) {
        super(name, mpCost, learnLevel, targetType, learnJobs);
    }

    public GuardSkill(String name, int mpCost, skill.TargetType targetType){
        super(name, mpCost, targetType);
    }

}

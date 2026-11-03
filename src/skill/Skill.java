package skill;
import data.Job;
import data.TargetType;
/**
 * Skill
 */
public abstract class Skill implements data.Named {

	//変数の定義	
	private final String name;
	private final int mpCost;
	private final int learnLevel;
	private java.util.List<Job> learnJobs;
	private final TargetType targetType;

	public Skill(String name, int mpCost, int learnLevel, TargetType targetType, Job... learnJobs) {
		
		this.name = name;
		this.mpCost = mpCost;
		this.learnLevel = learnLevel;
		this.targetType = targetType;
		this.learnJobs = new java.util.ArrayList<>();
		this.learnJobs = java.util.Arrays.asList(learnJobs);
		
		
	}
	
	
	public int getMpCost() {
		return this.mpCost;
	}
	public int getLearnLevel() {
		return this.learnLevel;
	}
        @Override
	public String getName() {
		return this.name;
	}
	public TargetType getTargetType() {
		return this.targetType;
	}

	public boolean canLearn(Job job, int level) {
		return this.learnLevel <= level && this.learnJobs.contains(job);
	}

}

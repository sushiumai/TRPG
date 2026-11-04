package skill;
import common.Job;

public abstract class Skill {

	//変数の定義	
	private final String  name;
	private int mpCost;
	private final int learnLevel;
	private java.util.List<Job> learnJobs;
	private TargetType targetType;

	public Skill(String name, int mpCost, int learnLevel, TargetType targetType, Job... learnJobs) {
		
		this.name = name;
		this.mpCost = mpCost;
		this.learnLevel = learnLevel;
		this.targetType = targetType;
		this.learnJobs = new java.util.ArrayList<>();
		this.learnJobs = java.util.Arrays.asList(learnJobs);
		
		
	}
	//通常攻撃、防御など用
	public Skill(String name, int mpCost, TargetType targetType){
		this.name = name;
		this.mpCost = mpCost;
		this.targetType = targetType;
		this.learnLevel = 1;
	}
	
	
	public int getMpCost() {
		return this.mpCost;
	}
	public int getLearnLevel() {
		return this.learnLevel;
	}
	public String getName() {
		return this.name;
	}
	public TargetType getTargetType() {
		return this.targetType;
	}
	public java.util.List<Job> getLearnJobs() {
		return this.learnJobs;
	}
	public void setMpCost(int mpCost) {
		this.mpCost = mpCost;
	}
	public void setTargetType(TargetType targetType) {
		this.targetType = targetType;
	}

	public boolean canLearn(Job job, int level) {
		return this.learnLevel <= level && this.learnJobs.contains(job);
	}

}

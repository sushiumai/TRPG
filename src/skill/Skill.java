package skill;
import data.Job;

public abstract class Skill {

	//変数の定義	
	protected String name;
	protected int mpCost;
	protected int learnLevel;
	protected java.util.List<Job> learnJobs;
	
	public Skill(String name, int mpCost, int learnLevel, Job... learnJobs) {
		
		this.name = name;
		this.mpCost = mpCost;
		this.learnLevel = learnLevel;
		this.learnJobs = new java.util.ArrayList<>();
		this.learnJobs = java.util.Arrays.asList(learnJobs);
		
		
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

	public boolean canLearn(Job job, int level) {
		return this.learnLevel <= level && this.learnJobs.contains(job);
	}

}

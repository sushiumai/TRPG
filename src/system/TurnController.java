package system;
import java.util.ArrayList;
import java.util.List;

public class TurnController {
	private final List<BattleAction> actionList;
	
	public TurnController() {
		this.actionList = new ArrayList<>();
	}
		
	public void addAction(BattleAction action) {
			this.actionList.add(action);
	}
	
	public void startTurn() {
		while (!actionList.isEmpty()) {
			this.actionList.sort((a1, a2) -> a2.getActor().getSpeed() - a1.getActor().getSpeed());
			BattleAction currentAction = actionList.remove(0);
			currentAction.execute();
		}
	}
	

}

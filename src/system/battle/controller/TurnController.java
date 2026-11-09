package system.battle.controller;
import java.util.ArrayList;
import java.util.List;
import character.Character;
import character.Enemy;
import character.Player;
import condition.StatusCondition;
import data.SkillMaster;
import system.battle.action.BattleAction;
import system.battle.action.PhysicalAction;

public class TurnController {
    private TurnController(){}

    public static void turnControl(List<Player> allies, List<Enemy> enemies){
        List<BattleAction> actionList = new ArrayList<>();
        allies.stream()
                .map(ally -> BattleCommandController.selectAction(ally, enemies, allies))
                .forEach(actionList::add);
        enemies.stream() //TODO 敵の動きはいったん固定している
                .map(enemy -> new PhysicalAction(enemy, SkillMaster.NORMAL_ATTACK, List.of(allies.getFirst())))
                .forEach(actionList::add);
        startTurn(actionList, allies, enemies);
    }

    private static void startTurn(List<BattleAction> actionList, List<Player> allies, List<Enemy> enemies) {
        while (!actionList.isEmpty() && (isPartyAlive(allies) && isPartyAlive(enemies))) {

            actionList.sort((a1, a2) -> Integer.compare(
                    a2.getActor().getSpeed(), a1.getActor().getSpeed()));
            BattleAction currentAction = actionList.removeFirst();

            Character actor = currentAction.getActor();
            if (actor.isDead()){continue;}
            boolean canAct = actor.processTurnStart();
            if (canAct) {
                currentAction.execute(enemies);
            }
        }
        for (Character ally : allies) {
            processTurnEnd(ally);
        }
    }
    protected static boolean isPartyAlive(List<? extends Character> party) {

        for (Character c : party) {
            if (c.isAlive()) {
                return true;
            }
        }
        return false;
    }
    public static void processTurnEnd(Character character){
        for (StatusCondition condition : character.getConditions()){
            int damage = condition.onTurnEnd(character);
            if (damage > 0){
                gui.MessageViewer.printf(data.MessageCatalog.CONDITION_DAMAGE, character.getName(), condition.getName(), damage);
                if (character.isDead()){
                    if (character instanceof Enemy){
                        gui.MessageViewer.printf(data.MessageCatalog.KILL_LOG, character.getName());
                    } else {
                        gui.MessageViewer.printf(data.MessageCatalog.SLAIN_LOG, character.getName());
                    }
                    break;
                }
            }
        }

        character.getConditions().removeIf(StatusCondition::isExpired);
    }
}




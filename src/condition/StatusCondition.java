package condition;
import character.Character;
public interface StatusCondition {
    String getName();
    void onTurnStart(Character c);
    void onTurnEnd(Character c);
    boolean isExpired();
    boolean canAct(Character c);
}

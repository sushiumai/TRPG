package condition;
import character.Character;
public class GuardCondition implements StatusCondition {

    private int duration = 1;

    @Override
    public String getName(){
        return "防御";
    }
    @Override
    public void onTurnStart(Character character){
        duration--;
    }
    @Override
    public void onTurnEnd(Character character){}//防御はターン終わり何もしない
    @Override
    public boolean isExpired(){
        return duration <= 0;
    }
    @Override
    public boolean canAct(Character character){
        return true;
    }
}

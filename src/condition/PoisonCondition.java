package condition;
import character.Character;
public class PoisonCondition implements StatusCondition{
    private int duration = 5;

    @Override
    public String getName(){
        return "どく";
    }

    @Override
    public void onTurnStart(Character character){}//ターンスタート時は何もしない
    @Override
    public int onTurnEnd(Character character){
        if (isExpired()){return 0;}
        int poisonDamage = (int)(character.getBaseStatus().maxHp() * 0.1);
        character.reduceHp(poisonDamage);
        duration--;
        return poisonDamage;
    }
    @Override
    public boolean isExpired(){
        return duration <= 0;
    }
    @Override
    public boolean canAct(Character character){
        return true;
    }

}

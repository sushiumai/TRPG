package item;

public class HealConsumable extends Consumable {

    private final int healAmount;

    public HealConsumable(String name, int buyPrice, int sellPrice, int healAmount) {
        super(name, buyPrice, sellPrice);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}

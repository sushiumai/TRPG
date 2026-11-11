package item;

import java.util.Map;

public class PlayerInventory {
    private final Map<Consumable, Integer> consumables = new java.util.HashMap<>();
    private final Map<Equipment, Integer> equipments = new java.util.HashMap<>();
}

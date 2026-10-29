package data;

public enum Job {
    NONE("無職"), HERO("勇者"), MAGE("魔法使い"), PRIEST("聖職者"), THIEF("盗賊");

    private final String name;

    Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

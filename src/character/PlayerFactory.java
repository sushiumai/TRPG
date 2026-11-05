package character;

import common.Job;

public class PlayerFactory {
    private PlayerFactory() {
    }

    public static Player createPlayer(Job job) {
        return new Player(job, 1, 0);
    }

}

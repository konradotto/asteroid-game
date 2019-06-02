package src.model;

import src.application.AsteroidsController;

public class Scrap extends AsteroidsSprite {

    private static final int SCRAP_COUNT  = 2 * AsteroidsController.getFps();  // Timer counter starting values

    private static int[] explosionCounter = new int[AsteroidsController.getMaxScrap()];  // Time counters for explosions.
    private static int   explosionIndex;                         // Next available explosion sprite.

    public Scrap() {

    }

    public static int getScrapCount() {
        return SCRAP_COUNT;
    }
}

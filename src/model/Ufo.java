package src.model;

import src.application.AsteroidsController;

public class Ufo extends AsteroidsSprite {

    private static final int UFO_PASSES = 3;          // Number of passes for flying saucer per appearance.

    // Probablility of flying saucer firing a missle during any given frame
    // (other conditions must be met).
    static final double MISSLE_PROBABILITY = 0.45 / AsteroidsController.getFps();

    private static int ufoPassesLeft;    // Counter for number of flying saucer passes.
    private static int ufoCounter;       // Timer counter used to track each flying saucer pass.

    public Ufo() {
        super();

        this.addPoint(-15, 0);
        this.addPoint(-10, -5);
        this.addPoint(-5, -5);
        this.addPoint(-5, -8);
        this.addPoint(5, -8);
        this.addPoint(5, -5);
        this.addPoint(10, -5);
        this.addPoint(15, 0);
        this.addPoint(10, 5);
        this.addPoint(-10, 5);
    }
}

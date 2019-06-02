package src.model;

import src.application.AsteroidsController;

public class Rock extends AsteroidsSprite {

    // constants
    private static final int    MIN_ROCK_SIDES =   6; // Ranges for asteroid shape, size
    private static final int    MAX_ROCK_SIDES =  16; // speed and rotation.
    private static final int    MIN_ROCK_SIZE  =  20;
    private static final int    MAX_ROCK_SIZE  =  40;
    private static final double MIN_ROCK_SPEED =  40.0 / AsteroidsController.getFps();
    private static final double MAX_ROCK_SPEED = 240.0 / AsteroidsController.getFps();
    private static final double MAX_ROCK_SPIN  = Math.PI / AsteroidsController.getFps();

    // Asteroid data.
    private static boolean[] asteroidIsSmall = new boolean[AsteroidsController.getMaxRocks()];    // Asteroid size flag.
    private static int       asteroidsCounter;                            // Break-time counter.
    private static double    asteroidsSpeed;                              // Asteroid speed.
    private static int       asteroidsLeft;                               // Number of active asteroids.

    public Rock() {
        super();

        asteroidsSpeed = MIN_ROCK_SPEED;
    }

    protected double getMinRockSpeed() {
        return MIN_ROCK_SPEED;
    }

    public static double getMaxRockSpeed() {
        return MAX_ROCK_SPEED;
    }
}

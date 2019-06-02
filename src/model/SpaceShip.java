package src.model;

import src.application.AsteroidsController;

public class SpaceShip extends AsteroidsSprite {

    private static final int MAX_SHIPS = 3;           // Starting number of ships for each game.

    // Ship's rotation and acceleration rates and maximum speed.
    private static final double SHIP_ANGLE_STEP = Math.PI / AsteroidsController.getFps();
    private static final double SHIP_SPEED_STEP = 15.0 / AsteroidsController.getFps();
    private static final double MAX_SHIP_SPEED  = 1.25 * Rock.getMaxRockSpeed();

    private static final int FIRE_DELAY = 50;         // Minimum number of milliseconds required between photon shots.
    private int shipsLeft;       // Number of ships left in game, including current one.
    private int shipCounter;     // Timer counter for ship explosion.

    private FwdThruster fwd;
    private RevThruster rev;

    private AsteroidsController controller;

    public SpaceShip(AsteroidsController controller) {
        super();
        this.addPoint(0, -10);
        this.addPoint(7, 10);
        this.addPoint(-7, 10);

        fwd = new FwdThruster();
        rev = new RevThruster();
    }

    public void init() {
        // Reset the ship sprite at the center of the screen.
        setActive(true);
        setAngle(0.0);
        setDeltaAngle(0.0);
        setX(0.0);
        setY(0.0);
        setDeltaX(0.0);
        setDeltaY(0.0);
        render();

        shipsLeft = MAX_SHIPS;

        // reset fwd and rev
        fwd.init(this);
        rev.init(this);

        if (controller.isLoaded()) {
            Sounds.stopClip(SoundEnum.THRUSTERS);
        }

        Sounds.setThrustersPlaying(false);
        controller.setHyperCounter(0);
    }

    public void stop() {
        setActive(false);
        shipCounter = Scrap.getScrapCount();
        if (shipsLeft > 0)
            shipsLeft--;
        if (controller.isLoaded()) {
            Sounds.stopClip(SoundEnum.THRUSTERS);
        }
        Sounds.setThrustersPlaying(false);
    }

    public static int getMaxShips() {
        return MAX_SHIPS;
    }
}

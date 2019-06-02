package src.model;

public class SpaceShip extends AsteroidsSprite {

    public SpaceShip() {
        super();
        this.addPoint(0, -10);
        this.addPoint(7, 10);
        this.addPoint(-7, 10);
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
    }
}

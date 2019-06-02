package src.model;

public class Missile extends AsteroidsSprite {

    // Missle data.
    private static int missleCounter;    // Counter for life of missle.

    public Missile() {
        super();

        this.addPoint(0, -4);
        this.addPoint(1, -3);
        this.addPoint(1, 3);
        this.addPoint(2, 4);
        this.addPoint(-2, 4);
        this.addPoint(-1, 3);
        this.addPoint(-1, -3);
    }
}

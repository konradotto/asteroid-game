package src.model;

public class Missile extends AsteroidsSprite {

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

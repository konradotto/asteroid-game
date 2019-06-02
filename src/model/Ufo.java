package src.model;

public class Ufo extends AsteroidsSprite {

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

package src.model;

public class Photon extends AsteroidsSprite {

    public Photon() {
        super();

        this.addPoint(1, 1);
        this.addPoint(1, -1);
        this.addPoint(-1, 1);
        this.addPoint(-1, -1);
    }
}

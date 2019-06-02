package src.model;

public class Photon extends AsteroidsSprite {

    private static int photonIndex;    // Index to next available photon sprite.
    private static long  photonTime;     // Time value used to keep firing rate constant.

    public Photon() {
        super();

        this.addPoint(1, 1);
        this.addPoint(1, -1);
        this.addPoint(-1, 1);
        this.addPoint(-1, -1);
    }
}

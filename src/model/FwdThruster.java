package src.model;

public class FwdThruster extends AsteroidsSprite {

    public FwdThruster() {
        super();

        this.addPoint(0, 12);
        this.addPoint(-3, 16);
        this.addPoint(0, 26);
        this.addPoint(3, 16);
    }

    protected void init(SpaceShip ship) {
        this.x = ship.x;
        this.y = ship.y;
        this.angle = ship.angle;
        render();
    }
}

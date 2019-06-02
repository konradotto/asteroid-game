package src.model;

public class RevThruster extends AsteroidsSprite {

    public RevThruster() {
        super();

        this.addPoint(-2, 12);
        this.addPoint(-4, 14);
        this.addPoint(-2, 20);
        this.addPoint(0, 14);
        this.addPoint(2, 12);
        this.addPoint(4, 14);
        this.addPoint(2, 20);
        this.addPoint(0, 14);
    }

    public void init(SpaceShip ship) {
        this.x = ship.x;
        this.y = ship.y;
        this.angle = ship.angle;
        render();
    }
}

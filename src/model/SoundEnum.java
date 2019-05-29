package src.model;

public enum SoundEnum {
    CRASH("sounds/crash.wav"),
    EXPLOSION("sounds/explosion.wav"),
    FIRE("sounds/fire.wav"),
    MISSILE("sounds/missle.wav"),
    SAUCER("sounds/saucer.wav"),
    THRUSTERS("sounds/thrusters.wav"),
    WARP("sounds/warp.wav");

    private String path;

    SoundEnum(String s) {
        path = s;
    }

    public String getPath() {
        return this.path;
    }
}

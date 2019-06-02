package src.application;

import src.model.*;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.PrintStream;
import javax.swing.*;

public class AsteroidsController extends JPanel implements Runnable, KeyListener {

    // Copyright information.
    private static final String copyName = "Asteroids";
    private static final String copyVers = "Version 1.3";
    private static final String copyInfo = "Copyright 1998-2001 by Mike Hall";
    private static final String copyLink = "http://www.brainjar.com";
    private static final String copyText = copyName + '\n' + copyVers + '\n'
            + copyInfo + '\n' + copyLink;


    // Thread control variables.
    private Thread loadThread;
    private Thread loopThread;

    // Constants
    private static final int DELAY = 20;             // Milliseconds between screen and
    private static final int FPS = Math.round(1000 / DELAY); // resulting frame rate

    // Flags for game state and options.
    private boolean loaded = false;
    private boolean paused;
    private boolean playing;
    private boolean sound;
    private boolean detail;

    // Number of points the must be scored to earn a new ship or to cause the
    // flying saucer to appear.
    private static final int NEW_SHIP_POINTS = 5000;
    private static final int NEW_UFO_POINTS  = 2750;

    // Background stars.
    private int     numStars;
    private Point[] stars;

    // Game data.
    private int score;
    private int highScore;
    private int newShipScore;
    private int newUfoScore;

    // Key flags.
    private boolean left  = false;
    private boolean right = false;
    private boolean up    = false;
    private boolean down  = false;



    static final int MAX_SHOTS =  8;          // Maximum number of sprites
    static final int MAX_ROCKS =  8;          // for photons, asteroids and
    static final int MAX_SCRAP = 40;          // explosions.

    // Sprite objects.
    private SpaceShip ship;
    private Ufo ufo;
    private Missile missle;
    private Photon[] photons    = new Photon[MAX_SHOTS];
    private AsteroidsSprite[] asteroids  = new AsteroidsSprite[MAX_ROCKS];
    private AsteroidsSprite[] explosions = new AsteroidsSprite[MAX_SCRAP];

    // Ship data.
    private int hyperCounter;    // Timer counter for hyperspace.

    // Off screen image.
    private Dimension offDimension;
    private Image     offImage;
    private Graphics  offGraphics;

    // Data for the screen font.
    private Font font      = new Font("Helvetica", Font.BOLD, 12);
    private FontMetrics fm = getFontMetrics(font);
    private int fontWidth  = fm.getMaxAdvance();
    private int fontHeight = fm.getHeight();

    private static PrintStream out = System.out;


    public AsteroidsController() {
        init();
    }

    public void init() {
        Dimension d = getSize();
        int i;

        // Display copyright information.
        out.println(copyText);

        // Set up key event handling and set focus to applet window.
        addKeyListener(this);
        setFocusable(true);

        // Save the screen size.
        AsteroidsSprite.setWidth(d.width);
        AsteroidsSprite.setHeight(d.height);

        // Generate the starry background.
        numStars = AsteroidsSprite.getWidth() * AsteroidsSprite.getHeight() / 5000;
        stars = new Point[numStars];
        for (i = 0; i < numStars; i++)
            stars[i] = new Point((int) (Math.random() * AsteroidsSprite.getWidth()), (int) (Math.random() * AsteroidsSprite.getHeight()));

        // Create shape for the ship sprite.
        ship = new SpaceShip(this);

        // Create shape for each photon sprites.
        for (i = 0; i < MAX_SHOTS; i++) {
            photons[i] = new Photon();
        }

        // Create shape for the flying saucer.
        ufo = new Ufo();

        // Create shape for the guided missile.
        missle = new Missile();

        // Create asteroid sprites.
        for (i = 0; i < MAX_ROCKS; i++)
            asteroids[i] = new AsteroidsSprite();

        // Create explosion sprites.

        for (i = 0; i < MAX_SCRAP; i++)
            explosions[i] = new AsteroidsSprite();

        // Initialize game data and put us in 'game over' mode.

        highScore = 0;
        sound = true;
        detail = true;
        initGame();
        endGame();
    }

    public void run() {

    }

    public void initGame() {

        // Initialize game data and sprites.

        score = 0;
        newShipScore = NEW_SHIP_POINTS;
        newUfoScore = NEW_UFO_POINTS;
        ship.init();
        initPhotons();
        stopUfo();
        stopMissle();
        initAsteroids();
        initExplosions();
        playing = true;
        paused = false;
        photonTime = System.currentTimeMillis();
    }

    public void endGame() {

        // Stop ship, flying saucer, guided missle and associated sounds.
        playing = false;
        ship.stop();
        ufo.stop();
        missle.stop();
        stopShip();
        stopUfo();
        stopMissle();
    }

    public void initPhotons() {

        int i;

        for (i = 0; i < MAX_SHOTS; i++)
            photons[i].active = false;
        photonIndex = 0;
    }

    public static String getAppletInfo() {
        // Return copyright information.
        return(copyText);
    }

    public static int getFps() {
        return FPS;
    }

    public static int getMaxRocks() {
        return MAX_ROCKS;
    }

    public static int getMaxScrap() {
        return MAX_SCRAP;
    }

    public int getHyperCounter() {
        return hyperCounter;
    }

    public void setHyperCounter(int hyperCounter) {
        this.hyperCounter = hyperCounter;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }


}

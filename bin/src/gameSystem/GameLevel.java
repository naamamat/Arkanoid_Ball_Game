// 322316506 Naama Matzliach
package gameSystem;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometryPrimitives.Point;
import geometryPrimitives.Rectangle;
import gui.Collidable;
import gui.Sprite;
import levels.LevelInformation;

import java.awt.Color;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * The class GameLevel.
 * Make a game.
 * @author Naama Matzliach
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private boolean running;
    private LevelInformation levelInformation;
    private int gameWidth;
    private int gameHeight;

    private static final int COLLIDABLE_HEIGHT = 20;
    private static final int BORDER_SIZE = 25;
    private static final int BALL_RADIUS = 5;
    private static final Color PADDLE_COLOR = Color.YELLOW;
    private static final int POINTS_PER_LEVEL = 100;
    private static final int INDICATOR_SIZE = 15;
    private static final double SECONDS_COUNTDOWN = 2;
    private static final int COUNTDOWN_FROM = 3;

    /**
     * Constructor, creates a game level.
     * @param levelInformation The level information.
     * @param keyboard The keyboard.
     * @param runner The animation runner.
     * @param score The current score.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public GameLevel(LevelInformation levelInformation,
                     KeyboardSensor keyboard,
                     AnimationRunner runner,
                     Counter score,
                     int gameWidth,
                     int gameHeight) {
        this.levelInformation = levelInformation;
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        this.keyboard = keyboard;
        this.runner = runner;
        running = false;
        this.score = score;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        remainingBlocks = new Counter(levelInformation.numberOfBlocksToRemove());
        remainingBalls = new Counter(levelInformation.numberOfBalls());
    }

    /** The function add collidable.
     * add collidable to the game.
     * @param c collidable.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /** The function remove collidable.
     * Remove collidable to the game.
     * @param c collidable.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }
    /** The function add sprite.
     * add sprite to the game.
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /** The function removes sprite.
     * Remove sprite to the game.
     * @param s sprite.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /** The function initialize.
     * Initialize a new game: create the Blocks and gameSystem.Ball (and gameSystem.Paddle).
     * and add them to the game.
     */
    public void initialize() {
        sprites.addSprite(levelInformation.getBackground());
        addScoreIndicator();
        addLevelNameIndicator();
        addBorders();
        addBlocks();
    }

    /** The function add blocks.
     * Add blocks to the game.
     */
    private void addBlocks() {
        List<Color> colors = new ArrayList<Color>();
        Collections.addAll(colors, Color.GRAY, Color.RED, Color.YELLOW, Color.CYAN, Color.PINK, Color.GREEN);

        BlockRemover blockRemover = new BlockRemover(this, remainingBlocks);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);

        for (Block block : levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
        }
    }

    private void addScoreIndicator() {
        Point p = new Point(0, 0);
        Rectangle rect = new Rectangle(p, gameWidth, INDICATOR_SIZE);
        ScoreIndicator scoreIndicator = new ScoreIndicator(score, rect);
        scoreIndicator.addToGame(this);
    }

    private void addLevelNameIndicator() {
        Point p = new Point(0, 0);
        Rectangle rect = new Rectangle(p, gameWidth, INDICATOR_SIZE);
        LevelNameIndicator levelNameIndicator = new LevelNameIndicator(levelInformation.levelName(), rect);
        levelNameIndicator.addToGame(this);
    }

    /** The function add balls.
     * Add balls to the game on top of paddle.
     */
    private void addBallsOnTopOfPaddle() {
        Point paddlePoint = new Point(gameWidth / 2 - (levelInformation.paddleWidth() / 2),
                gameHeight  - COLLIDABLE_HEIGHT - 10);
        Rectangle rect = new Rectangle(paddlePoint, levelInformation.paddleWidth(), COLLIDABLE_HEIGHT);
        Paddle paddle = new Paddle(
                rect,
                PADDLE_COLOR,
                keyboard,
                BORDER_SIZE,
                gameWidth - BORDER_SIZE,
                levelInformation.paddleSpeed());
        paddle.addToGame(this);

        for (Velocity ballVelocity : levelInformation.initialBallVelocities()) {
            double ballX = paddlePoint.getX() + (levelInformation.paddleWidth() / 2);
            double ballY = paddlePoint.getY() - (BALL_RADIUS * 2);
            Ball ball = new Ball(ballX, ballY, BALL_RADIUS, Color.WHITE, environment);
            ball.setVelocity(ballVelocity);
            ball.addToGame(this);
        }
    }

    /** The function add borders.
     * Add borders to the game.
     */
    private void addBorders() {
        Block upBorder = new Block(new Rectangle(new Point(0, INDICATOR_SIZE), gameWidth, BORDER_SIZE));
        upBorder.addToGame(this);

        Block leftBorder = new Block(new Rectangle(new Point(0,
                BORDER_SIZE + INDICATOR_SIZE), BORDER_SIZE,
                gameHeight - BORDER_SIZE - INDICATOR_SIZE));
        leftBorder.addToGame(this);

        Point p1 = new Point(gameWidth - BORDER_SIZE, BORDER_SIZE + INDICATOR_SIZE);
        Block rightBorder = new Block(new Rectangle(p1, BORDER_SIZE, gameHeight - BORDER_SIZE - INDICATOR_SIZE));
        rightBorder.addToGame(this);
        Point p2 = new Point(BORDER_SIZE, gameHeight);
        Block downBorder = new Block(new Rectangle(p2, gameWidth - 2 * BORDER_SIZE, 0));
        downBorder.addToGame(this);

        BallRemover ballRemover = new BallRemover(this, remainingBalls);
        downBorder.addHitListener(ballRemover);
    }

    /**
     * Get the number of balls remaining.
     * @return remaining balls.
     */
    public int getRemainingBalls() {
        return remainingBalls.getValue();
    }

    /** The function run.
     * Run the game, start the animation loop.
     */
    public void run() {
        addBallsOnTopOfPaddle();

        // AnimationRunner is responsible for the milliseconds per frame amount,
        // so it'd better pass that value when creating CountdownAnimation to run,
        // instead of passing it to doOneFrame and distract all other Animations.
        this.runner.run(new CountdownAnimation(
                SECONDS_COUNTDOWN,
                COUNTDOWN_FROM,
                sprites,
                runner.getMillisecondsPerOneFrame()));

        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (remainingBlocks.getValue() == 0) {
            score.increase(POINTS_PER_LEVEL);
            running = false;
        } else if (remainingBalls.getValue() == 0) {
            running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
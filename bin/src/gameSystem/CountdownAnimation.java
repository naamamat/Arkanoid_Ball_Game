// 322316506 Naama Matzliach
package gameSystem;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class CountdownAnimation.
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 * @author Naama Matzliach
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private double numOfSecondsPassed;
    private int countFrom;
    private SpriteCollection gameScreen;
    private int millisecondsPerFrame;
    private int framesCounter;
    private static final int MILLISECONDS_IN_SECONDS = 1000;

    /**
     * Constructor.
     * @param numOfSeconds The number of seconds to wait.
     * @param countFrom The number to show on the screen.
     * @param gameScreen The game screen.
     * @param millisecondsPerFrame The number of milliseconds in one frame.
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen,
                              int millisecondsPerFrame) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.millisecondsPerFrame = millisecondsPerFrame;
        this.framesCounter = 0;
        this.numOfSecondsPassed = 0;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        framesCounter += 1;
        numOfSecondsPassed = (double) (framesCounter * millisecondsPerFrame) / (double) MILLISECONDS_IN_SECONDS;

        this.gameScreen.drawAllOn(d);
        int countPassed = (int) (numOfSecondsPassed / (double) (numOfSeconds / countFrom));
        int countToShow = countFrom - countPassed;
        d.setColor(Color.BLACK);
        d.drawText(
                35,
                35,
                "Countdown: " + countToShow,
                25);

    }

    @Override
    public boolean shouldStop() {
        if (numOfSecondsPassed >= numOfSeconds) {
            return true;
        }
        return false;
    }
}
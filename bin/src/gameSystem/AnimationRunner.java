// 322316506 Naama Matzliach
package gameSystem;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The class AnimationRunner.
 * Run the animations on the screen.
 * @author Naama Matzliach
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * Constructor, creates AnimationRunner.
     * @param gui The gui.
     * @param framesPerSecond The number of frames per second.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new Sleeper();
    }

    /**
     * returns number of milliseconds per one frame.
     * @return milliseconds of frame.
     */
    public int getMillisecondsPerOneFrame() {
        return 1000 / framesPerSecond;
    }

    /**
     * Run the animation until should stop.
     * @param animation The Animation to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = getMillisecondsPerOneFrame();
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing

            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}

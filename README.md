# Arkanoid Ball Game

This is a classic Arkanoid ball game implemented in Java, applying Object-Oriented Programming (OOP) concepts. The game consists of four levels, each progressively more challenging than the previous one.

## Game Levels

[Watch Video](./bin/pictures/video_game.mp4)


1. **Level 1** (Direct Hit):
    - Features 1 ball.
    - A basic level designed for new players to get familiar with the game.
    - ![Level 1 Image](./bin/pictures/step1.png)


2. **Level 2** (Wide Easy):
    - Features 10 balls.
    - A step up from Level 1, introducing more challenge while remaining accessible.
    - ![Level 2 Image](./bin/pictures/step2.png)

3. **Level 3** (Green 3):
    - Features 2 balls.
    - Offers a balanced challenge, testing the player's reflexes and strategy.
    - ![Level 3 Image](./bin/pictures/step3.png)

4. **Level 4** (Final Four):
    - Features 3 balls.
    - The hardest level, requiring both skill and quick reflexes to win.
    - ![Level 4 Image](./bin/pictures/step4.png)

## How to Compile

To compile the project, navigate to the `bin` directory of Apache Ant:

```bash
.\ant
```


## How to Run


To run full - game, use the following command from the same bin directory:

```bash
ant run
```

### Running Specific Levels
If you'd like to run a specific level, use the -Dargs option with the level number (1-4):

```bash
.\ant run -Dargs="1"
```


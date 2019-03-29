package sample;

import javafx.scene.paint.Color;

class GameMechanism {

    private Snake snake;
    private Apple apple;
    private GameWindow gameWindow;

    GameMechanism(GameWindow gameWindow) {
        this.snake = gameWindow.snake;
        this.apple = gameWindow.apple;
        this.gameWindow = gameWindow;
    }

    void eatApple() {
        if ((snake.head.positionX == apple.positionX) && (snake.head.positionY == apple.positionY)) {
            Block newBlock = new Block(snake.previous.positionX + 1, snake.previous.positionY, snake.previous, gameWindow, false, Color.GREEN);
            snake.snakeBlocks.add(newBlock);
            gameWindow.addBlocks(newBlock);
            snake.previous = newBlock;
            apple.newPosition(gameWindow);
        }
    }

    boolean goingThroughYourself() {
        for (Block block : snake.snakeBlocks) {

            if ((snake.head.positionX == block.positionX) && (snake.head.positionY == block.positionY)) {
                if (block.ishead) {continue;}
                System.out.println("GAME OVER");
                return true;
            }
        }
        return false;
    }
}

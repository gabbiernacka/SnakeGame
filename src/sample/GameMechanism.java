package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

class GameMechanism {

    private Scene scene;
    private GameWindow gameWindow;
    private MenuWindow menuWindow;
    private Snake snake;

    GameMechanism(Scene scene, GameWindow gameWindow, MenuWindow menuWindow) {
        this.scene = scene;
        this.gameWindow = gameWindow;
        this.menuWindow = menuWindow;
        this.snake = gameWindow.snake;
    }

    EventHandler<ActionEvent> startGame() {

        return actionEvent -> {
            scene.setOnKeyPressed(e -> {

                if (e.getCode().equals(KeyCode.W)) {
                    if (snake.getDirection() != Block.DOWN)
                        snake.setDirection(Block.UP);
                }
                if (e.getCode().equals(KeyCode.S)) {
                    if (snake.getDirection() != Block.UP)
                        snake.setDirection(Block.DOWN);
                }
                if (e.getCode().equals(KeyCode.A)) {
                    if (snake.getDirection() != Block.RIGHT)
                        snake.setDirection(Block.LEFT);
                }
                if (e.getCode().equals(KeyCode.D)) {
                    if (snake.getDirection() != Block.LEFT)
                        snake.setDirection(Block.RIGHT);
                }
            });

            gameWindow.addSnake();
            gameWindow.addApple();


            AnimationTimer animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    try {
                        Thread.sleep(100);
                        if (!Block.endGame) {
                            gameWindow.updateWindow();
                            eatApple();
                            if(goingThroughYourself()) {Block.endGame = true;}
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            animationTimer.start();
        };
    }

    private boolean goingThroughYourself() {
        for (Block block : snake.snakeBlocks) {

            if ((snake.head.positionX == block.positionX) && (snake.head.positionY == block.positionY)) {
                if (block.ishead) {continue;}
                System.out.println("GAME OVER");
                return true;
            }
        }
        return false;
    }

    private void eatApple() {
        if ((snake.head.positionX == gameWindow.apple.positionX) && (snake.head.positionY == gameWindow.apple.positionY)) {
            Block newBlock = new Block(snake.previous.positionX + 1, snake.previous.positionY, snake.previous, gameWindow, false, Color.GREEN);
            snake.snakeBlocks.add(newBlock);
            gameWindow.addBlocks(newBlock);
            snake.previous = newBlock;
            menuWindow.score.setText(Integer.toString((snake.snakeLength() - 5) * 10));
            gameWindow.apple.newPosition(gameWindow);
        }
    }
}

package sample;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

class GameWindow extends Pane {

    static int blockSize = 10;
    private int width;
    private int height;
    Snake snake;
    Apple apple;

    GameWindow(int w, int h) {
        width = w;
        height = h;

        setMinSize(width*blockSize, height*blockSize);
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        snake = new Snake(5, this);
    }

    void updateWindow() {
        for (Block block: snake.snakeBlocks) {
            block.move();
        }
    }

    void addSnake() {
        for (Block block : snake.snakeBlocks) {
            addBlocks(block);
        }
    }

    void addApple() {
        this.apple = new Apple(Color.RED, this);
        getChildren().add(apple);
    }

    void addBlocks(Block block) {
        getChildren().add(block);
    }

    int getWidthGameWindow() {
        return width;
    }

    int getHeightGameWindow() {
        return height;
    }
}

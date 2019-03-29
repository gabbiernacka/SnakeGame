package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;

class Snake {
    ArrayList<Block> snakeBlocks = new ArrayList<>();

    Block head;
    Block previous;

    Snake(int initialSize, GameWindow gameWindow) {

        int initialPositionX = gameWindow.getWidthGameWindow() / 2;
        int initialPositionY = gameWindow.getHeightGameWindow() / 2;

        head = new Block(initialPositionX, initialPositionY, null, gameWindow, true, Color.LIGHTGREEN);
        snakeBlocks.add(head);

        previous = head;

        for (int i = 1; i < initialSize; i++) {
            Block block = new Block(initialPositionX + i, initialPositionY, previous, gameWindow, false, Color.GREEN);
            snakeBlocks.add(block);
            previous = block;
        }
    }

    void setDirection(int dir) {
        Block.direction = dir;
    }

    int getDirection() {
        return Block.direction;
    }

    int snakeLength() {
        return snakeBlocks.size();
    }
}


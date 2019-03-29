package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Block extends Rectangle {
    int positionX, positionY;
    private int oldPositionX, oldPositionY;
    static final int UP = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static final int RIGHT = 4;

    static boolean endGame = false;
    boolean ishead = false;

    static int direction = LEFT;
    private int maxWidth, maxHeight;

    private Block previousBlock;

    Block(Color color, GameWindow gameWindow) {
        super(GameWindow.blockSize, GameWindow.blockSize, color);
        positionX = (int) (Math.random() * (gameWindow.getWidthGameWindow()-1) + 1);
        positionY = (int) (Math.random() * (gameWindow.getHeightGameWindow()-1) + 1);

        setTranslateX(positionX * GameWindow.blockSize);
        setTranslateY(positionY * GameWindow.blockSize);
    }

    Block(int x, int y, Block previous, GameWindow gameWindow, boolean ishead, Color color) {
        super(GameWindow.blockSize, GameWindow.blockSize, color);
        positionX = x;
        positionY = y;
        this.ishead = ishead;

        setVisible(true);
        setTranslateX(positionX * GameWindow.blockSize);
        setTranslateY(positionY * GameWindow.blockSize);
        previousBlock = previous;
        maxWidth = gameWindow.getWidthGameWindow();
        maxHeight = gameWindow.getHeightGameWindow();

    }

    void move() {
        oldPositionX = positionX;
        oldPositionY = positionY;

        if (previousBlock == null) {
            switch (direction) {
                case UP:
                    moveUp();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case LEFT:
                    moveLeft();
                    break;
                case RIGHT:
                    moveRight();
                    break;
            }
        } else {
            positionX = previousBlock.oldPositionX;
            positionY = previousBlock.oldPositionY;
        }
        updatePosition();
    }

    private void moveRight() {
        positionX++;
        if (positionX == maxWidth-1) {
            System.out.println("GAME OVER");
            endGame = true;
        }
    }

    private void moveLeft() {
        positionX--;

        if (positionX == 0) {
            System.out.println("GAME OVER");
            endGame = true;
        }
    }

    private void moveDown() {
        positionY++;
        if (positionY == maxHeight-1) {
            System.out.println("GAME OVER");
            endGame = true;
        }
    }

    private void moveUp() {
        positionY--;
        if (positionY == 0) {
            System.out.println("GAME OVER");
            endGame = true;
        }
    }

    private void updatePosition() {
        setTranslateX(positionX * GameWindow.blockSize);
        setTranslateY(positionY * GameWindow.blockSize);
    }
}

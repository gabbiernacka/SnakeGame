package sample;

import javafx.scene.paint.Color;

class Apple extends Block {

    Apple(Color color, GameWindow gameWindow) {
        super(color, gameWindow);
    }

    void newPosition(GameWindow gameWindow) {
        positionX = (int) (Math.random() * (gameWindow.getWidthGameWindow()-1));
        positionY = (int) (Math.random() * (gameWindow.getHeightGameWindow()-1));

        setTranslateX(positionX * GameWindow.blockSize);
        setTranslateY(positionY * GameWindow.blockSize);
    }
}

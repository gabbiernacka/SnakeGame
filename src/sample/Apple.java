package sample;

import javafx.scene.paint.Color;

public class Apple extends Block {

    public Apple(Color color, GameWindow gameWindow) {
        super(color, gameWindow);
    }

    public void newPosition(GameWindow gameWindow) {
        positionX = (int) (Math.random() * (gameWindow.getWidthGameWindow()-1) + 1);
        positionY = (int) (Math.random() * (gameWindow.getHeightGameWindow()-1) + 1);

        setTranslateX(positionX * GameWindow.blockSize);
        setTranslateY(positionY * GameWindow.blockSize);
    }
}

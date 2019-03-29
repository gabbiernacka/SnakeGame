package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

class MenuWindow extends HBox {

    Button startGame = new Button("Start new game");
    Label score = new Label();

    MenuWindow(int width, int height) {

        setMinSize(width, height);
        setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
        setAlignment(Pos.CENTER);
    }

    void addButton() {
        getChildren().add(startGame);
    }

    void addTextPanel() {
        score.setText("0");
        getChildren().add(score);
    }

    void addScoreLabel() {
        Label scoreLabel = new Label("Score:   ");
        scoreLabel.setMinSize(300,30);
        scoreLabel.setAlignment(Pos.CENTER_RIGHT);
        scoreLabel.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
        getChildren().add(scoreLabel);
    }
}

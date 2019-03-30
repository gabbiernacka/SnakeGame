package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane mainPane = new GridPane();
        mainPane. setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
        mainPane.setHgap(10);
        mainPane.setVgap(10);
        mainPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainPane, 800, 600, Color.DARKGRAY);

        GameWindow fieldGame = new GameWindow(78, 50);
        mainPane.add(fieldGame, 0, 1);

        MenuWindow menuWindow = new MenuWindow(780, 65);
        menuWindow.addButton();
        menuWindow.addScoreLabel();
        menuWindow.addTextPanel();
        mainPane.add(menuWindow, 0, 0);

        menuWindow.startGame.setOnAction((new GameMechanism(scene,fieldGame,menuWindow)).startGame());

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

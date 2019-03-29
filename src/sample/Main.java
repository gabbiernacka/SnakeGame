package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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
        Scene scene = new Scene(mainPane, 800, 600, Color.DARKGRAY);
        mainPane.setHgap(10);
        mainPane.setVgap(10);
        mainPane.setAlignment(Pos.CENTER);

        GameWindow fieldGame = new GameWindow(78, 50);
        mainPane.add(fieldGame, 0, 1);

        MenuWindow menuWindow = new MenuWindow(780, 65);
        mainPane.add(menuWindow, 0, 0);
        menuWindow.addButton();
        menuWindow.addScoreLabel();
        menuWindow.addTextPanel();
        menuWindow.startGame.setOnAction((event) -> {

            scene.setOnKeyPressed(e -> {

                if (e.getCode().equals(KeyCode.W)) {
                    if (fieldGame.snake.getDirection() != Block.DOWN)
                        fieldGame.snake.setDirection(Block.UP);
                }
                if (e.getCode().equals(KeyCode.S)) {
                    if (fieldGame.snake.getDirection() != Block.UP)
                        fieldGame.snake.setDirection(Block.DOWN);
                }
                if (e.getCode().equals(KeyCode.A)) {
                    if (fieldGame.snake.getDirection() != Block.RIGHT)
                        fieldGame.snake.setDirection(Block.LEFT);
                }
                if (e.getCode().equals(KeyCode.D)) {
                    if (fieldGame.snake.getDirection() != Block.LEFT)
                        fieldGame.snake.setDirection(Block.RIGHT);
                }
            });

            fieldGame.addSnake();
            fieldGame.addApple();

            GameMechanism gameMechanism = new GameMechanism(fieldGame);

            AnimationTimer animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    try {
                        Thread.sleep(100);
                        if (!Block.endGame) {
                            fieldGame.updateWindow();
                            gameMechanism.eatApple();
                            if(gameMechanism.goingThroughYourself()) {Block.endGame = true;}
                            menuWindow.score.setText(Integer.toString((fieldGame.snake.snakeLength() - 5) * 10));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            animationTimer.start();

        });

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

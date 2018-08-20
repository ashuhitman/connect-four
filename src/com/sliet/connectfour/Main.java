package com.sliet.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootPane = loader.load();

        //get first Pane
        Pane pane = (Pane) rootPane.getChildren().get(0);
        MenuBar menuBar = createMenu();
        //set menuBar width same as primary stage
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        //add MenuBar inside first Pane container
        pane.getChildren().add(menuBar);
        controller = loader.getController();
        controller.createPlayGround();
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        //file menu
        Menu fileMenu = new Menu("File");

        //new menu item
        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> resetGame());
        //new menu item
        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(event -> resetGame());
        //separator
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        //new menu item
        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);


        //help menu
        Menu helpMenu = new Menu("Help");
        //about Game
        MenuItem aboutGame = new MenuItem("About Game");
        aboutGame.setOnAction(event -> aboutGame());
        //separator
        SeparatorMenuItem separator = new SeparatorMenuItem();
        //about me
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());
        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);

        //MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;


    }

    private void resetGame() {
      controller.resetGame();
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Ashutosh Singh");
        alert.setContentText("I love coding and playing games. and this game is one of my childhood favourite");
        alert.show();

    }

    private void aboutGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect 4");
        alert.setHeaderText("How to Play ?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

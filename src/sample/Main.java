package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.scene.layout.VBox.setMargin;

public class Main extends Application {

    public void start(Stage primaryStage) {

        // Label, button, and pane creation.
        Label label = new Label("Search Benchmarker");
        label.setAlignment(Pos.CENTER);

        // Button with event handler.
        Button button = new Button("Sequential");
        Button button2 = new Button("Binary");
        Button button3 = new Button("Exit");

        button.setOnAction(
                event ->
                {
                    int[] numbers = {536, 289, 296, 429, 319, 142, 394,
                            101, 388, 147, 417, 199, 207, 222,
                            189, 310, 447, 521, 234, 600};

                    int result = SeqSearchBenchmarker.Searcher(numbers, 536);

                    label.setText("Sequential search result: " + result);

                });

        button2.setOnAction(
                event ->
                {
                    int[] numbers = {536, 289, 296, 429, 319, 142, 394,
                            101, 388, 147, 417, 199, 207, 222,
                            189, 310, 447, 521, 234, 600};

                    int result = SeqSearchBenchmarker.Searcher(numbers, 600);

                    label.setText("Binary search result: " + result);

                });

        button3.setOnAction(
                event ->
                        System.exit(0));

        // Sets the margins for a VBox pane on the label and button.
        Insets insets = new Insets(70);
        setMargin(label, insets);
        setMargin(button, insets);
        setMargin(button2, insets);
        setMargin(button3, insets);

        VBox pane = new VBox(10); // Creates a VBox with default spacing and allignment.
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(label); // Adds the label and button to the children of the pane.

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(button, button2, button3);

        var rootMenu = new HBox();

        var menuBar = new MenuBar();

        var fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);

        var newItem = new MenuItem("New");

        fileMenu.getItems().add(newItem);

        var open = new MenuItem("Open");
        fileMenu.getItems().add(open);

        var save = new MenuItem("Save");
        fileMenu.getItems().add(save);

        var settings = new MenuItem("Settings");
        fileMenu.getItems().add(settings);

        fileMenu.getItems().add(new SeparatorMenuItem());

        var exit = new MenuItem("Exit");
        exit.setOnAction((ActionEvent event)
                -> Platform.exit());

        fileMenu.getItems().add(exit);

        rootMenu.getChildren().add(menuBar);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        borderPane.setTop(rootMenu);
        borderPane.setStyle("-fx-background-color: orange");

        primaryStage.setTitle("Search");
        primaryStage.setScene(new Scene(borderPane, 285, 220));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);

    }
}









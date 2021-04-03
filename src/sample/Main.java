package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundFill;

import javax.swing.*;

import static javafx.scene.layout.VBox.setMargin;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        // Label, button, and pane creation.

        Label label = new Label("5");
        label.setAlignment(Pos.CENTER);

        // Button with event handler.
        Button button = new Button("Sequential");
        Button button2 = new Button("Binary");
        Button button3 = new Button("Exit");

        button.setOnAction(
                event ->
                {

                    int count = Integer.parseInt(label.getText());
                    count++;
                    label.setText(String.valueOf(count));
                });

        button2.setOnAction(
                event ->
                {

                });


        button3.setOnAction(
                event ->
                {
                    System.exit(0);
                });

        // Sets the margins for a VBox pane on the label and button.
        Insets insets = new Insets(10);
        setMargin(label, insets);
        setMargin(button, insets);
        setMargin(button2, insets);


        VBox pane = new VBox(10); // Creates a VBox with default spacing and allignment.
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(label); // Adds the label and button to the children of the pane.


        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(button, button2, button3);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(pane);
        borderPane.setCenter(hBox);


        primaryStage.setTitle("Search Benchmarks");
        primaryStage.setScene(new Scene(borderPane, 240, 80));
        primaryStage.show();
    }

    public static void main(String[] args) {
        int numbers[] = {536, 289, 296, 429, 319, 142, 394,
                101, 388, 147, 417, 199, 207, 222,
                189, 310, 447, 521, 234, 600};

        launch(args);

    }

}


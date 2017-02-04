/**
 * Created by nikcr on 2/3/2017.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Observable;

public class ComboBoxDemo extends Application {

    ComboBox cbTransport;
    Label resposne;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ComboBox Demo");

        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 250, 120);
        primaryStage.setScene(scene);

        resposne = new Label();

        ObservableList<String> transportTypes = FXCollections.observableArrayList("Train", "Car", "Airplane");
        cbTransport = new ComboBox<>(transportTypes);

        resposne.setText("Transport isn't selected");
        cbTransport.setOnAction(event -> resposne.setText("Selected transport is " + cbTransport.getValue()));

        root.getChildren().addAll(cbTransport, resposne);

        primaryStage.show();
    }
}

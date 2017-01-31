import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ListView Demo");

        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 200, 220);
        primaryStage.setScene(scene);

        response = new Label("Select Transport Type");

        ObservableList<String> transportTypes =
                FXCollections.observableArrayList("Train", "Car", "Airplane", "Bicycle", "Walking");

        final ListView<String> lvTransport = new ListView<>(transportTypes);
        lvTransport.setPrefSize(80, 80);
        lvTransport.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        MultipleSelectionModel<String> lvSelModel = lvTransport.getSelectionModel();

        lvSelModel.selectedItemProperty().addListener((ch, old, newVal) -> {
            StringBuilder selItems = new StringBuilder();
            ObservableList<String> selected = lvTransport.getSelectionModel().getSelectedItems();

            selected.forEach(s -> selItems.append("\n   " + s));
            // response.setText("Transport selected is " + newVal);
            response.setText("All transport selected: " + selItems);
        });

        root.getChildren().addAll(lvTransport, response);

        primaryStage.show();
    }
}

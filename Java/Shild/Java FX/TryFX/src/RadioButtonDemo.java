
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Arrays;


public class RadioButtonDemo extends Application {

    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Demonstrate Radio Button");

        FlowPane root = new FlowPane(10,10);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 220, 140);
        primaryStage.setScene(scene);

        Label choose = new Label("  Select transport type   ");
        response = new Label("");

        Button btnConfirm = new Button("Confirm Transport Selection");

        RadioButton rbTrain = new RadioButton("Train");
        RadioButton rbCar = new RadioButton("Car");
        RadioButton rbPlain = new RadioButton("Airplane");

        ToggleGroup tg = new ToggleGroup();

        Arrays.asList(rbTrain, rbCar, rbPlain).forEach(rb -> rb.setToggleGroup(tg));
        /* (1)
        rbTrain.setOnAction(rb -> response.setText("Transport selected is train."));
        rbCar.setOnAction(rb -> response.setText("Transport selected is car."));
        rbPlain.setOnAction(rb -> response.setText("Transport selected is airplain."));*/
        // Заменяет (1)
        tg.selectedToggleProperty().addListener((ch, old, newVal) -> response.setText("Trasport selected is " +
                ((RadioButton)newVal).getText()));

        btnConfirm.setOnAction(event -> response.setText(((RadioButton)tg.getSelectedToggle()).getText() + " is confirmed."));

        // Разделитель
        Separator separator = new Separator();
        separator.setPrefWidth(180);

        root.getChildren().addAll(choose, rbTrain, rbCar, rbPlain, separator, btnConfirm, response);

        primaryStage.show();


    }
}

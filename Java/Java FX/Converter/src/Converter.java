import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;


public class Converter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();

        

        root.getChildren().addAll();
        root.getChildren().forEach(node -> VBox.setMargin(node, new Insets(0,0,8,0)));
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Маринатор v2.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

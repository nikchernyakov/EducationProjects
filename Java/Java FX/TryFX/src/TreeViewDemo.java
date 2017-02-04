import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {

    Label resposne;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TreeView Demo");

        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 310,460);
        primaryStage.setScene(scene);

        resposne = new Label("Search String: ");
    }
}

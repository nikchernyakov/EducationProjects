import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextFieldDemo extends Application {

    TextField tf;
    Label resposne;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TextFiled Demo");

        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 230,140);
        primaryStage.setScene(scene);

        resposne = new Label("Search String: ");

        tf = new TextField();
        tf.setPromptText("Enter Search String");
        tf.setPrefColumnCount(15);
        tf.setOnAction(event -> resposne.setText("Search String: " + tf.getText()));

        Button btnGetText = new Button("Get Search String");
        btnGetText.setOnAction(event -> resposne.setText("Search String: " + tf.getText()));

        Separator separator = new Separator();
        separator.setPrefWidth(180);

        root.getChildren().addAll(tf, btnGetText, separator, resposne);

        primaryStage.show();

    }
}

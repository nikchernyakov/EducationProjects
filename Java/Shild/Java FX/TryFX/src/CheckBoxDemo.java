import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class CheckBoxDemo extends Application {

    CheckBox cbWeb;
    CheckBox cbMobile;
    CheckBox cbDesktop;

    Label response;
    Label allTargets;

    String targets = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Demonstrate CheckBox");

        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 230, 140);

        primaryStage.setScene(scene);

        Label heading = new Label("Select Deployment Options");

        response = new Label("No Deployment Selected");
        allTargets = new Label("Target List: <none>");

        cbWeb = new CheckBox("Web");
        cbDesktop = new CheckBox("Desktop");
        cbMobile = new CheckBox("Mobile");

        cbWeb.setOnAction(event -> {response.setText("Web deployment "
                + (cbWeb.isSelected() ? "selected" : "cleared"));
            showAll();});
        cbDesktop.setOnAction(event -> {response.setText("Desktop deployment "
                + (cbDesktop.isSelected() ? "selected" : "cleared")); showAll();});
        cbMobile.setOnAction(event -> {response.setText("Mobile deployment "
                + (cbMobile.isSelected() ? "selected" : "cleared")); showAll();});

        Separator separator = new Separator();
        separator.setPrefWidth(200);

        root.getChildren().addAll(heading, separator, cbWeb, cbDesktop, cbMobile,
                response, allTargets);

        primaryStage.show();
    }

    void showAll(){
        targets = "";
        Arrays.asList(cbWeb, cbDesktop, cbMobile)
                .forEach(cb -> targets += (cb.isSelected() ? cb.getText() + " " : ""));

        if(targets.equals("")) targets = "<none>";

        allTargets.setText("Target List: " + targets);
    }
}

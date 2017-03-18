import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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

        Scene scene = new Scene(root, 310, 460);
        primaryStage.setScene(scene);

        resposne = new Label("No Selection");

        TreeItem<String> tiRoot = new TreeItem<>("Food");

        TreeItem<String> tiFruit = new TreeItem<>("Fruit");

        TreeItem<String> tiApples = new TreeItem<>("Apple");
        tiApples.getChildren().add(new TreeItem<>("Fuji"));
        tiApples.getChildren().add(new TreeItem<>("Winesap"));
        tiApples.getChildren().add(new TreeItem<>("Jonathan"));

        tiFruit.getChildren().add(tiApples);
        tiFruit.getChildren().add(new TreeItem<>("Pears"));
        tiFruit.getChildren().add(new TreeItem<>("Oranges"));

        TreeItem<String> tiVegetables = new TreeItem<>("Vegetables");
        tiVegetables.getChildren().add(new TreeItem<>("Corn"));
        tiVegetables.getChildren().add(new TreeItem<>("Peas"));
        tiVegetables.getChildren().add(new TreeItem<>("Broccoli"));
        tiVegetables.getChildren().add(new TreeItem<>("Beans"));

        TreeItem<String> tiNuts = new TreeItem<>("Nuts");
        tiNuts.getChildren().add(new TreeItem<>("Walnuts"));
        tiNuts.getChildren().add(new TreeItem<>("Peanuts"));
        tiNuts.getChildren().add(new TreeItem<>("Pecans"));

        tiRoot.getChildren().addAll(tiFruit, tiVegetables, tiNuts);

        TreeView<String> tvFood = new TreeView<>(tiRoot);
        MultipleSelectionModel<TreeItem<String>> tvSelModel = tvFood.getSelectionModel();
        tvSelModel.selectedItemProperty().addListener((ch, ov, nv) -> {
            String path = "";
            TreeItem<String> treeItem = nv;
            while (treeItem != null) {
                path = "/" + treeItem.getValue() + path;
                treeItem = treeItem.getParent();
            }

            resposne.setText("Selection is " + nv.getValue() +
                    "\nComlete path is " + path);
        });

        root.getChildren().addAll(tvFood, resposne);
        primaryStage.show();
    }
}

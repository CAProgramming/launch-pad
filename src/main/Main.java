package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-window.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,400,400);

        File f = new File("style.css");
        System.out.println(f.getAbsolutePath());
        scene.getStylesheets().clear();
        scene.getStylesheets().add(f.getPath());
        System.out.println(scene.getStylesheets());

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Test");
        this.primaryStage.setScene(scene);
        Controller controller = loader.getController();
        controller.init(loader.getRoot(), scene, this.primaryStage);
        this.primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

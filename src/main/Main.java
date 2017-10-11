package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-window.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,800,600);

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Test");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();

        Controller controller = loader.getController();
        controller.setStage(this.primaryStage);
        controller.init();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

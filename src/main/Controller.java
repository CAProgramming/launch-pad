package main;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.awt.event.KeyListener;

public class Controller {
    private Stage stage;
    private Node root;
    private Scene scene;


    @FXML
    Button _1_1;


    @FXML
    void fire_1_1() {
        System.out.println("1, 1 fired");
    }

    void init(Node root, Scene scene, Stage stage) {
        this.root = root;
        this.stage = stage;
        this.scene = scene;
        createEventListeners(scene);
        System.out.println("controller initialized");

    }

    private void createEventListeners(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Q:
                        _1_1.fire();
                        break;
                    case W:
                        break;
                    case E:
                        break;
                    case R:
                        break;
                }
            }

        });

    }
}

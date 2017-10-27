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
    private MIDIHandler midi;

    public enum Mode { MIDI, SAMPLE };

    @FXML
    Button _0_0;


    @FXML
    void fire_0_0() {
        arm(_0_0);
        System.out.println("0, 0 fired");
    }

    @FXML
    void ceasefire_0_0() {
        disarm(_0_0);
        System.out.println("0, 0 ceased fire");
    }

    void init(Node root, Scene scene, Stage stage, MIDIHandler midi) {
        this.root = root;
        this.stage = stage;
        this.scene = scene;
        this.midi = midi;
        createEventListeners(scene);
        System.out.println("controller initialized");
    }

    private void createEventListeners(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Q:
                        arm(_0_0);
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
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Q:
                        disarm(_0_0);
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

    void arm(Button b) {
        b.arm();
        b.getStyleClass().add("armed");
        b.fire();
        midi.noteOn(60, 155);
    }
    void disarm(Button b) {
        b.getStyleClass().remove("armed");
        midi.noteOff(60);
    }
}

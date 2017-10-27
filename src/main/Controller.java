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
    MidiCtrlButton _0_0;


    @FXML
    void fire_0_0() {
        _0_0.arm();
        System.out.println("0, 0 fired");
    }

    @FXML
    void ceasefire_0_0() {
        _0_0.disArm();
        System.out.println("0, 0 ceased fire");
    }

    void init(Node root, Scene scene, Stage stage, MIDIHandler midi) {
        this.root = root;
        this.stage = stage;
        this.scene = scene;
        this.midi = midi;
       
        createEventListeners(scene);
        _0_0.init(midi, 60, 155);
        System.out.println("controller initialized");
    }

    private void createEventListeners(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Q:
                    
                        _0_0.arm();
                       
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
                        _0_0.disArm();
                        
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

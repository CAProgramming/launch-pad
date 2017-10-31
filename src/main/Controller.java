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

    public enum Mode { MIDI, SAMPLE }

    @FXML
    MidiCtrlButton _0_0;
    @FXML
    MidiCtrlButton _0_1;
    @FXML
    MidiCtrlButton _0_2;
    @FXML
    MidiCtrlButton _0_3;
    @FXML
    MidiCtrlButton _1_0;
    @FXML
    MidiCtrlButton _1_1;
    @FXML
    MidiCtrlButton _1_2;
    @FXML
    MidiCtrlButton _1_3;
    @FXML
    MidiCtrlButton _2_0;
    @FXML
    MidiCtrlButton _2_1;
    @FXML
    MidiCtrlButton _2_2;
    @FXML
    MidiCtrlButton _2_3;
    @FXML
    MidiCtrlButton _3_0;
    @FXML
    MidiCtrlButton _3_1;
    @FXML
    MidiCtrlButton _3_2;
    @FXML
    MidiCtrlButton _3_3;


    @FXML
    void fire_0_0() {
        _0_0.arm();
        System.out.println("0, 0 fired");
    }

    @FXML
    void fire_0_1() {
        _0_1.arm();
        System.out.println("0, 1 fired");
    }

    @FXML
    void fire_0_2() {
        _0_2.arm();
        System.out.println("0, 2 fired");
    }

    @FXML
    void fire_0_3() {
        _0_3.arm();
        System.out.println("0, 3 fired");
    }

    @FXML
    void fire_1_0() {
        _1_0.arm();
        System.out.println("1, 0 fired");
    }

    @FXML
    void fire_1_1() {
        _1_1.arm();
        System.out.println("1, 1 fired");
    }

    @FXML
    void fire_1_2() {
        _1_2.arm();
        System.out.println("1, 2 fired");
    }

    @FXML
    void fire_1_3() {
        _1_3.arm();
        System.out.println("1, 3 fired");
    }

    @FXML
    void fire_2_0() {
        _2_0.arm();
        System.out.println("2, 0 fired");
    }

    @FXML
    void fire_2_1() {
        _2_1.arm();
        System.out.println("2, 1 fired");
    }

    @FXML
    void fire_2_2() {
        _2_2.arm();
        System.out.println("2, 2 fired");
    }

    @FXML
    void fire_2_3() {
        _2_3.arm();
        System.out.println("2, 3 fired");
    }

    @FXML
    void fire_3_0() {
        _3_0.arm();
        System.out.println("3, 0 fired");
    }

    @FXML
    void fire_3_1() {
        _3_1.arm();
        System.out.println("3, 1 fired");
    }

    @FXML
    void fire_3_2() {
        _3_2.arm();
        System.out.println("3, 2 fired");
    }

    @FXML
    void fire_3_3() {
        _3_3.arm();
        System.out.println("3, 3 fired");
    }



    @FXML
    void ceasefire_0_0() {
        _0_0.disArm();
        System.out.println("0, 0 ceased fire");
    }

    @FXML
    void ceasefire_0_1() {
        _0_1.disArm();
        System.out.println("0, 1 ceased fire");
    }

    @FXML
    void ceasefire_0_2() {
        _0_2.disArm();
        System.out.println("0, 2 ceased fire");
    }

    @FXML
    void ceasefire_0_3() {
        _0_3.disArm();
        System.out.println("0, 3 ceased fire");
    }

    @FXML
    void ceasefire_1_0() {
        _1_0.disArm();
        System.out.println("1, 0 ceased fire");
    }

    @FXML
    void ceasefire_1_1() {
        _1_1.disArm();
        System.out.println("1, 1 ceased fire");
    }

    @FXML
    void ceasefire_1_2() {
        _1_2.disArm();
        System.out.println("1, 2 ceased fire");
    }

    @FXML
    void ceasefire_1_3() {
        _1_3.disArm();
        System.out.println("1, 3 ceased fire");
    }

    @FXML
    void ceasefire_2_0() {
        _2_0.disArm();
        System.out.println("2, 0 ceased fire");
    }

    @FXML
    void ceasefire_2_1() {
        _2_1.disArm();
        System.out.println("2, 1 ceased fire");
    }

    @FXML
    void ceasefire_2_2() {
        _2_2.disArm();
        System.out.println("2, 2 ceased fire");
    }

    @FXML
    void ceasefire_2_3() {
        _2_3.disArm();
        System.out.println("2, 3 ceased fire");
    }

    @FXML
    void ceasefire_3_0() {
        _3_0.disArm();
        System.out.println("3, 0 ceased fire");
    }

    @FXML
    void ceasefire_3_1() {
        _3_1.disArm();
        System.out.println("3, 1 ceased fire");
    }

    @FXML
    void ceasefire_3_2() {
        _3_2.disArm();
        System.out.println("3, 2 ceased fire");
    }

    @FXML
    void ceasefire_3_3() {
        _3_3.disArm();
        System.out.println("3, 3 ceased fire");
    }

    void init(Node root, Scene scene, Stage stage, MIDIHandler midi) {
        this.root = root;
        this.stage = stage;
        this.scene = scene;
        this.midi = midi;
       
        createEventListeners(scene);
        _0_0.init(midi, 60, 155);
        _0_1.init(midi, 61, 155);
        _0_2.init(midi, 62, 155);
        _0_3.init(midi, 63, 155);

        _1_0.init(midi, 64, 155);
        _1_1.init(midi, 65, 155);
        _1_2.init(midi, 66, 155);
        _1_3.init(midi, 67, 155);

        _2_0.init(midi, 68, 155);
        _2_1.init(midi, 69, 155);
        _2_2.init(midi, 70, 155);
        _2_3.init(midi, 71, 155);

        _3_0.init(midi, 72, 155);
        _3_1.init(midi, 73, 155);
        _3_2.init(midi, 74, 155);
        _3_3.init(midi, 75, 155);
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

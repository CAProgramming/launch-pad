package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.awt.event.KeyListener;
import java.util.concurrent.ExecutionException;


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


    void init(Node root, Scene scene, Stage stage, MIDIHandler midi) {
        this.root = root;
        this.stage = stage;
        this.scene = scene;
        this.midi = midi;
       
        createEventListeners(scene);

        _0_0.init(midi, 60, 220, 0);
        _0_1.init(midi, 61, 220, 1);
        _0_2.init(midi, 62, 220, 2);
        _0_3.init(midi, 63, 220, 3);

        _1_0.init(midi, 64, 220, 4);
        _1_1.init(midi, 65, 220, 5);
        _1_2.init(midi, 66, 220,6 );
        _1_3.init(midi, 67, 220, 28);

        _2_0.init(midi, 68, 220, 56);
        _2_1.init(midi, 69, 220, 100);
        _2_2.init(midi, 70, 220, 37);
        _2_3.init(midi, 71, 220, 78);

        _3_0.init(midi, 72, 220, 22);
        _3_1.init(midi, 73, 220, 45);
        _3_2.init(midi, 74, 220, 67);
        _3_3.init(midi, 75, 220, 31);
        System.out.println("controller initialized");
    }

    private void createEventListeners(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case DIGIT1:
                        _0_0.arm();
                        break;
                    case DIGIT2:
                        _0_1.arm();
                        break;
                    case DIGIT3:
                        _0_2.arm();
                        break;
                    case DIGIT4:
                        _0_3.arm();
                        break;
                    case Q:
                        _1_0.arm();
                        break;
                    case W:
                        _1_1.arm();
                        break;
                    case E:
                        _1_2.arm();
                        break;
                    case R:
                        _1_3.arm();
                        break;
                    case A:
                        _2_0.arm();
                        break;
                    case S:
                        _2_1.arm();
                        break;
                    case D:
                        _2_2.arm();
                        break;
                    case F:
                        _2_3.arm();
                        break;
                    case Z:
                        _3_0.arm();
                        break;
                    case X:
                        _3_1.arm();
                        break;
                    case C:
                        _3_2.arm();
                        break;
                    case V:
                        _3_3.arm();
                        break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case DIGIT1:
                        _0_0.disArm();
                        break;
                    case DIGIT2:
                        _0_1.disArm();
                        break;
                    case DIGIT3:
                        _0_2.disArm();
                        break;
                    case DIGIT4:
                        _0_3.disArm();
                        break;
                    case Q:
                        _1_0.disArm();
                        break;
                    case W:
                        _1_1.disArm();
                        break;
                    case E:
                        _1_2.disArm();
                        break;
                    case R:
                        _1_3.disArm();
                        break;
                    case A:
                        _2_0.disArm();
                        break;
                    case S:
                        _2_1.disArm();
                        break;
                    case D:
                        _2_2.disArm();
                        break;
                    case F:
                        _2_3.disArm();
                        break;
                    case Z:
                        _3_0.disArm();
                        break;
                    case X:
                        _3_1.disArm();
                        break;
                    case C:
                        _3_2.disArm();
                        break;
                    case V:
                        _3_3.disArm();
                        break;
                }
            }
        });
    }
}

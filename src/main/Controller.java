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

import javax.sound.midi.ShortMessage;
import java.awt.event.KeyListener;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.io.*;

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

        String line;
        HashMap<String, short[]> config = new HashMap<String, short[]>();
        boolean comment = false;
        try {
            System.out.println(System.getProperty("user.dir"));
            File configfile = new File("src/config.txt");
            FileReader fileReader = new FileReader(configfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(line.equals("/*")) {
                    comment = true;
                } else if(line.equals("*/")) {
                    comment = false;
                } else if(comment == false && line.length() == 9) {
                    String[] message = line.split(":");
                    short[] vals = new short[2];
                    vals[0] = Short.parseShort(message[1].split(",")[0]);
                    vals[1] = Short.parseShort(message[1].split(",")[1]);
                    config.put(message[0], vals);
                }

            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {ex.printStackTrace();}
        catch(IOException ex) {ex.printStackTrace();}
       
        createEventListeners(scene);

        _0_0.init(midi, config.get("0.0")[1], 220, config.get("0.0")[0]);
        _0_1.init(midi, config.get("0.1")[1], 220, config.get("0.1")[0]);
        _0_2.init(midi, config.get("0.2")[1], 220, config.get("0.2")[0]);
        _0_3.init(midi, config.get("0.3")[1], 220, config.get("0.3")[0]);

        _1_0.init(midi, config.get("1.0")[1], 220, config.get("1.0")[0]);
        _1_1.init(midi, config.get("1.1")[1], 220, config.get("1.1")[0]);
        _1_2.init(midi, config.get("1.2")[1], 220, config.get("1.2")[0]);
        _1_3.init(midi, config.get("1.3")[1], 220, config.get("1.3")[0]);

        _2_0.init(midi, config.get("2.0")[1], 220, config.get("2.0")[0]);
        _2_1.init(midi, config.get("2.1")[1], 220, config.get("2.1")[0]);
        _2_2.init(midi, config.get("2.2")[1], 220, config.get("2.2")[0]);
        _2_3.init(midi, config.get("2.3")[1], 220, config.get("2.3")[0]);

        _3_0.init(midi, config.get("3.0")[1], 220, config.get("3.0")[0]);
        _3_1.init(midi, config.get("3.1")[1], 220, config.get("3.1")[0]);
        _3_2.init(midi, config.get("3.2")[1], 220, config.get("3.2")[0]);
        _3_3.init(midi, config.get("3.3")[1], 220, config.get("3.3")[0]);
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

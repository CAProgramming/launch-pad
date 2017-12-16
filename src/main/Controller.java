package main;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.util.List;

public class Controller {
    private Stage stage;
    private Node root;
    private Scene scene;

    @FXML
    PlayableButton _0_0;
    @FXML
    PlayableButton _0_1;
    @FXML
    PlayableButton _0_2;
    @FXML
    PlayableButton _0_3;
    @FXML
    PlayableButton _1_0;
    @FXML
    PlayableButton _1_1;
    @FXML
    PlayableButton _1_2;
    @FXML
    PlayableButton _1_3;
    @FXML
    PlayableButton _2_0;
    @FXML
    PlayableButton _2_1;
    @FXML
    PlayableButton _2_2;
    @FXML
    PlayableButton _2_3;
    @FXML
    PlayableButton _3_0;
    @FXML
    PlayableButton _3_1;
    @FXML
    PlayableButton _3_2;
    @FXML
    PlayableButton _3_3;


    void init(Node root, Scene scene, Stage stage) {
        this.root = root;
        this.stage = stage;
        this.scene = scene;
        createEventListeners(scene);
        ConfigHandler configHandler = new ConfigHandler();
        List<List<List<Object>>> config = configHandler.loadConfig();

        _0_0.init(config.get(0).get(0));
        _0_1.init(config.get(0).get(1));
        _0_2.init(config.get(0).get(2));
        _0_3.init(config.get(0).get(3));

        _1_0.init(config.get(1).get(0));
        _1_1.init(config.get(1).get(1));
        _1_2.init(config.get(1).get(2));
        _1_3.init(config.get(1).get(3));

        _2_0.init(config.get(2).get(0));
        _2_1.init(config.get(2).get(1));
        _2_2.init(config.get(2).get(2));
        _2_3.init(config.get(2).get(3));

        _3_0.init(config.get(3).get(0));
        _3_1.init(config.get(3).get(1));
        _3_2.init(config.get(3).get(2));
        _3_3.init(config.get(3).get(3));
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

package main;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PlayableButton extends Button {
    private boolean midi;
    private Handler handler;
    private boolean isOn;

    // MIDI fields
    private short noteNum;
    private short instrument;
    private short velocity;

    public PlayableButton() {
        super();
    }

    public void init(List<Object> params) {
        if (params.get(0).getClass().equals(MIDIHandler.class)) {
            if (params.size() == 3) {
                this.init((Handler) params.get(0), (short) params.get(1), (short) params.get(2));
            } else if (params.size() == 2) {
                this.init((Handler) params.get(0), (short) params.get(1));
            } else {
                System.out.println("You passed the wrong parameters for a " + handler.getClass() + "!");
                this.handler = null;
            }
        } else {
            if (params.size() == 2) {
                this.init((Handler) params.get(0), (String) params.get(1));
            } else {
                System.out.println("You passed the wrong parameters for a " + handler.getClass() + "!");
                this.handler = null;
            }
        }
    }

    // ************************************* MIDI constructors
    public void init(Handler handler, short noteNum) {
        if (handler.getClass().equals(MIDIHandler.class)) {
            this.handler = handler;
            this.midi = true;
            this.isOn = false;
            this.noteNum = noteNum;
            this.instrument = 0;

            this.velocity = 220;

            this.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    arm();
                }
            });

            this.setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    disArm();
                }
            });
        } else {
            System.out.println("You passed the wrong parameters for a " + handler.getClass() + "!");
            this.handler = null;
        }
    }

    public void init(Handler handler, short noteNum, short instrument) {
        if (handler.getClass().equals(MIDIHandler.class)) {
            this.handler = handler;
            this.midi = true;
            this.isOn = false;
            this.noteNum = noteNum;
            this.instrument = instrument;

            this.velocity = 220;

            this.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    arm();
                }
            });

            this.setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    disArm();
                }
            });
        } else {
            System.out.println("You passed the wrong parameters for a " + handler.getClass() + "!");
            this.handler = null;
        }
    }
    // *************************************


    // ************************************* Audio sample constructors
    public void init(Handler handler, String samplePath) {
        if (handler.getClass().equals(SampleHandler.class)) {

        } else {
            System.out.println("You passed the wrong parameters for a " + handler.getClass() + "!");
            this.handler = null;
        }
    }
    // *************************************


    // MIDI helper functions
    public void setVelocity(short velocity) {
        this.velocity = velocity;
    }

    // Audio sample helper functions

    public void arm() {
        if (!isOn) {
            super.arm();
            super.fire();
            getStyleClass().add("armed");
            this.isOn = true;

            if (this.midi == true) {
                Map<String, Integer> params = new HashMap<>();
                params.put("noteNum", (int) this.noteNum);
                params.put("instrument", (int) this.instrument);
                params.put("velocity", (int) this.velocity);
                handler.play(params);
            } else {
            }

            System.out.println("armed");
        }
    }

    public void disArm() {
        super.disarm();
        getStyleClass().remove("armed");
        this.isOn = false;

        if (this.midi == true) {
            Map<String, Integer> params = new HashMap<>();
            params.put("noteNum", (int) this.noteNum);
            handler.stop(params);
        } else {
        }

        System.out.println("disarmed");
    }
}

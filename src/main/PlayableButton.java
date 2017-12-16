package main;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

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


    // ************************************* MIDI constructors
    public PlayableButton(Handler handler, short noteNum) {
        super();
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

    public PlayableButton(Handler handler, short noteNum, short instrument) {
        super();
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
    public PlayableButton(Handler handler, String samplePath) {
        super();
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
                Map<String, Short> params = new HashMap<>();
                params.put("noteNum", this.noteNum);
                params.put("instrument", this.instrument);
                params.put("velocity", this.velocity);
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
            Map<String, Short> params = new HashMap<>();
            params.put("noteNum", this.noteNum);
            handler.stop(params);
        } else {
        }

        System.out.println("disarmed");
    }
}

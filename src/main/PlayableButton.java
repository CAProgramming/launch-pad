package main;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PlayableButton extends Button {
    private String buttonID;

    private boolean midi;
    private Handler handler;
    private boolean isOn;

    // MIDI fields
    private short noteNum;
    private short instrument;
    private short velocity;

    // Audio sample fields
    private String filepath;
    private float gain;

    public PlayableButton() {
        super();
    }

    public void init(List<Object> params) {
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
        if (params.get(1).getClass().equals(MIDIHandler.class)) {
            if (params.size() == 4) {
                this.buttonID = (String) params.get(0);
                this.init((MIDIHandler) params.get(1), (short) params.get(2), (short) params.get(3));
            } else if (params.size() == 3) {
                this.buttonID = (String) params.get(0);
                this.init((MIDIHandler) params.get(1), (short) params.get(2));
            } else {
                System.out.println("You passed the wrong parameters for a " + handler.getClass() + "!");
                this.handler = null;
            }
        } else {
            if (params.size() == 4) {
                this.buttonID = (String) params.get(0);
                this.init((SampleHandler) params.get(1), (String) params.get(2), (float) params.get(3));
            } else {
                System.out.println("You passed the wrong parameters for a " + handler.getClass() + "!");
                this.handler = null;
            }
        }
    }

    // ************************************* MIDI constructors
    public void init(MIDIHandler handler, short noteNum) {
        if (handler.getClass().equals(MIDIHandler.class)) {
            this.handler = handler;
            this.midi = true;
            this.isOn = false;
            this.noteNum = noteNum;
            this.instrument = 0;

            this.velocity = 220;

        } else {
            System.out.println("You passed the wrong parameters for a " + handler.getClass() + "!");
            this.handler = null;
        }
    }

    public void init(MIDIHandler handler, short noteNum, short instrument) {
        if (handler.getClass().equals(MIDIHandler.class)) {
            this.handler = handler;
            this.midi = true;
            this.isOn = false;
            this.noteNum = noteNum;
            this.instrument = instrument;

            this.velocity = 220;

        } else {
            System.out.println("You passed the wrong parameters for a " + handler.getClass() + "!");
            this.handler = null;
        }
    }
    // *************************************


    // ************************************* Audio sample constructors
    public void init(SampleHandler handler, String samplePath, float gain) {
        if (handler.getClass().equals(SampleHandler.class)) {
            this.handler = handler;
            this.midi = false;
            this.isOn = false;
            this.filepath = samplePath;
            this.gain = gain;

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
                Map<String, Object> params = new HashMap<>();
                params.put("filepath", this.filepath);
                params.put("buttonID", this.buttonID);
                params.put("gain", this.gain);
                handler.play(params);
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
            Map<String, Object> params = new HashMap<>();
            params.put("buttonID", this.buttonID);
            handler.stop(params);
        }

        System.out.println("disarmed");
    }
}

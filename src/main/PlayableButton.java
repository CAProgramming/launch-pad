package main;

import javafx.scene.control.Button;

public class PlayableButton extends Button {
    private boolean midi;
    private Button map;
    private short shortParam1;
    private short shortParam2;
    private short shortParam3;
    private String stringParam1;
    private String stringParam2;
    private String stringParam3;

    private boolean isOn;

    // Constructors

    public PlayableButton(boolean midi, String stringParam1) {
        super();
        this.midi = midi;
        this.stringParam1 = stringParam1;
    }

    public PlayableButton(boolean midi, String stringParam1, String stringParam2, String stringParam3) {
        super();
    }

    public PlayableButton(boolean midi, short shortParam1, short shortParam2, short shortParam3) {
        super();
    }

    public void arm() {
        if(this.midi == true) {
            MIDIHandler midi = new MIDIHandler();
        }

    }

    public void disArm() {

    }
}

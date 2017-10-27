package main;

import javafx.scene.control.Button;

public class MidiCtrlButton extends Button {
    private MIDIHandler midi;
    private int noteNumber;
    private int velocity;

    public MidiCtrlButton(){
        super();
    }
    public void init(MIDIHandler midi, int noteNumber, int velocity){
        this.midi=midi;
        this.noteNumber=noteNumber;
        this.velocity=velocity;
    }

    public void arm(){
        super.arm();
        getStyleClass().add("armed");
        super.fire();
        midi.noteOn(noteNumber, velocity);
    }

    public void disArm(){
        getStyleClass().remove("armed");
        midi.noteOff(noteNumber);
    }
}

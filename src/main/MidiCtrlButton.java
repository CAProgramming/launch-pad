package main;

import javafx.scene.control.Button;

public class MidiCtrlButton extends Button {
    private MIDIHandler midi;
    private int noteNumber;
    private int velocity;
    private boolean isOn;
    public MidiCtrlButton(){
        super();
    }
    public void init(MIDIHandler midi, int noteNumber, int velocity){
        this.midi=midi;
        this.noteNumber=noteNumber;
        this.velocity=velocity;
        this.isOn=false;
    }

    public void arm(){
    	if(!isOn) {
        super.arm();
        getStyleClass().add("armed");
        super.fire();
        midi.noteOn(noteNumber, velocity);
        this.isOn=true;
    	}
    }

    public void disArm(){
        getStyleClass().remove("armed");
        
        midi.noteOff(noteNumber);
        this.isOn=false;
    }
}

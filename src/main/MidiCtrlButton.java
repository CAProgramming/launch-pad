package main;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MidiCtrlButton extends Button {
    private MIDIHandler midi;
    private int noteNumber;
    private int velocity;
    private int instrument;
    private boolean isOn;
    public MidiCtrlButton(){
        super();
    }

    public void init(MIDIHandler midi, int noteNumber, int velocity, int instrument){
        this.midi=midi;
        this.noteNumber=noteNumber;
        this.velocity=velocity;
        this.instrument=instrument;
        this.isOn=false;
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
    }

    public void arm(){
    	if(!isOn) {
        super.arm();
        getStyleClass().add("armed");
        super.fire();
        midi.noteOn(noteNumber, velocity, instrument);
        this.isOn=true;
        System.out.println("armed");
    	}
    }


    public void disArm(){
        super.disarm();
        getStyleClass().remove("armed");
        System.out.println("disarmed");
        midi.noteOff(noteNumber);
        this.isOn=false;
    }
}

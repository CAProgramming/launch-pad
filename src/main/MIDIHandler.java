package main;

import javax.sound.midi.*;

public class MIDIHandler{

    Synthesizer midiSynth;
    MidiChannel[] mChannels;


    public MIDIHandler() {
        try{
            midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();
            mChannels = midiSynth.getChannels();

        } catch (MidiUnavailableException e) {}
    }

    void noteOn(int noteNumber, int velocity, int instrument) {
        midiSynth.getChannels()[0].programChange(instrument);
        mChannels[0].noteOn(noteNumber, velocity);
    }
    void noteOff(int noteNumber) {
        mChannels[0].noteOff(noteNumber);
    }

}
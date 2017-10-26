package main;

import javax.sound.midi.*;

public class MIDIHandler {

    Synthesizer midiSynth;
    Instrument[] instr;
    MidiChannel[] mChannels;

    public MIDIHandler() {
        try{
            midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();

            instr = midiSynth.getDefaultSoundbank().getInstruments();
            mChannels = midiSynth.getChannels();

            midiSynth.loadInstrument(instr[0]);

        } catch (MidiUnavailableException e) {}
    }

    void noteOn(int noteNumber, int velocity) {
        mChannels[0].noteOn(noteNumber, velocity);
    }
    void noteOff(int noteNumber) {
        mChannels[0].noteOff(noteNumber);
    }

}
package main;

import javax.sound.midi.*;

public class MIDIHandler {

    public static void main(String[] args) {
        try{
            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();

            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            MidiChannel[] mChannels = midiSynth.getChannels();

            midiSynth.loadInstrument(instr[0]);

            mChannels[0].noteOn(60, 200);
            mChannels[0].noteOn(64, 100);
            mChannels[0].noteOn(67, 100);
            try { Thread.sleep(5000);
            } catch( InterruptedException e ) { }
            mChannels[0].noteOff(60);
            mChannels[0].noteOff(64);
            mChannels[0].noteOff(67);

        } catch (MidiUnavailableException e) {}
    }

}

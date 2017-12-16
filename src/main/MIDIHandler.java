package main;

import javax.sound.midi.*;
import java.util.Map;
import java.lang.Integer;


public class MIDIHandler implements Handler<Integer>{

    Synthesizer midiSynth;
    MidiChannel[] mChannels;


    public MIDIHandler() {
        super();
        try{
            midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();
            mChannels = midiSynth.getChannels();

        } catch (MidiUnavailableException e) {}
    }

    @Override
    public void play(Map<String, Integer> param) {
        if(!param.isEmpty() && param.size() == 3) {
            midiSynth.getChannels()[0].programChange(param.get("instrument"));
            mChannels[0].noteOn(param.get("noteNum"), param.get("velocity"));
        } else {
            System.out.println("Parameters were not usable.");
        }
    }

    @Override
    public void stop(Map<String, Integer> param) {
        if(!param.isEmpty() && param.size() == 1) {
            mChannels[0].noteOff(param.get("noteNum"));
        } else {
            System.out.println("Parameters were not usable.");
        }
    }

}
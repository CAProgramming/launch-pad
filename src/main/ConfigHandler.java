package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigHandler {
    private File config;
    private MIDIHandler midiHandler;
    private SampleHandler sampleHandler;

    public ConfigHandler() {
        try {
            config = new File("config.txt");
            if (!config.exists()) {
                config.createNewFile();
                String def = "/*\n" +
                        "Piano:\n" +
                        "0 Acoustic Grand Piano\n" +
                        "1 Bright Acoustic Piano\n" +
                        "2 Electric Grand Piano\n" +
                        "3 Honky-tonk Piano\n" +
                        "4 Electric Piano 1\n" +
                        "5 Electric Piano 2\n" +
                        "6 Harpsichord\n" +
                        "7 Clavinet\n" +
                        "\n" +
                        "Chromatic Percussion:\n" +
                        "8 Celesta\n" +
                        "9 Glockenspiel\n" +
                        "10 Music Box\n" +
                        "11 Vibraphone\n" +
                        "12 Marimba\n" +
                        "13 Xylophone\n" +
                        "14 Tubular Bells\n" +
                        "15 Dulcimer\n" +
                        "\n" +
                        "Organ:\n" +
                        "16 Drawbar Organ\n" +
                        "17 Percussive Organ\n" +
                        "18 Rock Organ\n" +
                        "19 Church Organ\n" +
                        "20 Reed Organ\n" +
                        "21 Accordion\n" +
                        "22 Harmonica\n" +
                        "23 Tango Accordion\n" +
                        "\n" +
                        "Guitar:\n" +
                        "24 Acoustic Guitar (nylon)\n" +
                        "25 Acoustic Guitar (steel)\n" +
                        "26 Electric Guitar (jazz)\n" +
                        "27 Electric Guitar (clean)\n" +
                        "28 Electric Guitar (muted)\n" +
                        "29 Overdriven Guitar\n" +
                        "30 Distortion Guitar\n" +
                        "31 Guitar harmonics\n" +
                        "\n" +
                        "Bass:\n" +
                        "32 Acoustic Bass\n" +
                        "33 Electric Bass (finger)\n" +
                        "34 Electric Bass (pick)\n" +
                        "35 Fretless Bass\n" +
                        "36 Slap Bass 1\n" +
                        "37 Slap Bass 2\n" +
                        "38 Synth Bass 1\n" +
                        "39 Synth Bass 2\n" +
                        "\n" +
                        "Strings:\n" +
                        "40 Violin\n" +
                        "41 Viola\n" +
                        "42 Cello\n" +
                        "43 Contrabass\n" +
                        "44 Tremolo Strings\n" +
                        "45 Pizzicato Strings\n" +
                        "46 Orchestral Harp\n" +
                        "47 Timpani\n" +
                        "\n" +
                        "Strings (continued):\n" +
                        "48 String Ensemble 1\n" +
                        "49 String Ensemble 2\n" +
                        "50 Synth Strings 1\n" +
                        "51 Synth Strings 2\n" +
                        "52 Choir Aahs\n" +
                        "53 Voice Oohs\n" +
                        "54 Synth Voice\n" +
                        "55 Orchestra Hit\n" +
                        "\n" +
                        "Brass:\n" +
                        "56 Trumpet\n" +
                        "57 Trombone\n" +
                        "58 Tuba\n" +
                        "59 Muted Trumpet\n" +
                        "60 French Horn\n" +
                        "61 Brass Section\n" +
                        "62 Synth Brass 1\n" +
                        "63 Synth Brass 2\n" +
                        "\n" +
                        "Reed:\n" +
                        "64 Soprano Sax\n" +
                        "65 Alto Sax\n" +
                        "66 Tenor Sax\n" +
                        "67 Baritone Sax\n" +
                        "68 Oboe\n" +
                        "69 English Horn\n" +
                        "70 Bassoon\n" +
                        "71 Clarinet\n" +
                        "\n" +
                        "Pipe:\n" +
                        "72 Piccolo\n" +
                        "73 Flute\n" +
                        "74 Recorder\n" +
                        "75 Pan Flute\n" +
                        "76 Blown Bottle\n" +
                        "77 Shakuhachi\n" +
                        "78 Whistle\n" +
                        "79 Ocarina\n" +
                        "\n" +
                        "Synth Lead:\n" +
                        "80 Lead 1 (square)\n" +
                        "81 Lead 2 (sawtooth)\n" +
                        "82 Lead 3 (calliope)\n" +
                        "83 Lead 4 (chiff)\n" +
                        "84 Lead 5 (charang)\n" +
                        "85 Lead 6 (voice)\n" +
                        "86 Lead 7 (fifths)\n" +
                        "87 Lead 8 (bass + lead)\n" +
                        "\n" +
                        "Synth Pad:\n" +
                        "88 Pad 1 (new age)\n" +
                        "89 Pad 2 (warm)\n" +
                        "90 Pad 3 (polysynth)\n" +
                        "91 Pad 4 (choir)\n" +
                        "92 Pad 5 (bowed)\n" +
                        "93 Pad 6 (metallic)\n" +
                        "94 Pad 7 (halo)\n" +
                        "95 Pad 8 (sweep)\n" +
                        "\n" +
                        "Synth Effects:\n" +
                        "96 FX 1 (rain)\n" +
                        "97 FX 2 (soundtrack)\n" +
                        "98 FX 3 (crystal)\n" +
                        "99 FX 4 (atmosphere)\n" +
                        "100 FX 5 (brightness)\n" +
                        "101 FX 6 (goblins)\n" +
                        "102 FX 7 (echoes)\n" +
                        "103 FX 8 (sci-fi)\n" +
                        "\n" +
                        "Ethnic:\n" +
                        "104 Sitar\n" +
                        "105 Banjo\n" +
                        "106 Shamisen\n" +
                        "107 Koto\n" +
                        "108 Kalimba\n" +
                        "109 Bag pipe\n" +
                        "110 Fiddle\n" +
                        "111 Shanai\n" +
                        "\n" +
                        "Percussive:\n" +
                        "112 Tinkle Bell\n" +
                        "113 Agogo\n" +
                        "114 Steel Drums\n" +
                        "115 Woodblock\n" +
                        "116 Taiko Drum\n" +
                        "117 Melodic Tom\n" +
                        "118 Synth Drum\n" +
                        "\n" +
                        "Sound effects:\n" +
                        "119 Reverse Cymbal\n" +
                        "120 Guitar Fret Noise\n" +
                        "121 Breath Noise\n" +
                        "122 Seashore\n" +
                        "123 Bird Tweet\n" +
                        "124 Telephone Ring\n" +
                        "125 Helicopter\n" +
                        "126 Applause\n" +
                        "127 Gunshot\n" +
                        "\n" +
                        "Configuration=\n" +
                        "\n" +
                        "Button_row => Integer from 0 to 3\n" +
                        "Button_column => Integer from 0 to 3\n" +
                        "\n" +
                        "Note => Integer from 0 to 127\n" +
                        "Instrument => Integer from 0 to 127\n" +
                        "\n" +
                        "filepath => String of absolute filepath\n" +
                        "gain => Float from -80.0 to 6\n" +
                        "\n" +
                        "MIDI:\n" +
                        "Button_row.Button_column:Note,Instrument   <-- If you want to use default instrument (0), then simply leave number after\n" +
                        "comma empty\n" +
                        "\n" +
                        "Audio Sample:\n" +
                        "Button_row.Button_column:\"filepath\"gain\n" +
                        "\n" +
                        "*/\n" +
                        "\n" +
                        "0.0:60,\n" +
                        "0.1:62,\n" +
                        "0.2:64,\n" +
                        "0.3:65,\n" +
                        "\n" +
                        "1.0:67,\n" +
                        "1.1:69,\n" +
                        "1.2:71,\n" +
                        "1.3:72\n" +
                        "\n" +
                        "2.0:74,\n" +
                        "2.1:76,\n" +
                        "2.2:77,\n" +
                        "2.3:79,\n" +
                        "\n" +
                        "3.0:81,\n" +
                        "3.1:83,\n" +
                        "3.2:84,\n" +
                        "3.3:86,";
                BufferedWriter writer = new BufferedWriter(new FileWriter(config));
                writer.write(def);
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        midiHandler = new MIDIHandler();
        sampleHandler = new SampleHandler();
    }

    public ConfigHandler(String path) {
        config = new File(path);
    }

    private List<Object> parseLine(String buttonID, String line) {
        List<Object> config = new ArrayList<>();
        config.add(buttonID);
        if(line.charAt(0) == '\"') {
            config.add(this.sampleHandler);
            String[] lineParse = line.substring(1).split("\"");
            config.add(lineParse[0]);
            config.add(Float.parseFloat(lineParse[1]));
        } else {
            config.add(this.midiHandler);
            String[] lineParse = line.split(",", 0);
            if(lineParse.length > 1) {
                config.add(Short.parseShort(lineParse[0]));
                config.add(Short.parseShort(lineParse[1]));
            } else {
                config.add(Short.parseShort(lineParse[0]));
            }
        }

        return config;
    }

    public List<List<List<Object>>> loadConfig() {
        final short matrixSize = 4;
        List<List<List<Object>>> config = new ArrayList<>();
        for(int i = 0; i < matrixSize; i++) {
            config.add(new ArrayList<>());
        }
        String line;
        boolean comment = false;

        try {
            FileReader fileReader = new FileReader(this.config);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(line.equals("/*")) comment = true;
                else if(line.equals("*/")) comment = false;
                else if(comment == false && line.length() > 4) {
                    String[] message = line.split(":");
                    message[1] = Character.toString(message[0].charAt(2));
                    message[0] = Character.toString(message[0].charAt(0));
                    config.get(Short.parseShort(message[0])).add(Short.parseShort(message[1]),
                            parseLine(line.split(":")[0], line.split(":")[1]));
                }
            }
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {ex.printStackTrace();}
        catch(IOException ex) {ex.printStackTrace();}

        return config;
    }

}

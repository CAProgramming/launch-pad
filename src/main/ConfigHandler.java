package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigHandler {
    private File config;
    private MIDIHandler midiHandler;
    private SampleHandler sampleHandler;

    public ConfigHandler() {
        config = new File("src/config.txt");
        midiHandler = new MIDIHandler();
        sampleHandler = new SampleHandler();
    }

    public ConfigHandler(String path) {
        config = new File(path);
    }

    private List<Object> parseLine(String line) {
        List<Object> config = new ArrayList<>();
        if(line.charAt(0) == '\"') {
            config.add(this.sampleHandler);
            line = line.replace("\"", "");
            config.add(line);
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
                            parseLine(line.split(":")[1]));
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

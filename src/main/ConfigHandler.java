package main;

import java.io.*;

public class ConfigHandler {
    private File config;

    public ConfigHandler() {
        config = new File("src/config.txt");
    }

    public ConfigHandler(String path) {
        config = new File(path);
    }

    private PlayableButton parseLine(String line) {
        PlayableButton config;

        return config;
    }

    public PlayableButton[][] loadConfig() {
        final short matrixSize = 4;
        PlayableButton[][] config = new PlayableButton[matrixSize][matrixSize];
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
                    message = message[0].split(".");
                    config[Short.parseShort(message[0])][Short.parseShort(message[1])] =
                            parseLine(line.split(":")[1]);
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

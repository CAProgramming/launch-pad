package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SampleHandler implements Handler<Object> {
    private Map<String, Thread> threads;

    public SampleHandler() {
        super();
        threads = new HashMap<>();
    }

    public List<String> getPlayingSamples(){
        List<String> playingSamples = new ArrayList<>();
        playingSamples.addAll(threads.keySet());
        return playingSamples;
    }

    @Override
    public void play(Map<String, Object> params) {
        if (!params.isEmpty() && params.size() == 3 && !threads.containsKey(params.get("buttonID"))) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                new File((String) params.get("filepath")));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);

                        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                        gainControl.setValue((float) params.get("gain"));

                        long duration = clip.getMicrosecondLength() / 1000;
                        final int interval = 500;

                        while(true) {
                            clip.setFramePosition(0);
                            clip.start();

                            for (long ts = 0; ts < duration; ts += interval) {
                                try {
                                    Thread.sleep(interval);
                                } catch (InterruptedException e) {
                                    System.out.println("Sound-playing thread interrupted.");
                                    clip.stop();
                                    return;
                                }
                            }
                        }
                    } catch (UnsupportedAudioFileException e) {
                        System.out.println("Unsupported audio format.");
                    } catch (LineUnavailableException e) {
                        System.err.println(e.getMessage());
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            };

            threads.put((String) params.get("buttonID"), new Thread(runnable, "playingThread"));
            threads.get(params.get("buttonID")).start();
        } else {
            System.out.println("Parameters were not usable.");
        }

    }

    @Override
    public void stop(Map<String, Object> params) {
        threads.get(params.get("buttonID")).interrupt();
        threads.remove(params.get("buttonID"));
    }

//    //**************************************
//    public static void main(String[] args) throws Exception {
//        SampleHandler test1 = new SampleHandler();
//        Map<String, String> params = new HashMap<>();
//        params.put("filepath", "./resources/test.wav");
//        params.put("gain", Float.toString((float) 5.0));
//        params.put("buttonID", "1");
//        test1.play(params);
//        test1.stop(params);
//    }
}
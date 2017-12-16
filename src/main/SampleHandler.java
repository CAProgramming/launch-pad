package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SampleHandler implements Handler<String> {
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
    public void play(Map<String, String> params) {
        if (!params.isEmpty() && params.size() == 3 && !threads.containsKey(params.get("button_id"))) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(params.get("filepath")));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.setFramePosition(0);

                        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                        gainControl.setValue(Float.parseFloat(params.get("gain")));

                        long duration = clip.getMicrosecondLength() / 1000;
                        final int interval = 500;

                        clip.start();

                        for (long ts = 0; ts < duration; ts += interval) {
                            if (Thread.currentThread().isInterrupted()) {
                                clip.stop();
                                return;
                            }
                            try {
                                Thread.sleep(interval);
                            } catch (InterruptedException e) {
                                System.out.println("Sound-playing thread interrupted.");
                            }
                        }
                        return;
                    } catch (UnsupportedAudioFileException e) {
                        System.out.println("Unsupported audio format.");
                    } catch (LineUnavailableException e) {
                        System.err.println(e.getMessage());
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            };

            threads.put(params.get("button_id"), new Thread(runnable, "playingThread"));
            threads.get(params.get("button_id")).start();
        } else {
            System.out.println("Parameters were not usable.");
        }

    }

    @Override
    public void stop(Map<String, String> params) {
        threads.get(params.get("button_id")).interrupt();
    }

//    //**************************************
//    public static void main(String[] args) throws Exception {
//        SampleHandler test1 = new SampleHandler();
//        Map<String, String> params = new HashMap<>();
//        params.put("filepath", "./resources/test.wav");
//        params.put("gain", Float.toString((float) 5.0));
//        params.put("button_id", "1");
//        test1.play(params);
//        test1.stop(params);
//    }
}
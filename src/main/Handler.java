package main;

import java.util.Map;

public interface Handler<N> {
    void play(Map<String, N> param);
    void stop(Map<String, N> param);
}

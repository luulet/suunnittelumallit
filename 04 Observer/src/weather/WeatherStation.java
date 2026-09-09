package weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {

    private static final int MIN_TEMPERATURE = -20;
    private static final int MAX_TEMPERATURE = 40;

    private final List<WeatherObserver> observers = new ArrayList<>();
    private final Random random = new Random();

    private int temperature;
    private volatile boolean running = true;

    public WeatherStation() {
        temperature = MIN_TEMPERATURE + random.nextInt(MAX_TEMPERATURE - MIN_TEMPERATURE + 1);
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    public void stopStation() {
        running = false;
        interrupt();
    }

    @Override
    public void run() {
        while (running) {
            int change = random.nextBoolean() ? 1 : -1;
            temperature += change;
            if (temperature > MAX_TEMPERATURE) {
                temperature = MAX_TEMPERATURE;
            } else if (temperature < MIN_TEMPERATURE) {
                temperature = MIN_TEMPERATURE;
            }

            notifyObservers();

            try {
                int delay = 1000 + random.nextInt(4000);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

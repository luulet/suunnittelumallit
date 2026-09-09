package weather;

public class DisplayObserver implements WeatherObserver {

    private final String name;

    public DisplayObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " says: Current temperature is " + temperature + " degrees.");
    }
}

package rpg;

public class CityGame extends Game {
    @Override
    public Map createMap(int width, int height) {
        return new CityMap(width, height);
    }
}


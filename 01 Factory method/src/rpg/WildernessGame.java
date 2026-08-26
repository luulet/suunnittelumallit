package rpg;

public class WildernessGame extends Game {
    @Override
    public Map createMap(int width, int height) {
        return new WildernessMap(width, height);
    }
}


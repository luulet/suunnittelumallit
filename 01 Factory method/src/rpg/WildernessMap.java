package rpg;

import java.util.Random;

public class WildernessMap extends Map {

    private static final Random RANDOM = new Random();

    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        int choice = RANDOM.nextInt(3);
        switch (choice) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            default:
                return new ForestTile();
        }
    }
}


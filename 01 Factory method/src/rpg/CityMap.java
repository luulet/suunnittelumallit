package rpg;

import java.util.Random;

public class CityMap extends Map {

    private static final Random RANDOM = new Random();

    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        int choice = RANDOM.nextInt(3);
        switch (choice) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            default:
                return new BuildingTile();
        }
    }
}


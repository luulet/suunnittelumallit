package rpg;

public abstract class Map {

    private final int width;
    private final int height;
    private final Tile[][] tiles;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
        generate();
    }

    private void generate() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = createTile();
            }
        }
    }

    public abstract Tile createTile();

    public void display() {
        printLegend();
        for (int y = 0; y < height; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < width; x++) {
                row.append(tiles[y][x].getCharacter());
            }
            System.out.println(row);
        }
    }

    private void printLegend() {
        java.util.Map<Character, String> legend = new java.util.LinkedHashMap<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Tile tile = tiles[y][x];
                legend.putIfAbsent(tile.getCharacter(), tile.getType());
            }
        }
        System.out.println("Legend:");
        for (java.util.Map.Entry<Character, String> entry : legend.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}


package rpg;

public class WaterTile extends Tile {
    public char getCharacter() { return 'W'; }
    public String getType() { return "water"; }
    public void action() { System.out.println("You wade through the water."); }
}


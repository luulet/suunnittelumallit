package rpg;

public class ForestTile extends Tile {
    public char getCharacter() { return 'F'; }
    public String getType() { return "forest"; }
    public void action() { System.out.println("You wander through the forest."); }
}


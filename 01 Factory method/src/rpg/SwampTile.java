package rpg;

public class SwampTile extends Tile {
    public char getCharacter() { return 'S'; }
    public String getType() { return "swamp"; }
    public void action() { System.out.println("You trudge through the murky swamp."); }
}


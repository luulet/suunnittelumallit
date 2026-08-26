package rpg;

public class RoadTile extends Tile {
    public char getCharacter() { return 'R'; }
    public String getType() { return "road"; }
    public void action() { System.out.println("You walk along the road."); }
}


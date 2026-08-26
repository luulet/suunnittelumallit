package rpg;

public abstract class Game {

    public void play(int width, int height) {
        Map map = createMap(width, height);
        map.display();
    }

    public abstract Map createMap(int width, int height);

    public static void main(String[] args) {
        Game game = new CityGame();
        game.play(10, 10);

        System.out.println();

        game = new WildernessGame();
        game.play(10, 10);
    }
}


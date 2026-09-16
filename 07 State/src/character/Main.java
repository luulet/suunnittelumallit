package character;

public class Main {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter("Hero");

        while (!character.isGameOver()) {
            character.displayStatus();
            character.takeTurn();
        }

        character.displayStatus();
    }
}


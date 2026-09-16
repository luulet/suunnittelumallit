package character;

public class MasterState extends CharacterState {

    public MasterState(GameCharacter character) {
        super(character);
    }

    public String getLevelName() {
        return "Master";
    }

    public String[] getAvailableActions() {
        return new String[0];
    }

    protected void handleAction(int choice) {
        // No actions available at the Master level, the game has ended.
    }

    public void performAction() {
        System.out.println(getCharacter().getName() + " has reached the Master level. The game is over!");
    }
}


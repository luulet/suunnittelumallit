package character;

import java.util.Scanner;

public abstract class CharacterState {
    private static Scanner scanner = new Scanner(System.in);
    private GameCharacter character;

    public CharacterState(GameCharacter character) {
        this.character = character;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public abstract String getLevelName();

    public abstract String[] getAvailableActions();

    public void performAction() {
        String[] options = getAvailableActions();
        System.out.println("\nAvailable actions:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i - 1]);
        }
        System.out.print("Choose an action: ");
        int choice = scanner.nextInt();
        handleAction(choice);
    }

    protected abstract void handleAction(int choice);

    public void train() {
        System.out.println("This action is not available at the " + getLevelName() + " level.");
    }

    public void meditate() {
        System.out.println("This action is not available at the " + getLevelName() + " level.");
    }

    public void fight() {
        System.out.println("This action is not available at the " + getLevelName() + " level.");
    }
}


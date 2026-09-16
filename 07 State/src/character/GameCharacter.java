package character;

public class GameCharacter {
    private String name;
    private int experiencePoints = 0;
    private int healthPoints = 100;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.state = new NoviceState(this);
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return state.getLevelName();
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void addExperience(int amount) {
        experiencePoints += amount;
        System.out.println(name + " gained " + amount + " experience points. (Total: " + experiencePoints + ")");
    }

    public void addHealth(int amount) {
        healthPoints += amount;
        System.out.println(name + " gained " + amount + " health points. (Total: " + healthPoints + ")");
    }

    public void reduceHealth(int amount) {
        healthPoints -= amount;
        System.out.println(name + " lost " + amount + " health points. (Total: " + healthPoints + ")");
    }

    public void displayStatus() {
        System.out.println("\n----------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Level: " + state.getLevelName());
        System.out.println("Experience points: " + experiencePoints);
        System.out.println("Health points: " + healthPoints);
        System.out.println("----------------------------------------");
    }

    public boolean isGameOver() {
        return state instanceof MasterState;
    }

    public void takeTurn() {
        state.performAction();
    }
}


package character;

public class ExpertState extends CharacterState {

    final int EXPERIENCE_TO_ADVANCE = 130;
    final int TRAIN_EXPERIENCE_GAIN = 10;
    final int MEDITATE_HEALTH_GAIN = 10;
    final int FIGHT_EXPERIENCE_GAIN = 20;
    final int FIGHT_HEALTH_LOSS = 15;

    public ExpertState(GameCharacter character) {
        super(character);
    }

    public String getLevelName() {
        return "Expert";
    }

    public String[] getAvailableActions() {
        return new String[]{"Train", "Meditate", "Fight"};
    }

    protected void handleAction(int choice) {
        switch (choice) {
            case 1:
                train();
                break;
            case 2:
                meditate();
                break;
            case 3:
                fight();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public void train() {
        getCharacter().addExperience(TRAIN_EXPERIENCE_GAIN);
        checkAdvance();
    }

    public void meditate() {
        getCharacter().addHealth(MEDITATE_HEALTH_GAIN);
    }

    public void fight() {
        getCharacter().reduceHealth(FIGHT_HEALTH_LOSS);
        getCharacter().addExperience(FIGHT_EXPERIENCE_GAIN);
        checkAdvance();
    }

    private void checkAdvance() {
        if (getCharacter().getExperiencePoints() >= EXPERIENCE_TO_ADVANCE) {
            System.out.println(getCharacter().getName() + " advanced to the Master level!");
            getCharacter().setState(new MasterState(getCharacter()));
        }
    }
}


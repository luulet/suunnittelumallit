package character;

public class IntermediateState extends CharacterState {

    final int EXPERIENCE_TO_ADVANCE = 70;
    final int TRAIN_EXPERIENCE_GAIN = 10;
    final int MEDITATE_HEALTH_GAIN = 10;

    public IntermediateState(GameCharacter character) {
        super(character);
    }

    public String getLevelName() {
        return "Intermediate";
    }

    public String[] getAvailableActions() {
        return new String[]{"Train", "Meditate"};
    }

    protected void handleAction(int choice) {
        switch (choice) {
            case 1:
                train();
                break;
            case 2:
                meditate();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public void train() {
        getCharacter().addExperience(TRAIN_EXPERIENCE_GAIN);
        if (getCharacter().getExperiencePoints() >= EXPERIENCE_TO_ADVANCE) {
            System.out.println(getCharacter().getName() + " advanced to the Expert level!");
            getCharacter().setState(new ExpertState(getCharacter()));
        }
    }

    public void meditate() {
        getCharacter().addHealth(MEDITATE_HEALTH_GAIN);
    }
}


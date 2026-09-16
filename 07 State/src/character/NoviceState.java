package character;

public class NoviceState extends CharacterState {

    final int EXPERIENCE_TO_ADVANCE = 30;
    final int TRAIN_EXPERIENCE_GAIN = 10;

    public NoviceState(GameCharacter character) {
        super(character);
    }

    public String getLevelName() {
        return "Novice";
    }

    public String[] getAvailableActions() {
        return new String[]{"Train"};
    }

    protected void handleAction(int choice) {
        switch (choice) {
            case 1:
                train();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public void train() {
        getCharacter().addExperience(TRAIN_EXPERIENCE_GAIN);
        if (getCharacter().getExperiencePoints() >= EXPERIENCE_TO_ADVANCE) {
            System.out.println(getCharacter().getName() + " advanced to the Intermediate level!");
            getCharacter().setState(new IntermediateState(getCharacter()));
        }
    }
}


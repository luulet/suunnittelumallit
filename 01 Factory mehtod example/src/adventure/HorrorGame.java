package adventure;

public class HorrorGame extends Game {
    @Override
    public Room createRoom() {
        return new ScaryRoom();
    }
}
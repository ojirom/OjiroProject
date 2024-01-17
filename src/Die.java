public class Die {
    private int roll;

    public Die() {
        roll = 0;
    }

    public int getRoll() {
        return roll;
    }

    public void rollDie() {
        roll = (int) (Math.random() * 7);
    }
}

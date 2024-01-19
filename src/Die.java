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

    public static void results(Player player, Die die1, Die die2, Die die3) {
        int roll1 = die1.getRoll();
        int roll2 = die2.getRoll();
        int roll3 = die3.getRoll();
        while (!player.isRoundWin()) {
            die1.rollDie();
            die2.rollDie();
            die3.rollDie();
            if ((roll1 == roll2 && roll1 == roll3) || die1.getRoll() * die2.getRoll() * die3.getRoll() == 120) {
                player.setRoundWin(true);
            }
            if ((die1.getRoll() * die2.getRoll() * die3.getRoll() == 6) && (die1.getRoll() + die2.getRoll() + die3.getRoll() == 6)) {
                break;
            }
        }
    }
}

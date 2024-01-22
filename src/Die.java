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

    public static boolean results(int score, Die die1, Die die2, Die die3) {
        int roll1 = die1.getRoll();
        int roll2 = die2.getRoll();
        int roll3 = die3.getRoll();
        while (true) {
            die1.rollDie();
            die2.rollDie();
            die3.rollDie();
            //win condition
            if ((roll1 == roll2 && roll1 == roll3) || die1.getRoll() * die2.getRoll() * die3.getRoll() == 120) {
                return true;
            //lose condition
            } else if ((roll1 * roll2 * roll3 == 6) && (roll1 + roll2 + roll3 == 6)) {
                return false;
            //score
            } else if ((roll1 == roll2) || (roll1 == roll3) || (roll2 == roll3)) {
                if (score > 0) {
                    return roll1 + roll2 + roll3 > score;
                }
                return false;
            }
        }
    }
}

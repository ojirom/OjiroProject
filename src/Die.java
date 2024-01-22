public class Die {
    private int roll;

    public Die() {
        roll = 0;
    }

    public int getRoll() {
        return roll;
    }

    public void rollDie() {
        roll = (int) (Math.random() * 6) + 1;
    }

    public static boolean results(int score, Die die1, Die die2, Die die3) {
        while (true) {
            die1.rollDie();
            die2.rollDie();
            die3.rollDie();
            int roll1 = die1.getRoll();
            int roll2 = die2.getRoll();
            int roll3 = die3.getRoll();
            System.out.println("[" + ConsoleUtility.CYAN + roll1 + ConsoleUtility.RESET + "]" + "[" + ConsoleUtility.CYAN + roll2 + ConsoleUtility.RESET + "]" + "[" + ConsoleUtility.CYAN + roll3 + ConsoleUtility.RESET + "]");
            ConsoleUtility.sleep(200);
            int pScore = 0;
            //win condition
            if ((roll1 == roll2 && roll1 == roll3) || die1.getRoll() * die2.getRoll() * die3.getRoll() == 120) {
                return true;
            //lose condition
            } else if ((roll1 * roll2 * roll3 == 6) && (roll1 + roll2 + roll3 == 6)) {
                return false;
            //score
            } else if ((roll1 == roll2) || (roll1 == roll3) || (roll2 == roll3)) {
                if (score > 0) {
                    if (roll1 == roll2) {
                        pScore = roll3;
                    }
                    if (roll1 == roll3) {
                        pScore = roll2;
                    }
                    if (roll2 == roll3) {
                        pScore = roll1;
                    }
                    return pScore >= score;
                }
                return false;
            }
        }
    }
}

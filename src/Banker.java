public class Banker {
    private int chips;
    private int score;
    private Die die1;
    private Die die2;
    private Die die3;

    public Banker() {
        chips = 1000;
        score = 0;
        die1 = new Die();
        die2 = new Die();
        die3 = new Die();
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getScore() {
        return score;
    }

    public boolean rollDice(Player p1, Player p2, Player p3) {
        score = 0;
        System.out.println("The banker rolls the dice...");
        ConsoleUtility.sleep(1000);
        boolean result = Die.results(0, die1, die2, die3);
        int roll1 = die1.getRoll();
        int roll2 = die2.getRoll();
        int roll3 = die3.getRoll();
        if (roll1 == roll2) {
            score = roll3;
        }
        if (roll1 == roll3) {
            score = roll2;
        }
        if (roll2 == roll3) {
            score = roll1;
        }
        ConsoleUtility.sleep(500);
        if (result) {
            System.out.println("The banker " + ConsoleUtility.GREEN + "wins" + ConsoleUtility.RESET + " the round!");
            chips += p1.getWager() + p2.getWager() + p3.getWager();
            p1.setChips(p1.getChips() - p1.getWager());
            p2.setChips(p2.getChips() - p2.getWager());
            p3.setChips(p3.getChips() - p3.getWager());
            if (p1.getChips() <= 0) {
                p1.setInGame(false);
                p1.setChips(0);
                p1.setWager(0);
            }
            if (p2.getChips() <= 0) {
                p2.setInGame(false);
                p2.setChips(0);
                p1.setWager(0);
            }
            if (p3.getChips() <= 0) {
                p3.setInGame(false);
                p3.setChips(0);
                p1.setWager(0);
            }
        } else if ((roll1 * roll2 * roll3 == 6) && (roll1 + roll2 + roll3 == 6)) {
            System.out.println("The banker " + ConsoleUtility.RED + "loses" + ConsoleUtility.RESET + " the round!");
            chips -= p1.getWager() + p2.getWager() + p3.getWager();
            p1.setChips(p1.getChips() + p1.getWager());
            p2.setChips(p2.getChips() + p2.getWager());
            p3.setChips(p3.getChips() + p3.getWager());
            result = true;
        } else {
            System.out.println("SCORE: " + ConsoleUtility.CYAN + score + ConsoleUtility.RESET);
        }
        ConsoleUtility.sleep(3000);
        ConsoleUtility.clearScreen();
        return result;
    }
}

public class Player {
    private int chips;
    private String name;
    private int score;
    private int wager;
    private boolean inGame;
    private boolean roundWin;

    public Player(String name) {
        this.name = name;
        chips = 100;
        score = 0;
        wager = 0;
        inGame = true;
        roundWin = false;
    }

    public int getChips() {
        return chips;
    }

    public int getScore() {
        return score;
    }

    public int getWager() {
        return wager;
    }

    public String getName() {
        return name;
    }

    public boolean isInGame() {
        return inGame;
    }

    public boolean isRoundWin() {
        return roundWin;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }

    public void setRoundWin(boolean roundWin) {
        this.roundWin = roundWin;
    }

    public void rollDice() {
        if (inGame) {
            Die die1 = new Die();
            int roll1 = die1.getRoll();
            Die die2 = new Die();
            int roll2 = die2.getRoll();
            Die die3 = new Die();
            int roll3 = die3.getRoll();
            Die.results(, die1, die2, die3);
            if (chips <= 0) {
                inGame = false;
            }
        }
    }
}

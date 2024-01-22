public class Player {
    private int chips;
    private String name;
    private int score;
    private int wager;
    private boolean inGame;
    private boolean roundWin;
    private Die die1;
    private Die die2;
    private Die die3;

    public Player(String name) {
        this.name = name;
        chips = 100;
        score = 0;
        wager = 0;
        inGame = true;
        roundWin = false;
        die1 = new Die();
        die2 = new Die();
        die3 = new Die();
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

    public Die getDie1() {
        return die1;
    }

    public Die getDie2() {
        return die2;
    }

    public Die getDie3() {
        return die3;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }

    public void setRoundWin(boolean roundWin) {
        this.roundWin = roundWin;
    }

    public boolean rollDice(Banker banker) {
        int roll1 = die1.getRoll();
        int roll2 = die2.getRoll();
        int roll3 = die3.getRoll();
        boolean result = Die.results(banker.getChips(), die1, die2, die3);
        score = roll1 + roll2 + roll3;
        if (chips <= 0) {
            inGame = false;
        }
        return result;
    }

    public void takeTurn(Banker banker) {
        if (inGame) {
            if (rollDice(banker)) {
                chips += wager;
                banker.setChips(banker.getChips() - wager);
            } else {
                chips -= wager;
                banker.setChips(banker.getChips() + wager);
            }
        }
    }
}

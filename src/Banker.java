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

    public int getScore() {
        return score;
    }

    public void rollDice() {
        int roll1 = die1.getRoll();
        int roll2 = die2.getRoll();
        int roll3 = die3.getRoll();
        Die.results(0, die1, die2, die3);
        score = roll1 + roll2 + roll3;
    }
}

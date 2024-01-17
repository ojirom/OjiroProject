public class Player {
    private int chips;
    private String name;
    private int score;
    private int wager;
    private boolean inGame;

    public Player(String name) {
        this.name = name;
        chips = 100;
        score = 0;
        wager = 0;
        inGame = true;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }

    public void rollDice() {
        if (inGame) {
            Die die1 = new Die();
            die1.rollDie();
            int roll1 = die1.getRoll();
            Die die2 = new Die();
            die2.rollDie();
            int roll2 = die2.getRoll();
            Die die3 = new Die();
            die3.rollDie();
            int roll3 = die3.getRoll();
            if (roll1 == roll2 && roll1 == roll3) {

            }
            if (chips <= 0) {
                inGame = false;
            }
        }
    }
}

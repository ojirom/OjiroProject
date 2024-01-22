import java.util.Scanner;
public class Player {
    private int chips;
    private String name;
    private int score;
    private int wager;
    private boolean inGame;
    private Die die1;
    private Die die2;
    private Die die3;

    public Player(String name) {
        this.name = name;
        chips = 100;
        score = 0;
        wager = 0;
        inGame = true;
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

    public void setChips(int chips) {
        this.chips = chips;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public void setWager(Scanner scan) {
        while (inGame) {
            System.out.print("(" + ConsoleUtility.YELLOW + chips + ConsoleUtility.RESET + ") " + name + "'s wager: ");
            int wage = scan.nextInt();
            if ((wage <= chips) && wage >= 0) {
                wager = wage;
                break;
            }
        }
    }

    public boolean rollDice(Banker banker) {
        score = 0;
        System.out.println(name + " rolls the dice...");
        ConsoleUtility.sleep(1000);
        boolean result = Die.results(banker.getScore(), die1, die2, die3);
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
        return result;
    }

    public void takeTurn(Banker banker) {
        if (inGame) {
            if (rollDice(banker)) {
                chips += wager;
                banker.setChips(banker.getChips() - wager);
                System.out.println(name + ConsoleUtility.GREEN + " wins " + ConsoleUtility.RESET + ConsoleUtility.YELLOW + wager + ConsoleUtility.RESET + " chips!");
            } else {
                chips -= wager;
                banker.setChips(banker.getChips() + wager);
                System.out.println(name + ConsoleUtility.RED + " loses " + ConsoleUtility.RESET + ConsoleUtility.YELLOW + wager + ConsoleUtility.RESET + " chips!");
            }
            ConsoleUtility.sleep(200);
            System.out.println(name + " now has " + ConsoleUtility.YELLOW + chips + ConsoleUtility.RESET + " chips\n");
            ConsoleUtility.sleep(3000);
            ConsoleUtility.clearScreen();
            if (chips <= 0) {
                inGame = false;
                chips = 0;
                wager = 0;
            }
        }
    }
}

import java.util.Scanner;
public class Ceelo {
    public Ceelo() {

    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.print("Enter Player 1 name: ");
        String name1 = scan.nextLine();
        Player p1 = new Player(name1);
        System.out.print("Enter Player 2 name: ");
        String name2 = scan.nextLine();
        Player p2 = new Player(name2);
        System.out.print("Enter Player 3 name: ");
        String name3 = scan.nextLine();
        Player p3 = new Player(name3);
        Banker banker = new Banker();
        int round = 0;
        while (banker.getChips() > 0 || (p1.isInGame() && p2.isInGame() && p3.isInGame())) {
            System.out.println("ROUND " + round);
            //wagers
            System.out.print(p1.getName() + "'s wager: ");
            int wager1 = scan.nextInt();
            p1.setWager(wager1);
            System.out.print(p2.getName() + "'s wager: ");
            int wager2 = scan.nextInt();
            p1.setWager(wager2);
            System.out.print(p3.getName() + "'s wager: ");
            int wager3 = scan.nextInt();
            p1.setWager(wager3);
            //round start - roll die
            System.out.println("The banker rolls the dice...");
            banker.rollDice();
            System.out.println("[" + banker.getDie1().getRoll() + "]" + "[" + banker.getDie2().getRoll() + "]" + "[" + banker.getDie3().getRoll() + "]");
            System.out.println(name1 + " rolls the dice...");
            p1.takeTurn(banker);
            System.out.println("[" + p1.getDie1().getRoll() + "]" + "[" + p1.getDie2().getRoll() + "]" + "[" + p1.getDie3().getRoll() + "]");
            System.out.println(name1 + " now has " + p1.getChips() + " chips");
            System.out.println(name2 + " rolls the dice...");
            p2.takeTurn(banker);
            System.out.println("[" + p2.getDie1().getRoll() + "]" + "[" + p2.getDie2().getRoll() + "]" + "[" + p2.getDie3().getRoll() + "]");
            System.out.println(name2 + " now has " + p2.getChips() + " chips");
            System.out.println(name3 + " rolls the dice...");
            p3.takeTurn(banker);
            System.out.println("[" + p3.getDie1().getRoll() + "]" + "[" + p3.getDie2().getRoll() + "]" + "[" + p3.getDie3().getRoll() + "]");
            System.out.println(name3 + " now has " + p3.getChips() + " chips");
            round++;
        }
    }
}
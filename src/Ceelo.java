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
            System.out.print(p1.getName() + "'s wager: ");
            int wager1 = scan.nextInt();
            p1.setWager(wager1);
            System.out.print(p2.getName() + "'s wager: ");
            int wager2 = scan.nextInt();
            p1.setWager(wager2);
            System.out.print(p3.getName() + "'s wager: ");
            int wager3 = scan.nextInt();
            p1.setWager(wager3);
            round++;
            banker.rollDice();

        }
    }
}

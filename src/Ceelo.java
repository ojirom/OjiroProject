import java.util.Scanner;
public class Ceelo {
    public Ceelo() {

    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        ConsoleUtility.clearScreen();
        System.out.println(ConsoleUtility.PURPLE + "WELCOME TO CEELO" + ConsoleUtility.RESET);
        System.out.print("Enter Player 1 name: ");
        String name1 = scan.nextLine();
        System.out.print("Enter Player 2 name: ");
        String name2 = scan.nextLine();
        System.out.print("Enter Player 3 name: ");
        String name3 = scan.nextLine();
        String play = "y";
        int topScore = 0;
        ConsoleUtility.clearScreen();
        //game start
        while (play.equals("y")) {
            Player p1 = new Player(name1);
            Player p2 = new Player(name2);
            Player p3 = new Player(name3);
            Banker banker = new Banker();
            int round = 1;
            while (banker.getChips() > 0 && (p1.isInGame() || p2.isInGame() || p3.isInGame())) {
                System.out.println(ConsoleUtility.PURPLE + "ROUND " + round + ConsoleUtility.RESET + " - (" + ConsoleUtility.YELLOW + banker.getChips() + ConsoleUtility.RESET + ")");
                //wagers
                p1.setWager(scan);
                p2.setWager(scan);
                p3.setWager(scan);
                play = scan.nextLine();
                ConsoleUtility.clearScreen();
                //round start - roll die
                if (!banker.rollDice(p1, p2, p3)) {
                    p1.takeTurn(banker);
                    p2.takeTurn(banker);
                    p3.takeTurn(banker);
                }
                round++;
            //game end
            }
            if ((p1.getChips() > p2.getChips()) || (p1.getChips() > p3.getChips())) {
                if ((p1.getChips() > p2.getChips()) && (p1.getChips() > p3.getChips())) {
                    System.out.println(ConsoleUtility.PURPLE + name1 + " WINS!" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p1.getChips() + ConsoleUtility.RESET + ")");
                } else if (p1.getChips() > p2.getChips()) {
                    System.out.println(ConsoleUtility.PURPLE + name1 + " AND " + name3 + " TIE" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p1.getChips() + ConsoleUtility.RESET + ")");
                } else {
                    System.out.println(ConsoleUtility.PURPLE + name1 + " AND " + name2 + " TIE" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p1.getChips() + ConsoleUtility.RESET + ")");
                }
                topScore = p1.getChips();
            } else if ((p2.getChips() > p1.getChips()) || (p2.getChips() > p3.getChips())) {
                if ((p2.getChips() > p1.getChips()) && (p2.getChips() > p3.getChips())) {
                    System.out.println(ConsoleUtility.PURPLE + name2 + " WINS!" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p2.getChips() + ConsoleUtility.RESET + ")");
                } else if (p2.getChips() > p1.getChips()) {
                    System.out.println(ConsoleUtility.PURPLE + name2 + " AND " + name3 + " TIE" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p2.getChips() + ConsoleUtility.RESET + ")");
                } else {
                    System.out.println(ConsoleUtility.PURPLE + name2 + " AND " + name1 + " TIE" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p2.getChips() + ConsoleUtility.RESET + ")");
                }
                topScore = p2.getChips();
            } else if ((p3.getChips() > p2.getChips()) || (p3.getChips() > p1.getChips())) {
                if ((p3.getChips() > p2.getChips()) && (p3.getChips() > p1.getChips())) {
                    System.out.println(ConsoleUtility.PURPLE + name3 + " WINS!" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p3.getChips() + ConsoleUtility.RESET + ")");
                } else if (p3.getChips() > p2.getChips()) {
                    System.out.println(ConsoleUtility.PURPLE + name3 + " AND " + name1 + " TIE" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p3.getChips() + ConsoleUtility.RESET + ")");
                } else {
                    System.out.println(ConsoleUtility.PURPLE + name3 + " AND " + name2 + " TIE" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p3.getChips() + ConsoleUtility.RESET + ")");
                }
                topScore = p3.getChips();
            } else if (p1.getChips() + p2.getChips() + p3.getChips() == 0) {
                System.out.println(ConsoleUtility.RED + "THE BANKER WINS!" + ConsoleUtility.RESET+ " (" + ConsoleUtility.YELLOW + banker.getChips() + ConsoleUtility.RESET + ")");
            } else {
                System.out.println(ConsoleUtility.PURPLE + "ALL PLAYERS TIE" + ConsoleUtility.RESET + " (" + ConsoleUtility.YELLOW + p1.getChips() + ConsoleUtility.RESET + ")");
            }
            System.out.println("\nTop Score: " + ConsoleUtility.CYAN + topScore + ConsoleUtility.RESET);
            System.out.print("Play again? (y/n): ");
            play = scan.nextLine();
            ConsoleUtility.clearScreen();
        }
    }
}
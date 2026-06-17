package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.MathGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("""
                Please enter a game number and press Enter.\s
                1 - Greet\s
                2 - Even\s
                3 - Calc\s
                4 - GCD\s
                5 - Progression\s
                6 - Prime\s
                0 - Exit""");
        String userChoice = scanner.nextLine();
        System.out.println("Your choice: " + userChoice);

        switch (userChoice) {
            case "1":
                Cli.helloUser();
                break;
            case "0":
                System.exit(0);
                break;
            case "2":
                EvenGame.evenGameMain();
                break;
            case "3":
                MathGame.mathGameMain();
                break;
            case "4":
                GCDGame.gcdGameMain();
                break;
            case "5":
                ProgressionGame.progressionMain();
                break;
            case "6":
                PrimeGame.primeMain();
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }
}

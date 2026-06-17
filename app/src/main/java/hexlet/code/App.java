package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.GreetGame;
import hexlet.code.games.MathGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                GreetGame.run();
            case "0":
                System.out.println("See you later!");
            case "2":
                EvenGame.evenGameMain();
            case "3":
                MathGame.mathGameMain();
            case "4":
                GCDGame.gcdGameMain();
            case "5":
                ProgressionGame.progressionMain();
            case "6":
                PrimeGame.primeMain();
            default:
                System.out.println("Invalid input.");
        }
        scanner.close();
    }
}

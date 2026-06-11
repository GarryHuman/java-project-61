package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PrimeGame {
    public static void primeMain() {
        var index = 0;
        var userName = Cli.helloUser();

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (index < 3) {
            askQuestion(userName);
            index++;
        }
        System.out.println("Congratulations, " + userName + "!");
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void askQuestion(String userName) {
        Scanner scanner = new Scanner(System.in);

        int puzzleNumber = ThreadLocalRandom.current().nextInt(100);
        boolean primeStatus = isPrime(puzzleNumber);

        System.out.println("Question: " +  puzzleNumber);
        String userChoice = scanner.nextLine();

        if (userChoice.equals("yes") && (primeStatus)) {
            System.out.println("Correct!");
        } else if (userChoice.equals("no") && (!primeStatus)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong answer.");
            System.out.println("Let's try again, " + userName);
            System.exit(0);
        }
    }
}

package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.concurrent.ThreadLocalRandom;

public class EvenGame {
    public static void evenGameMain() {
        var index = 0;
        var userName = Cli.helloUser();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (index < 3) {
            askQuestion();
            index++;
        }
        System.out.println("Congratulations, " + userName + "!");

    }
    public static void askQuestion() {
        Scanner scanner = new Scanner(System.in);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        int randomBounded = ThreadLocalRandom.current().nextInt(100);
        System.out.println("Question: " +  randomBounded);
        System.out.println("Your answer: ");
        String userChoice = scanner.nextLine();
        if (userChoice.equals("yes") && (isEven.test(randomBounded))) {
            System.out.println("Correct!");
        } else if (userChoice.equals("no") && (!isEven.test(randomBounded))) {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong answer.");
            System.exit(0);
        }
    }
}

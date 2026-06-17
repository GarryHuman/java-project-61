package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MathGame {
    public static void mathGameMain() {
        var index = 0;
        var userName = Cli.helloUser();

        System.out.println("What is the result of the expression?");

        while (index < 3) {
            askQuestion(userName);
            index++;
        }
        System.out.println("Congratulations, " + userName + "!");
    }
    public static void askQuestion(String userName) {
        Scanner scanner = new Scanner(System.in);
        String firstInteger = Integer.toString(ThreadLocalRandom.current().nextInt(100));
        String secondInteger = Integer.toString(ThreadLocalRandom.current().nextInt(100));
        int answer = 0;
        String[] mathOperantChoices = {"*", "+", "-"};
        int mathOperantIndex = ThreadLocalRandom.current().nextInt(3);
        String mathOperant = mathOperantChoices[mathOperantIndex];

        switch (mathOperant) {
            case "*":
                answer = Integer.parseInt(firstInteger) * Integer.parseInt(secondInteger);
                System.out.println("Question: " + firstInteger + " * " + secondInteger);
                break;
            case "+":
                answer = Integer.parseInt(firstInteger) * Integer.parseInt(secondInteger);
                System.out.println("Question: " + firstInteger + " + " + secondInteger);
                break;
            case  "-":
                answer = Integer.parseInt(firstInteger) * Integer.parseInt(secondInteger);
                System.out.println("Question: " + firstInteger + " - " + secondInteger);
                break;
            default:
                break;
        }
        System.out.println("Your answer: ");
        String userChoice = scanner.nextLine();

        if  (Integer.parseInt(userChoice) == answer) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.%n", userChoice, answer);
            System.out.println("Let's try again, " + userName);
            System.exit(0);
        }
    }
}

package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GCDGame {
    public static void gcdGameMain() {
        var index = 0;
        var userName = Cli.helloUser();

        System.out.println("Find the greatest common divisor of given numbers.");

        while (index < 3) {
            askQuestion(userName);
            index++;
        }
        System.out.println("Congratulations, " + userName + "!");
    }
    public static int findGCD(int firstInteger, int secondInteger) {
        // Пока второе число не станет равным нулю
        while (secondInteger != 0) {
            int temp = secondInteger;
            secondInteger = firstInteger % secondInteger; // Находим остаток от деления
            firstInteger = temp;  // Присваиваем 'a' значение 'b'
        }
        return Math.abs(firstInteger); // Возвращаем модуль, чтобы НОД всегда был положительным
    }
    public static void askQuestion(String userName) {
        Scanner scanner = new Scanner(System.in);

        int firstInteger = ThreadLocalRandom.current().nextInt(100);
        int secondInteger = ThreadLocalRandom.current().nextInt(100);
        int answer = 0;

        System.out.println("Question: " + Integer.toString(firstInteger) + " " + Integer.toString(secondInteger));
        answer = findGCD(firstInteger, secondInteger);

        System.out.println("Your answer: ");
        String userChoice = scanner.nextLine();

        if  (Integer.parseInt(userChoice) == answer) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.%n", userChoice, answer);
            System.out.println("Let\'s try again, " + userName);
            System.exit(0);
        }
    }
}

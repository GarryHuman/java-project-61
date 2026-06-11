package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class progressionGame {
    public static void progressionMain() {
        var index = 0;
        var userName = Cli.helloUser();

        System.out.println("What number is missing in the progression?");

        while (index < 3) {
            askQuestion(userName);
            index++;
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    public static String[] getRandomArrayProgressive() {
        int minLength = 5;
        int maxLength = 15;
        int minStep = 2;
        int maxStep = 10;
        int startValue = 0;

        int randomLength = ThreadLocalRandom.current().nextInt(minLength, maxLength + 1);
        int randomStep = ThreadLocalRandom.current().nextInt(minStep, maxStep + 1);

        String[] progressiveArray = new String[randomLength];

        int currentValue = startValue;
        for (int i = 0; i < randomLength; i++) {
            progressiveArray[i] = Integer.toString(currentValue);
            currentValue += randomStep;
        }
        return progressiveArray;
    }

    public static void askQuestion(String userName) {
        Scanner scanner = new Scanner(System.in);
        String[] progressiveArray = getRandomArrayProgressive();
        String[] hiddenArray = new String[progressiveArray.length];
        int hiddenIntegerIndex = ThreadLocalRandom.current().nextInt(progressiveArray.length + 1);
        int hiddenInteger = Integer.parseInt(progressiveArray[hiddenIntegerIndex]);
        hiddenArray = progressiveArray.clone();
        hiddenArray[hiddenIntegerIndex] = "..";

        System.out.println("Question: " + Arrays.toString(hiddenArray));

        System.out.println("Your answer: ");
        String userChoice = scanner.nextLine();

        if (Integer.parseInt(userChoice) == hiddenInteger) {
            System.out.println("Correct!");
        } else {
            System.out.println("\'" + userChoice + "\' " + "is wrong answer ;(. Correct answer was " + "\'" + hiddenInteger + "\'.");
            System.out.println("Let\'s try again, " + userName);
            System.exit(0);
        }
    }
}

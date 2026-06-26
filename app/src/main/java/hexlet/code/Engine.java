package hexlet.code;

import java.util.Scanner;

public class Engine {
    // Количество раундов, необходимое для победы в любой игре
    public static final int ROUNDS_COUNT = 3;


    public static void run(String description, String[][] roundsData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        // Вывод правил текущей игры
        System.out.println(description);

        // Итерация по заранее подготовленному массиву с вопросами и ответами
        for (String[] round : roundsData) {
            String question = round[0];
            String correctAnswer = round[1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            // Если ответ неверен, сообщаем об ошибке и немедленно завершаем игру
            if (!userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            // Если ответ верен, продолжаем цикл
            System.out.println("Correct!");
        }

        // Выводится только если цикл успешно завершил все итерации (все ROUNDS_COUNT ответов верные)
        System.out.println("Congratulations, " + userName + "!");
    }
}

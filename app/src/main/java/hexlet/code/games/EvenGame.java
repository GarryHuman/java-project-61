package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class EvenGame {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_RANDOM_NUMBER = 100;

    public static void start() {
        // Создаем структуру данных для раундов: [номер_раунда][0 - вопрос, 1 - ответ]
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = random.nextInt(MAX_RANDOM_NUMBER);

            String question = String.valueOf(number);
            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            roundsData[i][0] = question; // Вопрос раунда
            roundsData[i][1] = correctAnswer; // Правильный ответ
        }

        // Запускаем универсальный движок
        Engine.run(DESCRIPTION, roundsData);
    }
}
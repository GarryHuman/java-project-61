package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class PrimeGame {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_VALUE = 100;

    public static void start() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num = random.nextInt(MAX_VALUE) + 1;

            // Вопрос: случайное число
            roundsData[i][0] = String.valueOf(num);
            // Ответ: yes, если метод isPrime возвращает true, иначе no
            roundsData[i][1] = isPrime(num) ? "yes" : "no";
        }

        Engine.run(DESCRIPTION, roundsData);
    }
    // Проверяет, является ли переданное число простым
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        // Оптимизация: проверяем делители только до квадратного корня из числа
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
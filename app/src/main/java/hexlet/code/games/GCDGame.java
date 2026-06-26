package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class GCDGame {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_VALUE = 100;

    public static void start() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num1 = random.nextInt(MAX_VALUE) + 1;
            int num2 = random.nextInt(MAX_VALUE) + 1;
            // Вопрос: два числа через пробел
            roundsData[i][0] = num1 + " " + num2;
            // Ответ: вычисленный НОД
            roundsData[i][1] = String.valueOf(findGCD(num1, num2));
        }

        Engine.run(DESCRIPTION, roundsData);
    }
    // Вычисляет наибольший общий делитель двух чисел
    public static int findGCD(int firstInteger, int secondInteger) {
        // Пока второе число не станет равным нулю
        while (secondInteger != 0) {
            int temp = secondInteger;
            secondInteger = firstInteger % secondInteger; // Находим остаток от деления
            firstInteger = temp;  // Присваиваем 'a' значение 'b'
        }
        return Math.abs(firstInteger); // Возвращаем модуль, чтобы НОД всегда был положительным
    }
}

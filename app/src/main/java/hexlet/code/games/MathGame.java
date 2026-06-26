package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class MathGame {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int MAX_VALUE = 20; // Максимальное значение для случайных чисел
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void start() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            // Генерируем два случайных числа от 1 до MAX_VALUE
            int num1 = random.nextInt(MAX_VALUE) + 1;
            int num2 = random.nextInt(MAX_VALUE) + 1;
            // Выбираем случайный математический оператор из массива
            String operator = OPERATORS[random.nextInt(OPERATORS.length)];
            // Формируем строку с вопросом
            roundsData[i][0] = num1 + " " + operator + " " + num2;
            // Вычисляем правильный ответ и записываем его в виде строки
            roundsData[i][1] = String.valueOf(calculate(num1, num2, operator));
        }

        Engine.run(DESCRIPTION, roundsData);
    }
    // Выполняет математическую операцию над двумя числами.
    private static int calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            // Исключение на случай, если в массив OPERATORS добавят неизвестный знак
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}

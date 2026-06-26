package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class ProgressionGame {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_LENGTH = 5;  // Минимальная длина прогрессии
    private static final int MAX_LENGTH = 10; // Максимальная длина прогрессии
    private static final int MAX_START = 20;  // Максимальное начальное значение
    private static final int MAX_STEP = 10;   // Максимальный шаг прогрессии

    public static void start() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            // Генерируем параметры текущей прогрессии
            int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
            int start = random.nextInt(MAX_START) + 1;
            int step = random.nextInt(MAX_STEP) + 1;
            // Выбираем случайный индекс, который будет скрыт
            int hiddenIndex = random.nextInt(length);
            // Создаем массив для хранения элементов прогрессии в виде строк
            String[] progression = new String[length];
            for (int j = 0; j < length; j++) {
                progression[j] = String.valueOf(start + j * step);
            }
            // Запоминаем правильный ответ (скрытое число)
            String correctAnswer = progression[hiddenIndex];
            // Заменяем элемент по выбранному индексу на точки
            progression[hiddenIndex] = "..";
            // Объединяем массив строк в одну строку через пробел
            roundsData[i][0] = String.join(" ", progression);
            roundsData[i][1] = correctAnswer;
        }

        Engine.run(DESCRIPTION, roundsData);
    }
}

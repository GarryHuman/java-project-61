package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String helloUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May i have your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        return name;
    }
}

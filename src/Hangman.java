import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Hangman {



    public static int Test;

    public static void main(String[] args) {
        System.out.println("       Привет Бро!\n" + "Ты хочешь поиграть со мной?" + "\n1 - Давай поиграем!" + "\n2 - Не хочу");
        Scanner scanner = new Scanner(System.in);
        Scanner myScanner = new Scanner(System.in);
        Test = scanner.nextInt();
        if (Test == 1) {
            System.out.println("Хорошо, давай начнём");
        } else {
            System.out.println("Пока!");
            System.exit(0);
        }
        Hangman main = new Hangman();
    }
}


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Hangman {


    public static final String[] WORDS = {"ЗАЧЕМ", "ЛОКДАУН", "СКОТ", "ГЕТДАУН", "СТВОЛ", "ВИСКА", "КЛИК", "КЛЭК",
            "ПИУ", "ПАУ",};

    public static final Random RANDOM = new Random();
    public static final int MAX_ERRORS = 8;
    private String letterToFind;
    private char[] letterFound;
    private int Errors;
    private ArrayList<String> letters = new ArrayList<>();

    private String nextLetter() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }
    public void newGame() {
        Errors = 0;
        letters.clear();
        letterToFind = nextLetter();

        letterFound = new char[letterToFind.length()];

        for (int i = 0; i < letterFound.length; i++) {
            letterFound[i] = '-';
        }
    }

    public boolean wordFound() {
        return letterToFind.contentEquals(new String(letterFound));
    }

    private void enter(String c) {
        if (!letters.contains(c)) {
            if (letterToFind.contains(c)) {
                int index = letterToFind.indexOf(c);

                while (index >= 0) {
                    letterFound[index] = c.charAt(0);
                    index = letterToFind.indexOf(c, index + 1);
                }
            } else {
                Errors++;
            }

            letters.add(c);
        }
    }

    private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < letterFound.length; i++) {
            builder.append(letterFound[i]);

            if (i < letterFound.length - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    public void play() {
        try (Scanner input = new Scanner(System.in)) {
            while (Errors < MAX_ERRORS) {
                System.out.println("\nТвоя буква : ");
                String str = input.next();

                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }

                enter(str);

                System.out.println("\n" + wordFoundContent());

                if (wordFound()) {
                    System.out.println("\nОтлично!");
                    break;
                } else {
                    System.out.println("\nTries remaining : " + (MAX_ERRORS - Errors));
                }
            }

            if (Errors == MAX_ERRORS - Errors) {
                System.out.println("\nТы проиграл! :(");
                System.out.println("=> Word to find was : " + letterToFind);
            }
        }
    }

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
        Hangman hangmanGame = new Hangman();
        hangmanGame.newGame();
        hangmanGame.play();
    }
}


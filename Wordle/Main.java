import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {


    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) throws IOException {
        int lineCount = lineCount();


        mainProgram();

    }

    public static int lineCount() throws IOException {
        Path cesta = Paths.get("Words");
        Scanner filesc = new Scanner(cesta);
        int pocet = 0;

        while (filesc.hasNextLine()) {
            pocet++;
            filesc.nextLine();
        }
        return pocet;
    }

    public static String[] arrayMaker(int lineCount) throws IOException {
        Path cesta = Paths.get("Words");
        Scanner filesc = new Scanner(cesta);

        String[] words = new String[lineCount];
        int index = 0;

        while (filesc.hasNextLine()) {
            String line = filesc.next();
            words[index] = line.trim();
            index++;
        }
        return words;
    }

    public static String wordPicker(int lineCount, String[] words) {
        Random rand = new Random();
        int x = rand.nextInt(lineCount);
        return words[x];
    }

    public static String guess() {
        Scanner filesc = new Scanner(System.in);
        return filesc.nextLine();
    }

    public static boolean controlOfInput(String userGuess, String[] words) {
        return Arrays.asList(words).contains(userGuess);
    }

    public static void mainProgram() throws IOException {
        Scanner filesc = new Scanner(System.in);
        String[] words = arrayMaker(lineCount());

        String randomWord = wordPicker(lineCount(), words);
        System.out.println(randomWord);
        String guess;
        for (int i = 0; i < 5; i++) {
            while (true) {
                guess = guess();
                if (!controlOfInput(guess, words)) {
                    System.out.println("wrong input,type '1' to try again");

                    String continiue = filesc.nextLine();
                    if (continiue.equals("1")) {
                        continue;
                    } else {
                        System.exit(0);
                    }

                } else {
                    break;
                }
            }
            int a = 0;

            for (int j = 0; j < 5; j++) {

                if (guess.charAt(j) == randomWord.charAt(j)) {
                    System.out.print(ANSI_GREEN + guess.split("")[j] + ANSI_RESET);
                    a++;
                } else if (randomWord.contains(guess.split("")[j])) {
                    System.out.print(ANSI_YELLOW + guess.split("")[j] + ANSI_RESET);
                } else {
                    System.out.print(ANSI_RED + guess.split("")[j] + ANSI_RESET);
                }
            }
            System.out.println();
            if (a == 5) {
                System.out.println("you win");
                System.exit(0);
            }
        }
        System.out.println("you lose");
    }
}

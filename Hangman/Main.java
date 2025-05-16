import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
while (true){
    mainProgram(wordPicker(), pictures());
    System.out.println("if you wanna try again press 1, to quit press anything else");
    String answer = sc.nextLine();
    if (!answer.equals("1")){
        System.exit(0);
    }
}


    }

    public static String wordPicker() throws IOException {
        Path cesta = Paths.get("words");
        Scanner filesc = new Scanner(cesta);
        String[] word = new String[104];

        for (int i = 0; filesc.hasNext(); i++) {
            word[i] = filesc.next();
        }

        Random rand = new Random();
        int x = rand.nextInt(104);
        return word[x];
    }

    public static void mainProgram(String word, String[] pictures) throws IOException {
        Scanner filesc = new Scanner(System.in);
        String[] guessedWord = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            guessedWord[i] = "_";
        }

        int numberOfMistakes = 0;
        String pickedLetters = "";
        while (true) {
            int numberOfRight = 0;

            System.out.println(word);
            System.out.println("Pick a-z > ");
            String letterChosen = filesc.next();


            if (letterChosen.length() != 1 || !Character.isAlphabetic(letterChosen.charAt(0)) || pickedLetters.contains(letterChosen)) {
                if (letterChosen.length() != 1 &&  !Character.isAlphabetic(letterChosen.charAt(0))) {
                    System.out.println("input isnt the lenght 1 and it isnt aplhabetic");
                } else if (letterChosen.length() != 1) {
                    System.out.println("input isnt the lenght 1");
                } else if (!Character.isAlphabetic(letterChosen.charAt(0))) {
                    System.out.println("input isnt alphabetic");
                }else {
                    System.out.println("you already chose this letter");
                }
                continue;
            }
            pickedLetters += " " + letterChosen;
            if (word.contains(letterChosen)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.split("")[i].equals(letterChosen)) {
                        guessedWord[i] = word.split("")[i];
                    }
                }
                System.out.println(Arrays.toString(guessedWord));
            } else {
                System.out.println(pictures[numberOfMistakes]);
                numberOfMistakes++;
            }
            for (int i = 0; i < guessedWord.length; i++) {
                if (guessedWord[i].equals(word.split("")[i])) {
                    numberOfRight++;
                }
            }
            if (numberOfRight == guessedWord.length) {
                System.out.println("\n" +
                        "██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗ ██████╗ ███╗   ██╗██╗\n" +
                        "╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██╔═══██╗████╗  ██║██║\n" +
                        " ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║   ██║██╔██╗ ██║██║\n" +
                        "  ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║   ██║██║╚██╗██║╚═╝\n" +
                        "   ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝╚██████╔╝██║ ╚████║██╗\n" +
                        "   ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═══╝╚═╝\n" +
                        "                                                               \n");
                break;
            }
            if (numberOfMistakes == 6) {
                System.out.println("\n" +
                        "██╗   ██╗ ██████╗ ██╗   ██╗    ██╗      ██████╗  ██████╗ ███████╗███████╗        ██╗\n" +
                        "╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║     ██╔═══██╗██╔═══██╗██╔════╝██╔════╝    ██╗██╔╝\n" +
                        " ╚████╔╝ ██║   ██║██║   ██║    ██║     ██║   ██║██║   ██║███████╗█████╗      ╚═╝██║ \n" +
                        "  ╚██╔╝  ██║   ██║██║   ██║    ██║     ██║   ██║██║   ██║╚════██║██╔══╝      ██╗██║ \n" +
                        "   ██║   ╚██████╔╝╚██████╔╝    ███████╗╚██████╔╝╚██████╔╝███████║███████╗    ╚═╝╚██╗\n" +
                        "   ╚═╝    ╚═════╝  ╚═════╝     ╚══════╝ ╚═════╝  ╚═════╝ ╚══════╝╚══════╝        ╚═╝\n" +
                        "                                                                                    \n");
                break;
            }

        }


    }


    public static String[] pictures() {
        String[] failedAtempts = {
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " /    |\n" +
                        "      |\n" +
                        "=========",
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " / \\  |\n" +
                        "      |\n" +
                        "========="
        };
        return failedAtempts;
    }

}

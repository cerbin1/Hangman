package bartek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Game {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Game().run();
    }

    private static String[] hangmanCharacter = {"",
            "\n_______",
            "\n|\n|\n|\n|\n|\n|\n|_______",
            "\n ________\n|\n|\n|\n|\n|\n|_______",
            "\n ________\n|        |\n|\n|\n|\n|\n|_______",
            "\n ________\n|        |\n|        O\n|\n|\n|\n|_______",
            "\n ________\n|        |\n|        O\n|        |\n|\n|\n|_______",
            "\n ________\n|        |\n|        O\n|       /|\n|\n|\n|_______",
            "\n ________\n|        |\n|        O\n|       /|\\\n|\n|\n|_______",
            "\n ________\n|        |\n|        O\n|       /|\\\n|        |\n|\n|_______",
            "\n ________\n|        |\n|        O\n|       /|\\\n|        |\n|       / \n|_______",
            "\n ________\n|        |\n|        O\n|       /|\\\n|        |\n|       / \\\n|_______"
    };


    private String[] words = {
            "zubr", "kot", "pies", "szczur", "hipopotam", "chomik", "zyrafa", "slon", "polacy", "kon"
    };
    private String wordToGuess;

    List<Boolean> usersWord;
    private int fails = 0;

    private void run() {
        String name = askForName();

        int questionIndex = (int) (Math.round(Math.random() * words.length));
        wordToGuess = words[questionIndex];

        while (true) {
            displayBlankWord();
            if (checkIfCharacterIsInWord(getCharacterToCheck())) {
                displayPlayerHitCharacter();
            } else {
                incrementChances();
                displayPlayerNoHitCharacter();
            }

            if (checkIfPlayerLose()) {
                displayPlayersLose(getWordToGuess());
                break;
            }

            if (checkIfWordIsGuessed()) {
                displayBlankWord();
                displayPlayersWin();
                break;
            }
        }
    }

    private void fillUsersWord(int length) {
        usersWord = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            usersWord.add(i, Boolean.FALSE);
        }
    }

    boolean checkIfWordIsGuessed() {
        return !usersWord.contains(Boolean.FALSE);
    }

    void incrementChances() {
        fails++;
    }

    int getFails() {
        return fails;
    }

    boolean checkIfPlayerLose() {
        return fails == 11;
    }


    String getWordToGuess() {
        return wordToGuess;
    }

    boolean checkIfCharacterIsInWord(char character) {
        boolean isCharacterInWord = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == character) {
                if (usersWord.get(i)) {
                    System.out.println("Odkryles juz ta literke!");
                    return isCharacterInWord;
                } else {
                    usersWord.set(i, Boolean.TRUE);
                    isCharacterInWord = true;
                }
            }
        }
        return isCharacterInWord;
    }

    private String askForName() {
        System.out.print("Wpisz swoje imie: ");
        return scanner.nextLine();
    }

    void displayBlankWord() {
        for (int i = 0; i < getWordToGuess().length(); i++) {
            if (usersWord.get(i)) {
                System.out.print(getWordToGuess().charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
        }
    }

    Character getCharacterToCheck() {
        System.out.print("\nPodaj literke: ");
        return scanner.next().charAt(0);
    }

    void displayPlayerHitCharacter() {
        System.out.println("Odgadles litere!");
        System.out.println(hangmanCharacter[getFails()]);
    }

    void displayPlayerNoHitCharacter() {
        System.out.println("Nie udalo ci sie odgadnac literki. Mozesz sie jeszcze pomylic " + (11 - getFails()) + " razy.");
        System.out.println(hangmanCharacter[getFails()]);
    }

    static void displayPlayersLose(String guessedWord) {
        System.out.println("Przegrales :/ \nWylosowane slowo to: " + guessedWord);
    }

    static void displayPlayersWin() {
        System.out.println("\nUdalo Ci sie wygrac!");
    }
}

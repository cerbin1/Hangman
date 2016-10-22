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
        Player player = new Player("Marian", word.getWordToGuess().length()); //TODO change name to get it from user

        int randomNumber = (int) (Math.round(Math.random() * 10));
        wordToGuess = getWordToGuess(randomNumber);
        Console console = new Console(player, word);

        while (true) {
            console.displayBlankWord();
            if (word.checkIfCharacterIsInWord(console.getCharacterToCheck())) {
                console.displayPlayerHitCharacter();
            } else {
                player.incrementChances();
                console.displayPlayerNoHitCharacter();
            }

            if (player.checkIfPlayerLose()) {
                Console.displayPlayersLose(word.getWordToGuess());
                break;
            }

            if (player.checkIfWordIsGuessed()) {
                console.displayBlankWord();
                Console.displayPlayersWin();
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
                if (player.usersWord.get(i)) {
                    System.out.println("Odkryles juz ta literke!");
                    return isCharacterInWord;
                } else {
                    player.usersWord.set(i, Boolean.TRUE);
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
        for (int i = 0; i < word.getWordToGuess().length(); i++) {
            if (player.usersWord.get(i)) {
                System.out.print(word.getWordToGuess().charAt(i) + " ");
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
        System.out.println(hangmanCharacter[player.getFails()]);
    }

    void displayPlayerNoHitCharacter() {
        System.out.println("Nie udalo ci sie odgadnac literki. Mozesz sie jeszcze pomylic " + (11 - player.getFails()) + " razy.");
        System.out.println(hangmanCharacter[player.getFails()]);
    }

    static void displayPlayersLose(String guessedWord) {
        System.out.println("Przegrales :/ \nWylosowane slowo to: " + guessedWord);
    }

    static void displayPlayersWin() {
        System.out.println("\nUdalo Ci sie wygrac!");
    }
}

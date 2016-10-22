package bartek;

import java.util.Scanner;

class Console {
    private static Scanner scanner = new Scanner(System.in);
    private WordRepository word;
    private Player player;

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

    Console(Player player, WordRepository word) {
        this.word = word;
        this.player = player;
        askForName();
    }

    private void askForName() {
        System.out.print("Wpisz swoje imie: ");
        System.out.println("Witaj " + player.getName());
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

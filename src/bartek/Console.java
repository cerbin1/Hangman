package bartek;

import java.util.Scanner;

class Console {
    private static Scanner scanner = new Scanner(System.in);
    private WordToGuess word;
    private Player player;

    private static String[] hangmanCharacter = {"\n_______",
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

    Console(Player player, WordToGuess word) {
        this.word = word;
        this.player = player;
        askForName();
    }

    private void askForName() {
        System.out.print("Wpisz swoje imie: ");
        System.out.println("Witaj " + player.getName());
    }

    void displayBlankWord() {
        System.out.println(player.usersWord.size());
        for (int i = 0; i < word.getWordToGuess().length(); i++) {
            if (player.usersWord.get(i)) {
                System.out.print(word.getWordToGuess().charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
        }
    }

    Character getCharacterToCheck() {
        askForCharacter();
        return scanner.next().charAt(0);
    }

    private void askForCharacter() {
        System.out.print("\nPodaj literke: ");
    }

    static void displayPlayerHitCharacter() {
        System.out.println("Jest!");
    }

    static void displayPlayerNoHitCharacter(int fails) {
        System.out.println("Nie udalo ci sie odgadnac literki. Liczba bledow: " + fails);
        System.out.println(hangmanCharacter[--fails]);
    }

    static void displayPlayersLose(String guessedWord) {
        System.out.println("Przegrales :/ \nWylosowane slowo to: " + guessedWord);
    }

    static void displayPlayersWin() {
        System.out.println("\nUdalo Ci sie wygrac!");
    }
}

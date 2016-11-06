package bartek;

class HangmanPrinter {
    private final static String[] hangmanCharacter = {
            "\n\n\n\n\n\n\n",
            "\n\n\n\n\n\n\n_______",
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

    static void print(int progress) {
        System.out.println(hangmanCharacter[progress]);
    }
}

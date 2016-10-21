package bartek;

class Game {
    void run() {
        Console console = new Console();
        WordToGuess word = new WordToGuess();
        Player player = new Player("Marian", word.getWordToGuess().length()); //TODO change name to get it from user
        console.displayHelloMessage(player.getName());

        while (true) {
            console.displayBlankWord(word, player);
            if (word.checkIfCharacterIsInWord(console.getCharacterToCheck(), player)) {
                Console.displayPlayerHitCharacter();
            } else {
                Console.displayPlayerNoHitCharacter();
                player.incrementChances();
            }

            if (player.checkIfWordIsGuessed()) {
                break;
            }
        }
    }
}

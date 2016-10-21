package bartek;

class Game {
    void run() {
        Console console = new Console();
        WordToGuess word = new WordToGuess();
        Player player = new Player("Marian"); //TODO change name to get it from user
        console.displayHelloMessage(player.getName());
        player.fillUsersWord(word.getWordToGuess().length());
        console.displayBlankWord(word, player);

    }
}

package bartek;

class Game {
    void run() {
        Console console = new Console();
        WordToGuess word = new WordToGuess();
        //Player player = new Player(console.getName());
        //console.displayHelloMessage(player.getName());
        console.displayBlankWord(word.getWordToGuess().length());

    }
}

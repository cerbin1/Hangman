package bartek;

class Game {
    void run() {
        Console console = new Console();
        Player player = new Player(console.getName());
        console.displayHelloMessage(player.getName());
    }
}

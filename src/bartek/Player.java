package bartek;

class Player {
    private String name;
    boolean[] usersWord;

    Player(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void fillUsersWord(int length) {
        usersWord = new boolean[length];
        for (int i = 0; i < length; i++) {
            usersWord[i] = true;
        }
    }
}

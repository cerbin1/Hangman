package bartek;

class Player {
    private String name;
    boolean[] usersWord;

    Player(String name, int length) {
        this.name = name;
        fillUsersWord(length);
    }

    String getName() {
        return name;
    }

    private void fillUsersWord(int length) {
        usersWord = new boolean[length];
        for (int i = 0; i < length; i++) {
            usersWord[i] = false;
        }
    }
}

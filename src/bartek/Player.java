package bartek;

class Player {
    private String name;
    boolean[] usersWord;
    private int fails = 0;

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

    boolean checkIfWordIsGuessed() {
        for (int i = 0; i < usersWord.length; i++) {
            if (!usersWord[i]) {
                return false;
            }
        }
        return true;
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
}

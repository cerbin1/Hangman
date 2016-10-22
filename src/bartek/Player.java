package bartek;

import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    List<Boolean> usersWord;
    private int fails = 0;

    Player(String name, int length) {
        this.name = name;
        fillUsersWord(length);
    }

    String getName() {
        return name;
    }

    private void fillUsersWord(int length) {
        usersWord = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            usersWord.add(i, Boolean.FALSE);
        }
    }

    boolean checkIfWordIsGuessed() {
        return !usersWord.contains(Boolean.FALSE);
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

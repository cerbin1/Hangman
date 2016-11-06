package bartek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SearchWord {
    private String word;
    private List<Boolean> blankedLetters = new ArrayList<>();

    SearchWord(String wordToGuess) {
        this.word = wordToGuess;
        fillUsersWord(wordToGuess.length());
    }

    private void fillUsersWord(int size) {
        blankedLetters.addAll(Arrays.asList(new Boolean[size]));
        Collections.fill(blankedLetters, Boolean.FALSE);
    }

    boolean guessLetter(char letter) {
        boolean isLetterInWord = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter && isLetterBlank(i)) {
                revealLetter(i);
                isLetterInWord = true;
            }
        }
        return isLetterInWord;
    }

    private boolean isLetterBlank(int i) {
        return !blankedLetters.get(i);
    }

    private Boolean revealLetter(int i) {
        return blankedLetters.set(i, Boolean.TRUE);
    }

    String getBlankedWord() {
        String blankedWord = "";
        for (int i = 0; i < word.length(); i++) {
            if (blankedLetters.get(i)) {
                blankedWord += Character.toString(word.charAt(i)) + " ";
            } else {
                blankedWord += "_ ";
            }
        }
        return blankedWord;
    }

    boolean isGuessed() {
        return !blankedLetters.contains(Boolean.FALSE);
    }

    String getWord() {
        return word;
    }
}

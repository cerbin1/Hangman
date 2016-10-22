package bartek;

public class WordRepository {
    private final String[] words = {
            "zubr", "kot", "pies", "szczur", "hipopotam", "chomik", "zyrafa", "slon", "polacy", "kon"
    };

    public SearchWord getRandomWord() {
        int questionIndex = (int) (Math.round(Math.random() * words.length));
        String randomWord = words[questionIndex];
        return new SearchWord(randomWord);
    }
}

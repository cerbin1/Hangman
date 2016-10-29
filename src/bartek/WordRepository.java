package bartek;

class WordRepository {
    private final String[] words = {
            "zubr", "kot", "pies", "szczur", "hipopotam", "chomik", "zyrafa", "slon", "polacy", "kon"
    };

    SearchWord getRandomWord() {
        int questionIndex = (int) (Math.floor(Math.random() * words.length));
        String randomWord = words[questionIndex];
        return new SearchWord(randomWord);
    }
}

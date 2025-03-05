import java.util.ArrayList;

/**
 * Summarizes text by pulling key sentences from the files
 */
public class TextSummarizer {

    private ArrayList<String> sentences;
    private ArrayList<String> words;    

    /**
     * Constructor to initialize the TextSummarizer with a file
     * @param filename the file containing the text to summarize
     */
    public TextSummarizer(String filename) {
        this.sentences = new ArrayList<>();
        this.words = new ArrayList<>();
        processFile(filename);
    }

    /**
     * Reads the file and processes the text into sentences and words
     * @param filename the file containing the text
     */
    private void processFile(String filename) {
        ArrayList<String> lines = FileReader.toStringList(filename); 
        for (String line : lines) {
            processLineForSentences(line);
            processLineForWords(line);
        }
    }

    /**
     * Processes a line of text to extract sentences
     * @param line the line of text to process
     */
    private void processLineForSentences(String line) {
        String sentence = "";
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            sentence += ch; 
            if (isSentenceEndingPunctuation(ch)) {
                sentence = sentence.trim(); 
                if (!sentence.isEmpty()) {
                    sentences.add(sentence);
                }
                sentence = ""; 
            }
        }
        // Add the last sentence if the line doesn't end with punctuation
        sentence = sentence.trim();
        if (!sentence.isEmpty()) {
            sentences.add(sentence);
        }
    }

    /**
     * Processes a line of text to extract words.
     * @param line The line of text to process
     */
    private void processLineForWords(String line) {
        String word = "";
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                word += ch; 
            } else {
                addWordToList(word);
                word = "";
            }
        }
        // Add the last word if the line doesn't end with a separator
        addWordToList(word);
    }

    /**
     * Adds a word to the words list if it's not empty.
     * @param word The word to add
     */
    private void addWordToList(String word) {
        if (!word.isEmpty()) {
            words.add(word.toLowerCase());
        }
    }

    /**
     * Checks if a character is a sentence-ending punctuation.
     * @param ch The character to check
     * @return True if the character is a sentence-ending punctuation, false otherwise
     */
    private boolean isSentenceEndingPunctuation(char ch) {
        return ch == '.' || ch == '!' || ch == '?';
    }

    /**
     * Calculates the frequency of a given word in the text
     * my student developed algorithm
     * @param targetWord The word to count
     * @return The frequency of the word
     */
    private int calculateWordFrequency(String targetWord) {
        int count = 0;
        for (String word : words) {
            if (word.equals(targetWord)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Scores sentences based on the frequency of words they contain
     * my student developed algorithm
     * @return an array of sentence scores
     */
    private int[] scoreSentences() {
        int[] sentenceScores = new int[sentences.size()];
        for (int i = 0; i < sentences.size(); i++) {
            String sentence = sentences.get(i);
            String[] sentenceWords = sentence.split(" ");
            for (String word : sentenceWords) {
                word = word.toLowerCase(); 
                sentenceScores[i] += calculateWordFrequency(word);
            }
        }
        return sentenceScores;
    }

    /**
     * Generates a summary by selecting the sentences with the highest scores
     * @param numSentences The number of sentences to include in the summary
     * @return a summary of the text
     */
    public String generateSummary(int numSentences) {
        int[] sentenceScores = scoreSentences();

        String summary = "";
        for (int i = 0; i < numSentences; i++) {
            int maxIndex = 0;
            for (int j = 1; j < sentenceScores.length; j++) {
                if (sentenceScores[j] > sentenceScores[maxIndex]) {
                    maxIndex = j;
                }
            }
            summary += sentences.get(maxIndex) + ". ";
            sentenceScores[maxIndex] = -1; 
        }

        return summary;
    }
}
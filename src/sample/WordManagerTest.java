package sample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by tom on 20/02/2017.
 */
public class WordManagerTest {

    //private String inputString = makeString(250000);

    int amount = 250000;

    @org.junit.Test
    public void splitWordsTest() throws Exception {
        WordManager manager = new WordManager();

        String[] words = manager.splitWords("Een, Twee, Drie");

        assertEquals(new String[]{"een", "twee", "drie"}, words);
    }

    @Test
    public void getWordCount() throws Exception {
        WordManager manager = new WordManager();
        String input = makeString(1);

        assertEquals("With doubles should be 8", 8, manager.getWordCount(input, false));
        assertEquals("Without doubles should be 6", 6, manager.getWordCount(input, true));

        int wordCount = manager.getWordCount(makeString(amount), false);
        System.out.println("# of words: " + wordCount);
    }

    @Test
    public void getSortedWords() throws Exception {
        WordManager manager = new WordManager();
        String input = makeString(amount);

        manager.getSortedWords(input);
    }

    @Test
    public void getWordFrequency() throws Exception {
        WordManager manager = new WordManager();
        String input = makeString(amount);

        manager.getWordFrequency(input);
    }

    @Test
    public void getWordConcordance() throws Exception {
        WordManager manager = new WordManager();
        String input = makeString(amount); // "Een, Twee, Drie, Vier \n Hoedje van, Hoedje van \n"

        //HashMap<String, Integer[]> expected = new HashMap<>();
        TreeMap<String, LinkedList<Integer>> result = manager.getWordConcordance(input);
    }

    public String makeString(int amount){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < amount; i++){
            sb.append("Een, Twee, Drie, Vier \n Hoedje van, Hoedje van \n");
        }

        return sb.toString();
    }

}
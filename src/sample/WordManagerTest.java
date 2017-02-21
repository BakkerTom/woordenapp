package sample;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by tom on 20/02/2017.
 */
public class WordManagerTest {

    private String inputString = makeString(250000);

    @org.junit.Test
    public void splitWordsTest() throws Exception {
        WordManager manager = new WordManager();

        String[] words = manager.splitWords("Een, Twee/ Drie.");

        assertEquals(new String[]{"Een", "Twee", "Drie"}, words);
    }

    @Test
    public void getWordCount() throws Exception {
        WordManager manager = new WordManager();
        String input = makeString(1);

        assertEquals("With doubles should be 8", 8, manager.getWordCount(input, false));
        assertEquals("Without doubles should be 6", 6, manager.getWordCount(input, true));
    }

    @Test
    public void getSortedWords() throws Exception {
        WordManager manager = new WordManager();
        String input = makeString(1000000);

        manager.getSortedWords(input);
    }

    @Test
    public void getWordFrequency() throws Exception {
        WordManager manager = new WordManager();
        //String input = makeString(1000000);

        manager.getWordFrequency(inputString);
    }

    public String makeString(int amount){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < amount; i++){
            sb.append("Een, Twee, Drie, Vier \n Hoedje van, Hoedje van \n");
        }

        return sb.toString();
    }

}
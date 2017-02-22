package sample;


import java.text.Collator;
import java.util.*;

public class WordManager{

    public String[] splitWords(String input){
        //Make string lowercase
        String lowerCaseInput = input.toLowerCase();

        //Use regular expressions to split every word
        String[] array = lowerCaseInput.split("\\W+");

        return array;
    }

    public int getWordCount(String input, boolean noDoubles){
        //Get all the words to work with
        String[] words = splitWords(input);

        //Only launches with the 'No Doubles' flag
        if (noDoubles){
            // A Set doesn't allow doubles so I'm converting the array to a Set
            Set<String> hashSet = new HashSet<>();
            Collections.addAll(hashSet, words);

            return hashSet.size();
        }

        return words.length;
    }

    public Collection<String> getSortedWords(String input){
        //Get all the words to work with
        String[] words = splitWords(input);

        //Using a TreeSet here as it is always in order.
        Collection<String> set = new TreeSet<>(Collections.reverseOrder()); // The comparator is set to Reverse order
        set.addAll(Arrays.asList(words));

        return set;
    }

    public Map<String, Integer> getWordFrequency(String input){
        String[] words = splitWords(input);
        Map<String, Integer> map = new HashMap();
        Integer ONE = new Integer(1);

        //Loops over the entire array
        for (String word : words){
            String key = word;
            Integer frequency = (Integer)map.get(key);

            //If i
            if (frequency == null){
                frequency = ONE;
            } else {
                int value = frequency.intValue();
                frequency = new Integer(value + 1);
            }

            map.put(key, frequency);
        }

        return map;
    }

    public TreeMap<String, LinkedList<Integer>> getWordConcordance(String input) {
        // Get a collection of all individual words
        // Get a collection of lines
        // For every word, seek occurrences in the lines
        // If a word is in a line, add the word as a Key to the Map and the line number to the integer list

        String[] words = splitWords(input);
        String[] lines = input.split("\\r?\\n");

        // Make a TreeSet to remove duplicates from the words array and automatically order alphabetically
        Set<String> wordSet = new TreeSet<>();
        wordSet.addAll(Arrays.asList(words));

        TreeMap<String, LinkedList<Integer>> map = new TreeMap<>();

        //Foreach word in the wordset...
        for (String word : wordSet){
            // Key = the word
            LinkedList<Integer> value = new LinkedList<>();

            for (int i = 0; i < lines.length; i++){
                String line = lines[i].toLowerCase();

                if (line.contains(word)){
                    //Add line index to the integer list
                    value.add(i + 1); //Add 1 as line numbers are not 0-indexed
                }
            }

            map.put(word, value);
        }


        return map;
    }
}
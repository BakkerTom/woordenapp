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
}
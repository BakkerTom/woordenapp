package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.Iterator;
import java.util.Map;

public class Controller {

    @FXML
    private TextArea inputTextField, outputTextField;
    private WordManager manager = new WordManager();

    public Controller() {

    }

    @FXML
    private void didPressAmount(){

        String s = inputTextField.getText();

        int total = manager.getWordCount(s, false);
        int individuals = manager.getWordCount(s, true);

        outputTextField.setText("Totaal aantal woorden: " + total + "\n" + "Aantal verschillende woorden: " + individuals);

    }

    @FXML
    private void didPressSort(){

        String s = inputTextField.getText();

        StringBuilder sb = new StringBuilder();
        for (String word : manager.getSortedWords(s)){
            sb.append(word + "\n");
        }

        outputTextField.setText(sb.toString());
    }

    @FXML
    private void didPressFrequency(){
        // TODO - Implement frequency functionality

        String s = inputTextField.getText();

        StringBuilder sb = new StringBuilder();
        Map data = manager.getWordFrequency(s);

        Iterator entries = data.entrySet().iterator();

        while (entries.hasNext()){
            Map.Entry thisEntry = (Map.Entry) entries.next();
            Object key = thisEntry.getKey();
            Object value = thisEntry.getValue();

            sb.append(key.toString() + ": " + value.toString() + "\n");
        }

        outputTextField.setText(sb.toString());
    }

    @FXML
    private void didPressConcordance(){
        // TODO - Implement concordance functionality
    }

}

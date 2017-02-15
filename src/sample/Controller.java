package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private TextArea inputTextField, outputTextField;

    public Controller() {

    }

    @FXML
    private void didPressAmount(){
        // TODO - Implement amount functionality

        outputTextField.setText("Hello World!");
    }

    @FXML
    private void didPressSort(){
        // TODO - Implement sorting functionality
    }

    @FXML
    private void didPressFrequency(){
        // TODO - Implement frequency functionality
    }

    @FXML
    private void didPressConcordance(){
        // TODO - Implement concordance functionality
    }

}

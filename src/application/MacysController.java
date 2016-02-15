package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MacysController {

    @FXML
    private TextField testTF;

    @FXML
    private Button testButton;

    @FXML
    void testAction(ActionEvent event) {
    	testTF.setText("Let's make this happen!");
    }

}

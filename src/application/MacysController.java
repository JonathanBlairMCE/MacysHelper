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
    private Button getHelpButton;

    @FXML
    void testAction(ActionEvent event) {
    	testTF.setText("Let's make this happen!");
    }
    
    @FXML
    void getHelp(ActionEvent event) {
        try{
            new BookAppointment().start(window);
        } catch (Exception e) {}
        System.out.println("It's connected");
    }

}

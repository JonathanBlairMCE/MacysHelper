package application;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class BookAppointment extends Application {
	
	static Stage window;

	@Override
	public void start(Stage primaryStage) throws IOException {
	    
		window = primaryStage;
		
	    // constructing our scene
	    URL url = getClass().getResource("BookAppointment.fxml");
	    AnchorPane pane = FXMLLoader.load(url);
	    Scene BookAppointment = new Scene(pane);
	    
	    // setting the stage
	    window.setScene(BookAppointment);
	    window.setTitle("Book Appointment");
	    window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
    private ComboBox<?> ddTime;

    @FXML
    private ComboBox<?> ddBudget;

    @FXML
    private ComboBox<?> ddDepartment;

    @FXML
    private TextField tfName;

    @FXML
    private ComboBox<?> ddFloor;

    @FXML
    private TextArea taSelfDescription;

    @FXML
    private Button btSubmit;

    @FXML
    private ComboBox<?> ddGender;

    @FXML
    private ToggleButton tgPreselection;

    @FXML
    private DatePicker dtDate;

    @FXML
    private TextArea taLookingFor;

    @FXML
    private ToggleButton tgAppointment;

    @FXML
    private ComboBox<?> ddBodyType;

    @FXML
    void futureAppointment(ActionEvent event) {
    	if (tgPreselection.isPressed()) {
    		dtDate.setVisible(true);
    		tgPreselection.setVisible(true);
    		ddTime.setVisible(true);
    	}
    	else {
    		dtDate.setVisible(false);
    		tgPreselection.setVisible(false);
    		ddBodyType.setVisible(false);
    		ddTime.setVisible(false);
    		ddBudget.setVisible(false);
    	}

    }

    @FXML
    void bookAppointment(ActionEvent event) {

    }

    @FXML
    void outfitPreselection(ActionEvent event) {

    }

}

package application;

import application.DAL.*;
import application.Domain.*;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class BookAppointment extends Application {
	
	
	static Stage window;
	
	ObservableList<String> gender = 
		    FXCollections.observableArrayList(
		    		"Male",
		    		"Female"
		    );	
		    		
	ObservableList<String> times = 
		    FXCollections.observableArrayList(
		        "9:00 am",
		        "9:15 am",
		        "9:30 am",
		        "9:45 am",
		        "10:00 am",
		        "10:15 am",
		        "10:30 am",
		        "10:45 am",
		        "11:00 am",
		        "11:15 am",
		        "11:30 am",
		        "11:45 am",
		        "12:00 pm",
		        "12:15 pm",
		        "12:30 pm",
		        "12:45 pm",
		        "1:00 pm",
		        "1:15 pm",
		        "1:30 pm",
		        "1:45 pm",
		        "2:00 pm",
		        "2:15 pm",
		        "2:30 pm",
		        "2:45 pm",
		        "3:00 pm",
		        "3:15 pm",
		        "3:30 pm",
		        "3:45 pm",
		        "4:00 pm",
		        "4:15 pm",
		        "4:30 pm",
		        "4:45 pm",
		        "5:00 pm",
		        "5:15 pm",
		        "5:30 pm",
		        "5:45 pm",
		        "6:00 pm",
		        "6:15 pm",
		        "6:30 pm",
		        "6:45 pm",
		        "7:00 pm",
		        "7:15 pm",
		        "7:30 pm",
		        "7:45 pm",
		        "8:00 pm",
		        "8:15 pm",
		        "8:30 pm",
		        "8:45 pm"
		    );
	
	@FXML
    private ComboBox<String> ddTime;

    @FXML
    private ComboBox<Double> ddBudget;

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
    private ComboBox<String> ddGender;

    @FXML
    private Label lbDate;

    @FXML
    private Label lbBodyType;

    @FXML
    private ToggleButton tgPreselection;

    @FXML
    private DatePicker dtDate;

    @FXML
    private Label lbBudget;

    @FXML
    private TextArea taLookingFor;

    @FXML
    private ToggleButton tgAppointment;

    @FXML
    private Label lbTime;

    @FXML
    private ComboBox<?> ddBodyType;

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
	
    public void initialize() {
    	loadItems();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
	public void loadItems() {
		//ddGender.setItems(gender);
		ddTime.setItems(times);
	}
	
    @FXML
    void futureAppointment(ActionEvent event) {
    	if (tgAppointment.isSelected()) {
    		dtDate.setVisible(true);
    		tgPreselection.setVisible(true);
    		ddTime.setVisible(true);
    		lbDate.setVisible(true);
    		lbTime.setVisible(true);
    		tgPreselection.setSelected(false);
    		
    		ddTime.setItems(times);
    	}
    	else {
    		dtDate.setVisible(false);
    		tgPreselection.setVisible(false);
    		ddBodyType.setVisible(false);
    		ddTime.setVisible(false);
    		ddBudget.setVisible(false);
    		lbBudget.setVisible(false);
    		lbDate.setVisible(false);
    		lbTime.setVisible(false);
    		lbBodyType.setVisible(false);
    	}
    }

    @FXML
    void bookAppointment(ActionEvent event) {
    	Customer newCustomer = new Customer();
    	
    	newCustomer.Name = tfName.getText();
    	newCustomer.Gender = (String) ddGender.getValue();
    	newCustomer.Floor = (int) ddFloor.getValue();
    	newCustomer.Department = (String) ddDepartment.getValue();
    	newCustomer.SearchItems = taLookingFor.getText();
    	newCustomer.CustomerDescription = taSelfDescription.getText();
    	
    	if (!(tgAppointment.isSelected())) {
    		SQLRequests.Submission(newCustomer);
    	}
    	
    	
    	
    }

    @FXML
    void outfitPreselection(ActionEvent event) {
    	if (tgPreselection.isSelected()) {
    		ddBudget.setVisible(true);
    		ddBodyType.setVisible(true);
    		lbBudget.setVisible(true);
    		lbBodyType.setVisible(true);
    	}
    	else {
    		ddBodyType.setVisible(false);
    		ddBudget.setVisible(false);
    		lbBudget.setVisible(false);
    		lbBodyType.setVisible(false);
    	}
    }

}

package application;

import java.util.Date;
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

	ObservableList<String> floor =
		    FXCollections.observableArrayList(
		    		"1",
		    		"2"
		    );

	//ObservableList<int[]> floor;

	ObservableList<String> dpts =
		    FXCollections.observableArrayList(
		    		"Mens",
		    		"Furniture",
		    		"Womens",
		    		"Fragrances"
		    );

	ObservableList<String> hours =
		    FXCollections.observableArrayList(
		    		"9",
			        "10",
			        "11",
			        "12",
			        "13",
			        "14",
			        "15",
			        "16",
			        "17",
			        "18",
			        "19",
			        "20"
		    );

	ObservableList<String> minutes =
		    FXCollections.observableArrayList(
		        "00",
		        "15",
		        "30",
		        "45"
		    );

	ObservableList<String> days =
		    FXCollections.observableArrayList(
		    		"1",
			        "2",
			        "3",
			        "4",
			        "5",
			        "6",
			        "7",
			        "8",
			        "9",
			        "10",
			        "11",
			        "12",
			        "13",
			        "14",
			        "15",
			        "16",
			        "17",
			        "18",
			        "19",
			        "20",
			        "21",
			        "22",
			        "23",
			        "24",
			        "25",
			        "26",
			        "27",
			        "28",
			        "29",
			        "30",
			        "31"
		    );

	ObservableList<String> months =
		    FXCollections.observableArrayList(
		        "1",
		        "2",
		        "3",
		        "4",
		        "5",
		        "6",
		        "7",
		        "8",
		        "9",
		        "10",
		        "11",
		        "12"
		    );

	ObservableList<String> bodyTypes =
		    FXCollections.observableArrayList(
		        "Short - Slim",
		        "Short - Average Weight",
		        "Short - Hefty",
		        "Average Height - Slim",
		        "Average Height - Average Weight",
		        "Average Height - Hefty",
		        "Tall - Slim",
		        "Tall - Average Weight",
		        "Tall - Hefty"
		    );

	ObservableList<Double> budget =
		    FXCollections.observableArrayList(
		        20.00, 40.00, 60.00, 80.00, 100.00, 1000.00, 999999.99
		    );

    @FXML
    private ComboBox<Double> ddBudget;

    @FXML
    private ComboBox<String> ddDepartment;

    @FXML
    private TextField tfName;

    @FXML
    private ComboBox<String> ddFloor;

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
    private Button backButon;

    @FXML
    private Label lbBudget;

    @FXML
    private TextArea taLookingFor;

    @FXML
    private ToggleButton tgAppointment;

    @FXML
    private Label lbTime;

    @FXML
    private ComboBox<String> ddBodyType;

    @FXML
    private ComboBox<String> ddMinute;

    @FXML
    private ComboBox<String> ddDay;

    @FXML
    private ComboBox<String> ddHour;

    @FXML
    private ComboBox<String> ddMonth;


    public void initialize() {
    	loadItems();
    }

	@Override
	public void start(Stage primaryStage) throws IOException {

		window = primaryStage;

	    // constructing our scene
	    URL url = getClass().getResource("BookAppointments.fxml");
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
	public void loadItems() {
		ddGender.setItems(gender);
		ddMonth.setItems(months);
		ddHour.setItems(hours);
		ddDay.setItems(days);
		ddMinute.setItems(minutes);
		ddBudget.setItems(budget);
		ddBodyType.setItems(bodyTypes);

		//int[] floors = SQLRequests.GetFloors(14);
		//floor = FXCollections.observableArrayList(floors);
		ddFloor.setItems(floor);
		ddDepartment.setItems(dpts);
	}

    @FXML
    void futureAppointment(ActionEvent event) {
    	if (tgAppointment.isSelected()) {
    		ddMonth.setVisible(true);
    		ddDay.setVisible(true);
    		ddHour.setVisible(true);
    		ddMinute.setVisible(true);
    		lbDate.setVisible(true);
    		lbTime.setVisible(true);
    		tgPreselection.setVisible(true);
    		tgPreselection.setSelected(false);
    	}
    	else {
    		ddMonth.setVisible(false);
    		ddDay.setVisible(false);
    		ddHour.setVisible(false);
    		ddMinute.setVisible(false);
    		tgPreselection.setVisible(false);
    		ddBodyType.setVisible(false);
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
    	//newCustomer.Floor = (int) ddFloor.getValue();
    	newCustomer.Floor = 1;
    	newCustomer.Department = (String) ddDepartment.getValue();
    	newCustomer.SearchItems = taLookingFor.getText();
    	newCustomer.CustomerDescription = taSelfDescription.getText();


    	if (!(tgAppointment.isSelected())) {
    		SQLRequests.Submission(newCustomer);
    	}
    	else if (!(tgPreselection.isSelected()) && (tgAppointment.isSelected())) {
    		int aptHour = Integer.parseInt(ddHour.getValue());
    		int aptMin = Integer.parseInt(ddMinute.getValue());
    		int aptMonth = Integer.parseInt(ddMonth.getValue());
    		int aptDay = Integer.parseInt(ddDay.getValue());

    		@SuppressWarnings("deprecation")
			Date appointmentTime = new Date(2016, aptMonth, aptDay, aptHour, aptMin);
    		newCustomer.DateTime = appointmentTime;

    		SQLRequests.Submission(newCustomer);
    	}
    	else {
    		newCustomer.BodyType = ddBodyType.getValue();

    		SQLRequests.Submission(newCustomer);
    	}

    	try{
            new Waiting().start(window);
        } catch (Exception e) {}
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

    @FXML
    void goBack(ActionEvent event) {
    	try{
            new Main().start(window);
        } catch (Exception e) {}
    }

    @FXML
    void floorAction(ActionEvent event) {
    	ddDepartment.setDisable(false);
    }

}

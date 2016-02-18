package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.DAL.SQLRequests;
import application.Domain.Customer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Queue extends Application {
<<<<<<< HEAD
	
    static Stage window;
    
    @FXML
    private ScrollPane textAreaQueue;
    
    @FXML
    private Button loadApts;
    
    @FXML
    private Button btLogout;
    
    @FXML
    private ImageView imageView;
    
    @FXML
    private ListView<String> desList;
    
    @FXML
    private ListView<String> nameList;
=======

	static Stage window;

	@FXML
	private ScrollPane textAreaQueue;

	@FXML
	private Button loadApts;

	@FXML
	private Button btLogout;

	@FXML
	private ImageView imageView;

	@FXML
	private ListView<String> nameList;
>>>>>>> origin/master

	@Override
	public void start(Stage primaryStage) throws IOException {

		window = primaryStage;

		// constructing our scene
		URL url = getClass().getResource("Queue.fxml");
		AnchorPane pane = FXMLLoader.load(url);
		Scene Queue = new Scene(pane);

		// setting the stage
		window.setScene(Queue);
		window.setTitle("Queue");
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initialize() {
		Image Alex = new Image("application/Assets/20160217_115431.jpg");
		imageView.setImage(Alex);

	}

	@FXML
	void logout(ActionEvent event) {
		try{
			new Main().start(window);
		} catch (Exception e) {}
	}

	public void loadList() {
		ObservableList<String> names = FXCollections.observableArrayList();
<<<<<<< HEAD
		ObservableList<String> decs = FXCollections.observableArrayList();
    	
    	Customer[] Queue = SQLRequests.Queue;
    	int totalCustomers = SQLRequests.Queue.length;
    	for (int i=0;i<totalCustomers;i++) {
    		names.add(Queue[i].Name);
    		decs.add(Queue[i].CustomerDescription);
    	}
    	nameList.setItems(names);
    	desList.setItems(decs);
=======

		Customer[] Queue = SQLRequests.Queue;
		int totalCustomers = SQLRequests.Queue.length;
		for (int i=0;i<totalCustomers;i++) {
			if (Queue[i] != null)
			{
				names.add(Queue[i].Name);
				String description = Queue[i].CustomerDescription;
			}
		}
		nameList.setItems(names);
>>>>>>> origin/master
	}

}

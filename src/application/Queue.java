package application;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Queue extends Application {
	
    static Stage window;
    
    @FXML
    private Button btLogout;

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
	
	@FXML
    void logout(ActionEvent event) {
		try{
            new Main().start(window);
        } catch (Exception e) {}
    }

}

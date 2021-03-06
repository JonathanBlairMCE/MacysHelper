package application;

import application.DAL.*;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Waiting extends Application {
	
    static Stage window;
    
    @FXML
    private Button bReturn;
    
    @FXML
    private Button refresh;
    
    @FXML
    private TextArea TextFieldWait;

	@Override
	public void start(Stage primaryStage) throws IOException {
	    
		window = primaryStage;
		
	    // constructing our scene
	    URL url = getClass().getResource("Waiting.fxml");
	    AnchorPane pane = FXMLLoader.load(url);
	    Scene Waiting = new Scene(pane);
	    
	    // setting the stage
	    window.setScene(Waiting);
	    window.setTitle("Waiting");
	    window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

    @FXML
    void returnHome(ActionEvent event) {
    	try{
            new Main().start(window);
        } catch (Exception e) {}
    }
    
    @FXML
    void refresh(ActionEvent event) {
    	if (SQLRequests.DoRefresh()) {
    		TextFieldWait.setText("Alex is on the way");
    	}
    }

}

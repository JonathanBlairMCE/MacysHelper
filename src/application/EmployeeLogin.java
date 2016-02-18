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

public class EmployeeLogin extends Application {
	
    static Stage window;
    
    @FXML
    private Button backButon;

	@Override
	public void start(Stage primaryStage) throws IOException {
	    
		window = primaryStage;
		
	    // constructing our scene
	    URL url = getClass().getResource("EmployeeLogin.fxml");
	    AnchorPane pane = FXMLLoader.load(url);
	    Scene EmployeeLogin = new Scene(pane);
	    
	    // setting the stage
	    window.setScene(EmployeeLogin);
	    window.setTitle("Employee Login");
	    window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
    void goBack(ActionEvent event) {
		try{
            new Main().start(window);
        } catch (Exception e) {}
    }

}

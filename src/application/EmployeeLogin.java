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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmployeeLogin extends Application {
	
    static Stage window;
    
    @FXML
    private Button backButon;
    
    @FXML
    private Button btLogin;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfUsername;

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
	
	@FXML
	void login(ActionEvent event) {
		String password = pfPassword.getText();
		String username = tfUsername.getText();
		Boolean authenticate = SQLRequests.ADSecurityAuthenticate(password, username);
		if (authenticate) {
			try{
	            new Queue().start(window);
	        } catch (Exception e) {}
		}
		else {
			
		}
	}

}

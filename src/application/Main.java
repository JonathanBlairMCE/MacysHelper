package application;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.DAL.*;
public class Main extends Application {

    static Stage window;

	@Override
	public void start(Stage primaryStage) throws IOException
	{
		window = primaryStage;
	    // constructing our scene
	    URL url = getClass().getResource("Index.fxml");
	    AnchorPane pane = FXMLLoader.load(url);
	    Scene Main = new Scene(pane);

	    // setting the stage
	    window.setScene(Main);
	    window.setTitle("Macys Helper");
	    window.show();

//starts refresh queue task
	}


	public void initialize()
	{
		SQLRequests.StartEmployeeLogic();
		Image Logo = new Image("application/Assets/macys_logo.png");
	    imageView.setImage(Logo);
	}

	public static void main(String[] args) {
		launch(args);
	}

    public void goToBookAppointment() {
        try{
            new BookAppointment().start(window);
        } catch (Exception e) {}
    }

    public void goToEmployeeLogin() {
        try{
            new EmployeeLogin().start(window);
        } catch (Exception e) {}
    }

    public void goToMain() {
        try{
            new Main().start(window);
        } catch (Exception e) {}
    }

    public void goToQueue() {
        try{
            new Queue().start(window);
        } catch (Exception e) {}
    }

    @FXML
    private ImageView imageView;

	@FXML
    private TextField testTF;

    @FXML
    private Button testButton;

    @FXML
    private Button getHelpButton;

    @FXML
    private Button employeeLoginButton;

    @FXML
    void testAction(ActionEvent event) {
    	testTF.setText("Let's make this happen!");
	    SQLRequests.StartEmployeeLogic();
    }

    @FXML
    void getHelp(ActionEvent event) {
    	goToBookAppointment();
    }

    @FXML
    void employeeLogin(ActionEvent event) {
    	goToEmployeeLogin();
    }
}

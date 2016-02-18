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
		//(new RefreshQueueTask()).run(); //starts refresh queue task
	}

	public static void main(String[] args) {
		launch(args);
	}

    public void goToBookAppointment() {
        try{
            new BookAppointment().start(window);
        } catch (Exception e) {}
        System.out.println("It's connected");
    }

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
    	goToBookAppointment();
    }
}

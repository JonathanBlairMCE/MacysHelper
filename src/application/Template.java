package application;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Template extends Application {
	
    static Stage window;

	@Override
	public void start(Stage primaryStage) throws IOException {
	    
		window = primaryStage;
		
	    // constructing our scene
	    URL url = getClass().getResource("Template.fxml");
	    AnchorPane pane = FXMLLoader.load(url);
	    Scene Template = new Scene(pane);
	    
	    // setting the stage
	    window.setScene(Template);
	    window.setTitle("Template");
	    window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

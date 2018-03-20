package JavaFXApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

public static void main(String[] args) {
		
		launch (args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Satitics Calculator");
		
		Pane root = FXMLLoader.load(getClass().getResource("/MainFrame.fxml"));
		
		Scene scene = new Scene (root, 700, 500);
		
		primaryStage.setResizable(false);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}
}

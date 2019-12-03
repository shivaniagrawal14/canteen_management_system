package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

public static Stage stage; // set global stage object!!!

@Override
public void start(Stage primaryStage) {
try {
		stage = primaryStage;
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/views/LoginView.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
       	stage.setTitle("Login View");
       	stage.setScene(scene);
       	stage.show();

} catch (Exception e) {
System.out.println("Error occured while inflating view: " + e);
}

}

	public static void main(String[] args) {
			launch(args);
		}
}
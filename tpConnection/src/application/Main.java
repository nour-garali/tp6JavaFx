package application;
	
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public void start(Stage primaryStage) throws IOException{
		try {
			Connection conn =Connexion.getCn();

			if (conn != null) {

			System.out.println("Database connected!");

			} else {

			System.out.println("Database connection failed!");

			}


			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

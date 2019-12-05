package controllers;

import java.sql.SQLException;
import java.sql.Statement;

import application.Main;
import dao.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.AdminModel;

public class AdminController {
	
	@FXML
	private Pane pane1;
	@FXML
	private Pane pane2;
	@FXML
	private Pane pane3;
	@FXML
	private TextField txtmovieID;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtRating;
	@FXML
	private TextField txtGenre;
	@FXML
	private TextField txtPrice;

	//private AdminModel am;
	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	public AdminController() {
		//am = new AdminModel();
		conn = new DBConnect();
	}

//	public void updateMovie() {
//		pane3.setVisible(false);
//		pane2.setVisible(false);
//		pane1.setVisible(true);
//	}
//	public void deleteMovie() {
//		pane1.setVisible(false);
//		pane2.setVisible(true); 
//		pane3.setVisible(false);
//	}
//
//	public void addMovie() {
//		pane1.setVisible(false); 
//		pane2.setVisible(false);
//		pane3.setVisible(true);
//	}
	
	public void addSnacks(String name, String type, String cost) {
		try {
		AnchorPane root;
		root = (AnchorPane)  FXMLLoader.load(getClass().getResource("/views/addSnacks.fxml"));
				Main.stage.setTitle("Admin View");
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
}
	
	public void directSnack() {
		try {
		AnchorPane root;
		root = (AnchorPane)  FXMLLoader.load(getClass().getResource("/views/addSnacks.fxml"));
				Main.stage.setTitle("Add Snacks View");
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
}
	public void addBeverages() {
		try {
		AnchorPane root;
		root = (AnchorPane)  FXMLLoader.load(getClass().getResource("/views/addBeverages.fxml"));
				Main.stage.setTitle("Add Bevereges View");
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
}
	
	public void back() {
		try {
		AnchorPane root;
		root = (AnchorPane)  FXMLLoader.load(getClass().getResource("/views/AdminView.fxml"));
				Main.stage.setTitle("Admin View");
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
}
//	public void submitMovie() {
//
//		// INSERT INTO Movie TABLE
//		try {
//		// Execute a query
//System.out.println("Inserting records into the table...");
//		stmt = conn.getConnection().createStatement();
//		String sql = null;
//
//		// Include all object data to the database table
//
//		sql = 
//"insert into pr_movie(MovieID, Name, Rating, Genre, Price) values ('" +txtmovieID.getText()+ "','" +txtName.getText()+ "','" +txtRating.getText()+"','" +txtGenre.getText()+"', '" +txtPrice.getText()+"')";
//		stmt.executeUpdate(sql);
//		System.out.println("Movie record created");
//
//		conn.getConnection().close();
//		} catch (SQLException se) {
//		se.printStackTrace();
//		}
//	}
//
//	public void submitUpdate() {
//
//	System.out.println("Update Submit button pressed");
//
//	}
//
//	public void submitDelete() {
//
//		System.out.println("Delete Submit button pressed");
//
//	}
	public void adminlogout() {
		try {
			AnchorPane root;
			root = (AnchorPane)  FXMLLoader.load(getClass().getResource("/views/AdminView.fxml"));
			Main.stage.setTitle("Admin View");
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
}	
}
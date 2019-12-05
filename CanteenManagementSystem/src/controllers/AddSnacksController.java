package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Main;
import dao.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AddSnacksController extends DBConnect {
	@FXML
	private Pane pane1;
	@FXML
	private TextField sname;
	@FXML
	private TextField stype;
	@FXML
	private TextField scost;
	
	@SuppressWarnings("unused")
	//private AdminModel am;
	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	
//	public void updateSnacks() {
//		pane3.setVisible(false);
//		pane2.setVisible(false);
//		pane1.setVisible(true);
//	}
//	public void deleteSnacks() {
//		pane1.setVisible(false);
//		pane2.setVisible(true); 
//		pane3.setVisible(false);
//	}
//
//	public void addSnacks() {
//		pane1.setVisible(false); 
//		pane2.setVisible(false);
//		pane3.setVisible(true);
//	}
	
	@SuppressWarnings("unused")
	public void addSnacks() throws SQLException {
		
		String name=this.sname.getText();
		String type=this.stype.getText();
		String cost=this.scost.getText();
		addSnack(name,type,cost);
}
	@SuppressWarnings("unused")
	private boolean addSnack(String name, String type, String cost) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO snacks1 (Sname,Stype,Scost)" +"VALUES(?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, name);
           stmt.setString(2, type);
           stmt.setString(3, cost);          
           boolean rs = stmt.execute();
           Alert alert = new Alert(AlertType.INFORMATION);
   		alert.setTitle("New Snack Added!!!");
   		alert.setHeaderText("Add New snacks");
   		alert.setContentText("You just added a new snack!!!");
   		alert.showAndWait();
           return true;            
         }catch (SQLException e) {
        	e.printStackTrace();   
         }
       return false;
	}
	
	public AddSnacksController() {
		conn = new DBConnect();
		
	}

	public void logout() {
		 //System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/styles.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Login");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	public void back() {
		try {
		AnchorPane root;
		root = (AnchorPane)  FXMLLoader.load(getClass().getResource("/views/AdminView.fxml"));
				Main.stage.setTitle("Add Snacks View");
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
}
}
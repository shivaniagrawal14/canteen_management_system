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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RegistrationController extends DBConnect {
	@FXML
	private Pane pane1;
	@FXML
	private TextField customerName;
	@FXML
	private TextField customerAddress;
	@FXML
	private TextField customerContactNumber;
	@FXML
	private TextField zipcode;
	@FXML
	private TextField customerCountry;
	@FXML
	private TextField customerState;
	@FXML
	private PasswordField customerPassword;
	@FXML
	private TextField customerEmail;
	
	@SuppressWarnings("unused")
	//private AdminModel am;
	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	
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
	
	@SuppressWarnings("unused")
	public void submit() throws SQLException {
		
		String name=this.customerName.getText();
		String address=this.customerAddress.getText();
		String contact=this.customerContactNumber.getText();
		String zip=this.zipcode.getText();
		String country=this.customerCountry.getText();
		String state=this.customerState.getText();
		String email=this.customerEmail.getText();
		String password=this.customerPassword.getText();
		AddUser(name, address, contact, zip, country, state);
		Logincred(email,password);
}
	@SuppressWarnings("unused")
	private boolean AddUser(String name, String address, String contact, String zip, String country, String state) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO reg_customer (Name, Address, Contact, ZipCode, Country, State)" +"VALUES(?,?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, name);
           stmt.setString(2, address);          
           stmt.setString(3, contact);
           stmt.setString(4, zip);
           stmt.setString(5, country);
           stmt.setString(6, state);
           
           boolean rs = stmt.execute();
           Alert alert = new Alert(AlertType.INFORMATION);
   		alert.setTitle("Welcome!!!");
   		alert.setHeaderText("New user");
   		alert.setContentText("!!!");
   		alert.showAndWait();
           return true;            
         }catch (SQLException e) {
        	e.printStackTrace();   
         }
       return false;
	}
	@SuppressWarnings("unused")
	private boolean Logincred(String email, String password) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO login_user (Email, Password, User_type)" +"VALUES(?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, email);
           stmt.setString(2, password);
           stmt.setLong(3, 0);          
           boolean rs = stmt.execute();
           Alert alert = new Alert(AlertType.INFORMATION);
   		alert.setTitle("Welcome!!!");
   		alert.setHeaderText("New user");
   		alert.setContentText("!!!");
   		alert.showAndWait();
           return true;            
         }catch (SQLException e) {
        	e.printStackTrace();   
         }
       return false;
	}
	
	
	
	public RegistrationController() {
		conn = new DBConnect();
		//Alert alert = new Alert(AlertType.INFORMATION);
		//alert.setTitle("You want to add snacks or beverages?");
		//alert.setHeaderText("Add New Snacks or Beverages");
		//alert.setContentText("Select OK to add new Snacks or Beverages!!!");
		//alert.showAndWait();
	}

	public void logout() {
		 //System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Login");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
}
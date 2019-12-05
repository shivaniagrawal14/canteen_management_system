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

public class AddBeveragesController extends DBConnect {
	@FXML
	private Pane pane1;
	@FXML
	private TextField Bname;
	@FXML
	private TextField Btype;
	@FXML
	private TextField Bcost;
	
	@SuppressWarnings("unused")
	//private AdminModel am;
	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	
//	public void updateBeverages() {
//		pane3.setVisible(false);
//		pane2.setVisible(false);
//		pane1.setVisible(true);
//	}
//	public void deleteBeverages() {
//		pane1.setVisible(false);
//		pane2.setVisible(true); 
//		pane3.setVisible(false);
//	}
//
//	public void addBeverages() {
//		pane1.setVisible(false); 
//		pane2.setVisible(false);
//		pane3.setVisible(true);
//	}
	
	@SuppressWarnings("unused")
	
	public void addBeverages() throws SQLException {
		
		String name=this.Bname.getText();
		String type=this.Btype.getText();
		String cost=this.Bcost.getText();
		addBeverage(name,type,cost);
}
	@SuppressWarnings("unused")
	private boolean addBeverage(String name, String type, String cost) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Beverages (Bname,Btype,Bcost)" +"VALUES(?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, name);
           stmt.setString(2, type);
           stmt.setString(3, cost);          
           boolean rs = stmt.execute();
           Alert alert = new Alert(AlertType.INFORMATION);
   		alert.setTitle("New Beverages Added!!!");
   		alert.setHeaderText("Add New Beverages");
   		alert.setContentText("You just added a new Beverage!!!");
   		alert.showAndWait();
           return true;            
         }catch (SQLException e) {
        	e.printStackTrace();   
         }
       return false;
	}
	
	public AddBeveragesController() {
		conn = new DBConnect();
		
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
}
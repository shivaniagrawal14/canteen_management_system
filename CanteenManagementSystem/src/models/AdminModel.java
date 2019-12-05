package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DBConnect;

public abstract class AdminModel extends DBConnect{
	  
	@SuppressWarnings("unused")
	public AdminModel(String name, String type, String cost)
	{
		String query = "INSERT INTO snacks1 (Sname,Stype,Scost) VALUES(?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, name);
           stmt.setString(2, type);
           stmt.setString(3, cost);          
           int count = stmt.executeUpdate();
           return;            
         }catch (SQLException e) {
        	e.printStackTrace();   
         }
       return;
	}

}
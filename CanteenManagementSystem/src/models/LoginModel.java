package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBConnect;

public class LoginModel extends DBConnect{
	private int id;
	private Boolean user_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean isAdmin() {
		return user_type;
	}
	public void setAdmin(Boolean user_type) {
		this.user_type = user_type;
	}
	
	public Boolean getCredentials(String email, String password){
           
           String query = "SELECT * FROM login_user WHERE Email = ? and Password = ?;";
            try(PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, email);
               stmt.setString(2, password);
               ResultSet rs = stmt.executeQuery();
                if(rs.next()) { 
                	setId(rs.getInt("id"));
                	setAdmin(rs.getBoolean("user_type"));
                	return true;
               	}
             }catch (SQLException e) {
            	e.printStackTrace();   
             }
	       return false;
    }
}
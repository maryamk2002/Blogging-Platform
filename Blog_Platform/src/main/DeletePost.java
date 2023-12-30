package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePost {
	public String removePost(int postId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost","root","");
        
        String deleteQuery = "DELETE FROM blogpost WHERE post_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
             preparedStatement.setInt(1, postId);
             preparedStatement.executeUpdate();
             return "Blog post deleted successfully!";
	} catch (SQLException e) {
		e.printStackTrace();
	}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	return "Unseccussful.";
}
}

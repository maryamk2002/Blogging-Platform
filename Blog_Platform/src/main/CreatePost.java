package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatePost {
	public String addPost(int authorId, String title, String content)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost","root","");
		
		String insertQuery = "INSERT INTO blogpost (author_id, title, content, status, analysis_result) VALUES (?, ?, ?, 'pending', null)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, authorId);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, content);

            preparedStatement.executeUpdate();
            return "Blog post created successfully!";
        } catch (SQLException e) {
			e.printStackTrace();
		}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return "Unseccussful.";
	}
}

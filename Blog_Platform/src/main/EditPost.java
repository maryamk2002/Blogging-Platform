package main; 

import java.sql.*;

public class EditPost {

    public String editPost(int authorId, int postId, String updatedTitle, String updatedContent) {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost","root","");
           
            PreparedStatement selectStatement = connection.prepareStatement("SELECT title, content FROM blog WHERE post_id = ? AND author_id = ?");
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE blog SET title = ?, content = ? WHERE post_id = ? AND author_id = ?");

            // Retrieve post details
            selectStatement.setInt(1, postId);
            selectStatement.setInt(2, authorId);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                // Post found, display current details
                String currentTitle = resultSet.getString("title");
                String currentContent = resultSet.getString("content");

                // Get updated details from the user
                updateStatement.setString(1, updatedTitle);
                updateStatement.setString(2, updatedContent);
                updateStatement.setInt(3, postId);
                updateStatement.setInt(4, authorId);
                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    // Return a message with both current and updated details
                    return "Post updated successfully!\nPreviour Title: " + currentTitle + "\nPrevious Content: " + currentContent;
                } else {
                    return "No matching post found for the given Author ID and Post ID.";
                }
            } else {
                return "No matching post found for the given Author ID and Post ID.";
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "Error occurred while updating the post.";
        }
    }
}

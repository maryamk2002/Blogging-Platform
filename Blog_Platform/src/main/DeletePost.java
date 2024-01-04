package main;

import java.sql.*;

public class DeletePost {
    public String removePost(int authorId, int postId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");

      
            if (!isAuthorExists(connection, authorId)) {
                return "Author does not exist. Unable to delete the post.";
            }

            String deleteQuery = "DELETE FROM blog WHERE post_id = ? AND author_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, postId);
                preparedStatement.setInt(2, authorId);
                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    return "Blog post deleted successfully!";
                } else {
                    return "Post not found for the given author ID and post ID.";
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "Unsuccessful.";
        }
    }

    // Helper method to check if the author exists
    private boolean isAuthorExists(Connection connection, int authorId) throws SQLException {
        String checkAuthorQuery = "SELECT 1 FROM author WHERE author_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(checkAuthorQuery)) {
            preparedStatement.setInt(1, authorId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Returns true if the author exists
            }
        }
    }
}

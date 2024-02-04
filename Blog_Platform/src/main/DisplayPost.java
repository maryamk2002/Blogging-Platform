package main;

import java.sql.*;

public class DisplayPost {
    public String displayPost(int authorId, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Use try-with-resources to ensure the Connection is closed
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "")) {
                PreparedStatement preparedStatement = con.prepareStatement(
                        "SELECT b.post_id,a.author_name, b.title, b.content FROM blog b JOIN author a ON b.author_id = a.author_id WHERE a.author_id = ? AND a.password = ?");
                preparedStatement.setInt(1, authorId);
                preparedStatement.setString(2, password);
                ResultSet rs = preparedStatement.executeQuery();

                StringBuilder result = new StringBuilder();

                while (rs.next()) {
                	 result.append("\n").append("<strong>Post ID:</strong>").append("<strong>").append(rs.getInt("post_id")).append("</strong>").append("\n").append("\n")
                     .append(" Author Name: ").append(rs.getString("author_name")).append("\n").append("\n")
                     .append(" Title: ").append(rs.getString("title")).append("\n").append("\n")
                     .append(" Content:").append(rs.getString("content")).append("\n");
                }

                if (result.length() == 0) {
                    // No posts found for the given authorId and password
                    return "No posts found for the provided credentials.";
                }

                return result.toString();
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Log the exception or throw a custom exception with a meaningful message
            e.printStackTrace();
            return "An error occurred while processing the request.";
        }
    }
    public String getAndDisplayPosts(int authorId, String password) {
        String posts = displayPost(authorId, password);
        return posts;
    }
}

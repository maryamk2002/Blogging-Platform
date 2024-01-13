package main;

import java.sql.*;

public class moderateBlog {

    public String blogModeration(int postId, String moderationDecision, String rejectionReason) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");
            String selectQuery = "SELECT post_id, title, content FROM blog WHERE post_id = ? AND status = 'Pending'";
            try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
                selectStatement.setInt(1, postId);
                ResultSet rs = selectStatement.executeQuery();

                if (rs.next()) {
                    int selectedPostId = rs.getInt("post_id");

                    if ("Rejected".equals(moderationDecision)) {
                        String updateQuery = "UPDATE blog SET status = 'Rejected', analysis_result = ? WHERE post_id = ?";
                        try (PreparedStatement updateStatement = con.prepareStatement(updateQuery)) {
                            updateStatement.setString(1, rejectionReason);
                            updateStatement.setInt(2, selectedPostId);
                            updateStatement.executeUpdate();
                        }
                    } else if ("Approved".equals(moderationDecision)) {
                        String updateQuery = "UPDATE blog SET status = 'Approved', analysis_result = NULL WHERE post_id = ?";
                        try (PreparedStatement updateStatement = con.prepareStatement(updateQuery)) {
                            updateStatement.setInt(1, selectedPostId);
                            updateStatement.executeUpdate();
                        }
                    }

                    return "Moderation completed for post with ID " + selectedPostId;
                } else {
                    return "No pending post found with ID " + postId;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error occurred during moderation.";
        }
    }
}

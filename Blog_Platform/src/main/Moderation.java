package main;
import java.sql.*;
import java.util.Scanner;

public class Moderation {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");
            System.out.println("Connected to the database successfully!");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM blog WHERE status = 'Pending'");

            boolean pendingPostsExist = false;

            while (rs.next()) {
                pendingPostsExist = true;
                int postId = rs.getInt("post_id");
                String content = rs.getString("content");

                System.out.println("Post ID: " + postId);
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Content: " + content);

                String moderationDecision = manuallyModerate(content);
                updateModerationResult(con, postId, moderationDecision);

                System.out.println("Moderation Result: " + moderationDecision);
                System.out.println("------------------------------");
            }

            if (!pendingPostsExist) {
                System.out.println("No pending posts.");
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static String manuallyModerate(String content) {
        System.out.println("Manually Moderate the Blog Post Content:");
        System.out.println("Content: " + content);

        System.out.print("Enter moderation decision (Approved/Rejected): ");
        String moderationDecision = scanner.nextLine().trim();

        if ("Rejected".equalsIgnoreCase(moderationDecision)) {
            System.out.print("Enter rejection reason: ");
            String rejectionReason = scanner.nextLine().trim();
            System.out.println("Blog Post Rejected. Reason: " + rejectionReason);
            return "Rejected-" + rejectionReason;
        } else {
            System.out.println("Blog Post Approved.");
            return "Approved";
        }
    }

    private static void updateModerationResult(Connection con, int postId, String moderationDecision) {
        try {
            Statement updateStmt = con.createStatement();
            String status = moderationDecision.split("-")[0];
            String analysisResult = moderationDecision.split("-")[1];
            String updateQuery = "UPDATE blog SET status = '" + status + "', analysis_result = '" + analysisResult + "' WHERE post_id = " + postId;
            int rowsUpdated = updateStmt.executeUpdate(updateQuery);

            if (rowsUpdated > 0) {
                System.out.println("Moderation result updated successfully!");
            } else {
                System.out.println("No rows updated. Post with ID " + postId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

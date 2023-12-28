package Post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class find_post {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter author name:");
            String authorName = scanner.nextLine();

            System.out.println("Enter post title:");
            String postTitle = scanner.nextLine();

            // Use a prepared statement to prevent SQL injection
            String query = "SELECT * FROM blogpost JOIN author ON blogpost.author_id = author.author_id WHERE author_name = ? AND title = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, authorName);
            pstmt.setString(2, postTitle);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Post found, display information
                System.out.println("Post found!");
                System.out.println("ID: " + rs.getInt("post_id") +
                        " Author: " + rs.getString("author_name") +
                        " Title: " + rs.getString("title") +
                        " Content: " + rs.getString("content"));
            } else {
                // Post not found, display error message
                System.out.println("Post not found in the database.");
            }

            con.close();
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }
}

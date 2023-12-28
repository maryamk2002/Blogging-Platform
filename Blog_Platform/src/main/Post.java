
package main;

import java.sql.*;
import java.util.Scanner;

public class Post{

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from blogpost");

            // Display existing blog posts
            displayBlogPosts(rs);

            // Create Operation
            createBlogPost(con);

            // Display updated blog posts after creation
            rs = stmt.executeQuery("select * from blogpost");
            displayBlogPosts(rs);

            // Edit Operation
            editBlogPost(con);

            // Display updated blog posts after editing
            rs = stmt.executeQuery("select * from blogpost");
            displayBlogPosts(rs);

            // Delete Operation
            deleteBlogPost(con);

            // Display final blog posts after deletion
            rs = stmt.executeQuery("select * from blogpost");
            displayBlogPosts(rs);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayBlogPosts(ResultSet rs) throws SQLException {
        System.out.println("Existing Blog Posts:");
        while (rs.next()) {
            System.out.println("post_id: " + rs.getInt("post_id") +
                    " 	author_id: " + rs.getInt("author_id") +
                    " Content: " + rs.getString("content") +
                    " Title: " + rs.getString("title") +
                    " Timestamp: " + rs.getTimestamp("timestamp") +
                    " Status: " + rs.getString("status") +
                    " Analysis Result: " + rs.getString("analysis_result"));
        }
        System.out.println();
    }

    private static void createBlogPost(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your author ID: ");
        int authorId = scanner.nextInt();

        if (!authorExists(authorId, connection)) {
            System.out.println("Author does not exist. Terminating...");
            return;
        }

        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter title of the blog post: ");
        String title = scanner.nextLine();
        System.out.print("Enter content of the blog post: ");
        String content = scanner.nextLine();

        // Timestamp can be generated using the current time
        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());

        // Insert into blogpost table
        String insertQuery = "INSERT INTO blogpost (author_id, title, content, timestamp, status, analysis_result) VALUES (?, ?, ?, ?, 'pending', null)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, authorId);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, content);
            preparedStatement.setTimestamp(4, timestamp);

            preparedStatement.executeUpdate();
            System.out.println("Blog post created successfully!");
        }
    }

    private static void editBlogPost(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your author ID: ");
        int authorId = scanner.nextInt();

        if (!authorExists(authorId, connection)) {
            System.out.println("Author does not exist. Terminating...");
            return;
        }

        System.out.print("Enter the post ID you want to edit: ");
        int postId = scanner.nextInt();

        if (!postExists(postId, connection)) {
            System.out.println("Post does not exist. Terminating...");
            return;
        }

        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter new title of the blog post: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new content of the blog post: ");
        String newContent = scanner.nextLine();

        // Timestamp can be generated using the current time
        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());

        // Update the blogpost table
        String updateQuery = "UPDATE blogpost SET title = ?, content = ?, timestamp = ?, status = 'pending', analysis_result = null WHERE post_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newTitle);
            preparedStatement.setString(2, newContent);
            preparedStatement.setTimestamp(3, timestamp);
            preparedStatement.setInt(4, postId);

            preparedStatement.executeUpdate();
            System.out.println("Blog post edited successfully!");
        }
    }

    private static void deleteBlogPost(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your author ID: ");
        int authorId = scanner.nextInt();

        if (!authorExists(authorId, connection)) {
            System.out.println("Author does not exist. Terminating...");
            return;
        }

        System.out.print("Enter the post ID you want to delete: ");
        int postId = scanner.nextInt();

        if (!postExists(postId, connection)) {
            System.out.println("Post does not exist. Terminating...");
            return;
        }

        System.out.print("Do you want to delete the post? (yes/no): ");
        String response = scanner.next().toLowerCase();

        if (response.equals("yes")) {
            // Delete the post from the blogpost table
            String deleteQuery = "DELETE FROM blogpost WHERE post_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, postId);
                preparedStatement.executeUpdate();
                System.out.println("Blog post deleted successfully!");
            }
        } else {
            System.out.println("Operation canceled. No changes made.");
        }
    }

    private static boolean authorExists(int authorId, Connection connection) throws SQLException {
        String checkAuthorQuery = "SELECT * FROM author WHERE author_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(checkAuthorQuery)) {
            preparedStatement.setInt(1, authorId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    private static boolean postExists(int postId, Connection connection) throws SQLException {
        String checkPostQuery = "SELECT * FROM blogpost WHERE post_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(checkPostQuery)) {
            preparedStatement.setInt(1, postId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
}

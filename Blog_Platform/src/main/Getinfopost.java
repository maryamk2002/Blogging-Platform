package main;

import java.sql.*;

public class Getinfopost {

    public String searchPost(String author_name, String title) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");
            Statement stmt = con.createStatement();

            // Corrected SQL query
            String query = "SELECT post_id, author_name, title, content FROM blogpost JOIN author ON blogpost.author_id = author.author_id WHERE author_name = '" + author_name + "' OR title = '" + title + "'";

            ResultSet rs = stmt.executeQuery(query);

            StringBuilder result = new StringBuilder();

            while (rs.next()) {
                result.append("Post ID: ").append(rs.getInt("post_id")).append("\n")
                        .append(" Author Name: ").append(rs.getString("author_name")).append("\n")
                        .append(" Title: ").append(rs.getString("title")).append("\n")
                        .append(" Content:").append(rs.getString("content")).append("\n\n");
            }

            con.close();
            return result.toString();

        } catch (Exception e) {
            System.out.println(e);
        }
        return "Post not found.";
    }
}




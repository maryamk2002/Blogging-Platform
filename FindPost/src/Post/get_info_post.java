package Post;
import java.sql.*;
public class get_info_post {
public String searchPost(String author_name, String title) {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");
        Statement stmt = con.createStatement();
        
        // Corrected SQL query
        String query = "SELECT post_id, author_name, content FROM blogpost JOIN author ON blogpost.author_id = author.author_id WHERE author_name = '" + author_name + "' OR title = '" + title + "'";
        
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            return "ID: " + rs.getInt("post_id") + " Name: " + rs.getString("author_name") + " Content: " + rs.getString("content");
        }

        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    return "Post not found.";
}
}

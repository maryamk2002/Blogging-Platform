package main;
import java.sql.*;


public class view_Blog {
    public String viewBlog() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT post_id, author_name, title, content FROM blog JOIN author ON blog.author_id = author.author_id WHERE status = 'Pending'");
            boolean pendingPostsExist = false;

            StringBuilder result = new StringBuilder();

            while (rs.next()) {
                pendingPostsExist = true;
                result.append("Post ID: ").append(rs.getInt("post_id")).append("\n")
                        .append(" Author Name: ").append(rs.getString("author_name")).append("\n")
                        .append(" Title: ").append(rs.getString("title")).append("\n")
                        .append(" Content:").append(rs.getString("content")).append("\n\n");
                       
                
            }

            if (!pendingPostsExist) {
                return "No pending posts.";
            }

            return result.toString();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return "Program couldn't be executed";
    }
}

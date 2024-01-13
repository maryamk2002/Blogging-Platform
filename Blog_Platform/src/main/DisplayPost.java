package main;

<<<<<<<< HEAD:Blog_Platform/src/main/DisplayPost.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DisplayPost{
    public String displayPost(int authorId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");
            PreparedStatement preparedStatement = con.prepareStatement("SELECT b.post_id,a.author_name, b.title, b.content FROM blog b JOIN author a ON b.author_id = a.author_id WHERE a.author_id = ?");
            preparedStatement.setInt(1, authorId);
            ResultSet rs = preparedStatement.executeQuery();


            StringBuilder result = new StringBuilder();

            while (rs.next()) {
                
                result.append("Post ID: ").append(rs.getInt("post_id")).append("\n")
                        .append(" Author Name: ").append(rs.getString("author_name")).append("\n")
                        .append(" Title: ").append(rs.getString("title")).append("\n")
                        .append(" Content:").append(rs.getString("content")).append("\n\n");
                       
                
            }

            return result.toString();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return "Program couldn't be executed";
    }

}

}




package main;

import java.sql.*;

public class moderateBlog {

    public String blogModeration( String moderationDecision, String rejectionReason) {
    	
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogpost", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT post_id, title, content FROM blogpost WHERE status = 'Pending'");
            boolean pendingPostsExist = false;
  
      
      while (rs.next()) {
    	  pendingPostsExist = true; 
    	  int postId=rs.getInt("post_id");
    	 
    	
        
   if("Rejected".equals(moderationDecision)) {
	String updateQuery = "UPDATE blogpost SET status = 'Rejected', analysis_result = '" + rejectionReason + "' WHERE post_id = " + postId;
                stmt.executeUpdate(updateQuery);
                }
    else if("Approved".equals(moderationDecision)){
                String updateQuery = "UPDATE blogpost SET status = 'Approved', analysis_result = NULL WHERE post_id = " + postId;
               stmt.executeUpdate(updateQuery);
   }
    
   return "Moderation completed";
        }
      if (!pendingPostsExist) {
         return "No pending posts.";
      }

      } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return "Program couldn't be executed";
    }
}
    

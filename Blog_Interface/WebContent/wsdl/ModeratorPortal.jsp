
<%@ page import="resultmain.*" %>
<%@ page import="moderatemain.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>MODERATOR PORTAL</title>
</head>
<body>
    <h1>Welcome to your portal!</h1>
    <form action="">
        <%  
        String postId = request.getParameter("postId");
        String moderationDecision = request.getParameter("moderationDecision");
        String rejectionReason = request.getParameter("reason");
        String moderationResult = null;
        boolean inputError = false;
        if (postId == null || moderationDecision == null || postId.trim().isEmpty() || moderationDecision.trim().isEmpty()) {
            inputError = true;
        } else {
            ModerateBlog obj = new ModerateBlogProxy().getModerateBlog();
            moderationResult = obj.blogModeration(Integer.parseInt(postId), moderationDecision, rejectionReason);
        }

        View_Blog vb = new View_BlogProxy().getView_Blog();
        String view = vb.viewBlog();
     
         if(view.equals("No pending posts.")) { %>
          <p>No pending posts exist</p>
            
        <% } else { %>
           <label> All pending Blog Posts:</label>
            <br/>
            <p><%= view.replaceAll("\n", "<br/>")  %></p>

            <label>Enter PostID</label>
            <input name="postId" type="text"></input>
            <br/>
               <br/>
            <label>Enter Decision (Rejected/Approved)</label>
            <input name="moderationDecision" type="text"></input>
            <br/>
               <br/>
            <label>Enter rejection reason</label>
            <input name="reason" type="text"></input>
            <br/>
               <br/>
            <button type="submit">Submit Decision</button>
            <% if (inputError) { %>
                <p class="error-message">Post ID and Decision are required</p>
            <% } %>
        <% } %>

        <% if (moderationResult != null) { %>
            <p>Result: <%= moderationResult %></p>
        <% } %>
    </form>
</body>
</html>

<%@ page import="resultmain.*" %>
<%@ page import="moderatemain.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>MODERATOR PORTAL</title>
    <style>
       body {
          margin-top: 0;
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    background-color: #f4f4f4;
}

.container {
      margin-top: 0;
    text-align: center;
    max-width: 600px;
margin:0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
   margin-top: 0;
    color: #333;
}

label {

    display: block;
    margin-top: 10px;
    text-align: center;
    font-weight: bold;
}

input {
height: 25px;

    box-sizing: border-box;
    margin-bottom: 10px;
    padding: 11px;
}

.error-message {
    color: red;
    margin-top: 10px;
      text-align: center;
        margin-bottom: 100px;
}

button {
    padding: 8px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
}

button:hover {
    background-color: #45a049;
}
.button-container {
            text-align: center;
        }
        
    </style>
</head>
<body>
    <h1>Welcome to your portal!</h1>
    <form action="" method="post">
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
        %>

        <% if (view.equals("No pending posts.")) { %>
            <p>No pending posts exist</p>
        <% } else { %>
            <label>All pending Blog Posts:</label>
            <br/>
      
            <p><%= view.replaceAll("\n", "<br/>") %></p>
            <br>

  <div style="text-align: center;">
            <label for="postId">Enter Post ID:</label>
            <br>
            <input id="postId" name="postId" type="text" style="width: 100px;" required >
            <br/>

            <label for="moderationDecision">Enter Decision (Rejected/Approved):</label>
            <br>
  
            <select id="moderationDecision" name="moderationDecision"  style="font-size: 16px;" required>
                <option value="Approved">Approved</option>
                <option value="Rejected">Rejected</option>
            </select>
        
            <br/>

            <label for="reason">Enter rejection reason:</label>
            <br/>
            <input id="reason" name="reason" type="text" style="width: 250px;">
                </div>
            <br/>

             <div class="button-container">
            <button type="submit">Submit Decision</button>
        </div>

            <% if (moderationDecision != null && moderationDecision.equals("Rejected") && (rejectionReason == null || rejectionReason.trim().isEmpty())) { %>
                <p class="error-message">Rejection reason is required</p>
            <% } %>

            <% if (inputError) { %>
                <p class="error-message">Post ID and Decision are required</p>
            <% } %>
        <% } %>
    <br/> 
        <% if (moderationResult != null) { %>
       <p>Result: <%= moderationResult %></p>
        <% } %>
    </form>
</body>
</html>

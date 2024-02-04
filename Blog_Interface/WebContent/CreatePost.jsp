<%@ page import="main.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Author Portal</title>
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
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            margin-top: 0;
            color: #333;
        }

        .left-section,
        .right-section,
        .bottom-section {
            width: 100%;
            padding: 20px;
            box-sizing: border-box;
        }

        .left-section,
        .right-section {
            display: inline-block;
            vertical-align: top;
        }

        .left-section {
            width: 49%; /* Adjust as needed */
            margin-right: 2%;
        }

        .right-section {
            width: 49%; /* Adjust as needed */
            margin-left: 2%;
        }

        .bottom-section {
            width: 100%;
            margin-top: 20px; /* Add margin between bottom and other sections */
            text-align: center;
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

        .button-container {
            text-align: center;
            margin-bottom: 20px; /* Add margin to the button container */
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
    </style>
   
</head>
<body>

<%

    String authorIdStr = request.getParameter("authorId");
    String password = request.getParameter("password");
    
    String actionResult = "";
    int authorId = 0;
    int postId = 0;
    String display = "";
    boolean isAuthenticated = (session.getAttribute("authenticatedUser") != null);
    String authenticatedUser = (String) session.getAttribute("authenticatedUser");
   String authenticatedpass= (String)session.getAttribute("pass");

    // Check if the author is already authenticated
    if (!isAuthenticated && authorIdStr != null && !authorIdStr.isEmpty()) {
        authorId = Integer.parseInt(authorIdStr);
      
        DisplayPost displayPost = new DisplayPostProxy().getDisplayPost();
        display = displayPost.displayPost(authorId, password);

        if (!display.equals("No author exists.") && !display.equals("No posts found for the provided credentials.")) {
            // If the author exists, set authenticatedUser and mark as authenticated
            isAuthenticated = true;
            authenticatedUser = authorIdStr;
            authenticatedpass=password;
            session.setAttribute("authenticatedUser", authenticatedUser);
            session.setAttribute("pass", authenticatedpass);
        }
    }

    // Check if the author is authenticated
    if (isAuthenticated) {
        // Handle create, edit, or delete actions
    
        String action = request.getParameter("action");
   

        if (action != null && !action.isEmpty()) {
        	
        	DisplayPost ds = new DisplayPostProxy().getDisplayPost();
            String title, content;
            
            if ("create".equals(action)) {
            
        	    authorId=Integer.parseInt(request.getParameter("createAuthorId"));
                title = request.getParameter("createTitle");
                content = request.getParameter("createContent");

                CreatePost createPost = new CreatePostProxy().getCreatePost();
                actionResult = createPost.addPost(authorId, title, content);
                display = ds.displayPost(Integer.parseInt(authenticatedUser), authenticatedpass);
                
              
                
             
            } else if ("edit".equals(action)) {
            	
        	    authorId=Integer.parseInt(request.getParameter("editAuthorId"));
                postId = Integer.parseInt(request.getParameter("editPostId"));
                title = request.getParameter("editTitle");
                content = request.getParameter("editContent");

                EditPost editPost = new EditPostProxy().getEditPost();
                actionResult = editPost.editPost(authorId, postId, title, content);
                display = ds.displayPost(Integer.parseInt(authenticatedUser), authenticatedpass);
                
                
                
               
            } else if ("delete".equals(action)) {
            
        	
        	    authorId=Integer.parseInt(request.getParameter("delauthorId"));
                postId = Integer.parseInt(request.getParameter("deletePostId"));

                DeletePost deletePost = new DeletePostProxy().getDeletePost();
                actionResult = deletePost.removePost(authorId, postId);

                display = ds.displayPost(Integer.parseInt(authenticatedUser), authenticatedpass);
                
               
                
               
            }
            display = ds.displayPost(Integer.parseInt(authenticatedUser), authenticatedpass);
           
        }
    	DisplayPost ds = new DisplayPostProxy().getDisplayPost();
        display = ds.displayPost(Integer.parseInt(authenticatedUser), authenticatedpass);
%>
<div style="text-align: center;">
    <h2>Welcome To Your Portal!</h2>
    <h2>Author ID: <%= authenticatedUser %></h2>
    <br><br>
    <h2 > Your Blog Posts:</h2>
</div>
<p><%= display.replaceAll("\n", "<br/>") %></p>

<hr>

<div class="left-section">
    <!-- Create Post Form -->
    <form action="CreatePost.jsp" method="post">
        <h2>Create Post</h2>
        <input type="hidden" name="createAuthorId" value="<%= authenticatedUser %>">
        <label style="text-align: left;">Title:</label>
        <input type="text" name="createTitle" required>
        <br><br>
        <label style="text-align: left;">Content:</label>
        <textarea name="createContent" rows="5" cols="40" style="width: 100%; resize: none;" required></textarea>
        <br><br>
        <div class="button-container">
            <button type="submit" name="action" value="create">Create Post</button>
        </div>
    </form>
</div>

<div class="left-section">
    <!-- Edit Post Form -->
    <form action="CreatePost.jsp" method="post">
        <h2>Edit Post</h2>
        <input type="hidden" name="editAuthorId" value="<%= authenticatedUser %>">
        <label style="text-align:left;">Post ID:</label>
        <input type="text" name="editPostId" required>
        <br><br>
        <label style="text-align: left;">New Title:</label>
        <input type="text" name="editTitle" required>
        <br><br>
        <label style="text-align: left;">New Content:</label>
        <textarea name="editContent" rows="5" cols="40" style="width: 100%; resize: none;" required></textarea>
        <br><br>
        <div class="button-container">
            <button type="submit" name="action" value="edit">Edit Post</button>
        </div>
    </form>
</div>

<div class="right-section">
    <!-- Delete Post Form -->
    <form action="CreatePost.jsp" method="post">
        <h2>Delete Post</h2>
        <input type="hidden" name="delauthorId" value="<%= authenticatedUser %>">
        <label style="text-align:left;">Post ID:</label>
        <input type="text" name="deletePostId" required>
        <br><br>
       
            <button type="submit" name="action" value="delete">Delete Post</button>
     
    </form>
</div>
    <!-- Logout Button -->
    <form action="" method="post">
     <div class="button-container">
        <button type="submit" name="action" value="logout">Logout</button>
        </div>
    </form>
<% } else { %>
<div style="text-align: center;">
    <!-- Form to enter author ID and password -->
    <form action="" method="post">
        <label>Enter Author ID:</label>
        <input type="text" name="authorId" required>
        <br><br>
        <label>Password:</label>
        <input type="password" name="password" required>
        <br><br>
         <div class="button-container">
        <button type="submit">Login</button>
        </div>
    </form>
<% } %>
</div>
<%
    // Handle logout action
    String logoutAction = request.getParameter("action");
    if ("logout".equals(logoutAction)) {
        // Invalidate the session and redirect to the current page
        session.invalidate();
        response.sendRedirect(request.getRequestURI());
    }
%>

<% if (!actionResult.isEmpty()) { %>
    <hr>
    <p><%= actionResult.replaceAll("\n", "<br/>") %></p>
  
<% } %>

</body>
</html>

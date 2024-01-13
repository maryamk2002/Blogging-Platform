<%@ page import="main.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blog Platform</title>
</head>
<body>

<%
    // Handle the display logic
    String authorIdStr = request.getParameter("authorId");
    String displayResult = "";
    String actionResult = "";
    int authorId = 0;
    int postId = 0;

    // Flag to check if the author exists
    boolean authorExists = false;

    if (authorIdStr != null && !authorIdStr.isEmpty()) {
        authorId = Integer.parseInt(authorIdStr);
        DisplayPost displayPost = new DisplayPostProxy().getDisplayPost();
        displayResult = displayPost.displayPost(authorId);

        if (!displayResult.equals("No author exists.")) {
            authorExists = true;
            
        
        }
    }
%>

<hr>

<!-- Form to enter author ID and display posts -->
<form action="" method="post">
    <label>Enter Author ID:</label>
     <br>
      
    <input type="text" name="authorId" required>
    <br>
     <br>
    <button type="submit">Display Posts</button>
</form>

<%
    if (authorExists) {
%>

<hr>

<!-- Form to create a new post -->
<form action="" method="post">
 <br>
    <h2>Create Post</h2>
    <label>Author ID:</label>
     <br>
    <input type="text" name="createAuthorId" value="<%= authorId %>" readonly>
    <br>
     <br>
    <label>Title:</label>
    <input type="text" name="createTitle" required>
    <br>
     <br>
    <label>Content:</label>
    <textarea name="createContent" rows="4" required></textarea>
    <br>
     <br>
    <button type="submit" name="action" value="create">Create Post</button>
</form>

<hr>

<!-- Form to edit an existing post -->
<form action="" method="post">
 <br>
    <h2>Edit Post</h2>
    
    <label>Author ID:</label>
     <br>
    <input type="text" name="editAuthorId" value="<%= authorId %>" readonly>
    <br>
     <br>
    <label>Post ID:</label>
    <input type="text" name="editPostId" required>
    <br>
     <br>
    <label>New Title:</label>
    <input type="text" name="editTitle" required>
    <br>
     <br>
    <label>New Content:</label>
    <textarea name="editContent" rows="4" required></textarea>
    <br>
     <br>
    <button type="submit" name="action" value="edit">Edit Post</button>
</form>

<hr>

<!-- Form to delete an existing post -->
<form action="" method="post">
 <br>
    <h2>Delete Post</h2>
     <br>
    <label>Post ID:</label>
     <br>
      <br>
    <input type="text" name="deletePostId" required>
    <br>
     <br>
    <button type="submit" name="action" value="delete">Delete Post</button>
</form>

<%
    }
%>

<%
    // Handle create, edit, or delete actions
    String action = request.getParameter("action");

    if (action != null && !action.isEmpty()) {
    	 DisplayPost displayPost = new DisplayPostProxy().getDisplayPost();

        String title, content;

        if ("create".equals(action)) {
            authorId = Integer.parseInt(request.getParameter("createAuthorId"));
            title = request.getParameter("createTitle");
            content = request.getParameter("createContent");

            CreatePost createPost = new CreatePostProxy().getCreatePost();
            actionResult = createPost.addPost(authorId, title, content);
            displayResult = displayPost.displayPost(authorId);
        } else if ("edit".equals(action)) {
            authorId = Integer.parseInt(request.getParameter("editAuthorId"));
            postId = Integer.parseInt(request.getParameter("editPostId"));
            title = request.getParameter("editTitle");
            content = request.getParameter("editContent");

            EditPost editPost = new EditPostProxy().getEditPost();
            actionResult = editPost.editPost(authorId, postId, title, content);
            displayResult = displayPost.displayPost(authorId);
        } else if ("delete".equals(action)) {
     
            postId = Integer.parseInt(request.getParameter("deletePostId"));

            DeletePost deletePost = new DeletePostProxy().getDeletePost();
            actionResult = deletePost.removePost(postId);
            displayResult = displayPost.displayPost(authorId);
            
        }
        
        // Display posts after the action
       
        displayResult = displayPost.displayPost(authorId);
    }
%>

<%
    if (!displayResult.isEmpty()) {
%>
    <hr>
    <p><%= displayResult.replaceAll("\n", "<br/>") %></p>
<%
    }
%>

<%
    if (!actionResult.isEmpty()) {
%>
    <hr>
    <p><%= actionResult.replaceAll("\n", "<br/>") %></p>
     <p><%= displayResult.replaceAll("\n", "<br/>") %></p>
<%
    }
%>

</body>
</html>
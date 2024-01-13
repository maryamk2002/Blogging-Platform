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
   
    String authorIdStr = request.getParameter("authorId");
    String password = request.getParameter("password");
    String displayResult = "";
    String actionResult = "";
    int authorId = 0;
    int postId = 0;


    boolean authorExists = false;


    if (authorIdStr != null && !authorIdStr.isEmpty()) {
        authorId = Integer.parseInt(authorIdStr);
        DisplayPost displayPost = new DisplayPostProxy().getDisplayPost();
        displayResult = displayPost.displayPost(authorId, password);

        if (!displayResult.equals("No author exists.") && !displayResult.equals("No posts found for the provided credentials.")) {
            authorExists = true;
            
       
        }
    }
%>

<hr>

<%
    if (!authorExists) {
        // If author doesn't exist, show the form to enter authorId and password
%>
        <!-- Form to enter author ID and password -->
        <form action="" method="post">
            <label>Enter Author ID:</label>
            <input type="text" name="authorId" required>
            <br>
                       <br>
            <label>Password:</label>
            <input type="password" name="password" required>
            <br>
                      <br>
            <button type="submit">Display Posts</button>
        </form>
<%
    } else {
      
%>
        <h2>Welcome To Your Portal!</h2>
        <h2>Author ID: <%= authorId %></h2>
        <p><%= displayResult.replaceAll("\n", "<br/>") %></p>
<%
    }
%>

<hr>

<%
    if (authorExists) {
      
%>
        <!-- Form to create a new post -->
        <form action="" method="post">
            <h2>Create Post</h2>
                       <br>
            <label>Author ID:</label>
                       <br>
            <input type="text" name="createAuthorId" value="<%= authorId %>" readonly>
            <br>
                       <br>
            <label>Title:</label>
                       <br>
            <input type="text" name="createTitle" required>
            <br>
                       <br>
            <label>Content:</label>
                       <br>
            <textarea name="createContent" rows="4" required></textarea>
            <br>
                       <br>
            <button type="submit" name="action" value="create">Create Post</button>
                       <br>
        </form>

        <!-- Form to edit an existing post -->
        <form action="" method="post">
            <h2>Edit Post</h2>
                       <br>
            <label>Author ID:</label>
                                  <br>
            <input type="text" name="editAuthorId" value="<%= authorId %>" readonly>
            <br>
                       <br>
            <label>Post ID:</label>
                       <br>
            <input type="text" name="editPostId" required>
            <br>
                       <br>
            <label>New Title:</label>
                       <br>
            <input type="text" name="editTitle" required>
            <br>
                       <br>
            <label>New Content:</label>
              <br>
            <textarea name="editContent" rows="4" required></textarea>
            <br>
                       <br>
            <button type="submit" name="action" value="edit">Edit Post</button>
                       <br>
        </form>

        <!-- Form to delete an existing post -->
        <form action="" method="post">
            <h2>Delete Post</h2>
                       <br>
            <label>Post ID:</label>
                       <br>
            <input type="text" name="deletePostId" required>
            <br>           <br>
            <button type="submit" name="action" value="delete">Delete Post</button>
                       <br>
        </form>
<%
    }
%>

<%
    // Handle create, edit, or delete actions
    String action = request.getParameter("action");

    if (action != null && !action.isEmpty()) {

        String title, content;

        if ("create".equals(action)) {
            authorId = Integer.parseInt(request.getParameter("createAuthorId"));
            title = request.getParameter("createTitle");
            content = request.getParameter("createContent");

            CreatePost createPost = new CreatePostProxy().getCreatePost();
            actionResult = createPost.addPost(authorId, title, content);
        } else if ("edit".equals(action)) {
            authorId = Integer.parseInt(request.getParameter("editAuthorId"));
            postId = Integer.parseInt(request.getParameter("editPostId"));
            title = request.getParameter("editTitle");
            content = request.getParameter("editContent");

            EditPost editPost = new EditPostProxy().getEditPost();
            actionResult = editPost.editPost(authorId, postId, title, content);
        } else if ("delete".equals(action)) {
            authorId = Integer.parseInt(authorIdStr);
            postId = Integer.parseInt(request.getParameter("deletePostId"));

            DeletePost deletePost = new DeletePostProxy().getDeletePost();
            actionResult = deletePost.removePost(postId);
        }
  
        DisplayPost displayPost = new DisplayPostProxy().getDisplayPost();
        displayResult = displayPost.displayPost(authorId, password);
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
<%
    }
%>

</body>
</html>

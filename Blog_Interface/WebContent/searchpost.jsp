<%@page import="getpost.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Search Post</title>
</head>
<body>
    <h1>Search Post</h1>

    <%  
    String authorName = request.getParameter("authorName");
    String title = request.getParameter("title");
    String searchResult = null;

    if (authorName != null || title != null) {
    	Getinfopost obj = new GetinfopostProxy().getGetinfopost();
        searchResult = obj.searchPost(authorName, title);
    }
    %>

    <form action="" method="post">
        <label>Search either by author name or title.</label>
        <br/> <br/>
        <label>Enter Author Name:</label>
        <input name="authorName" type="text"></input>
        <br/> <br/>
        <label>Enter Title:</label>
        <input name="title" type="text"></input>
        <br/> <br/>
        <button type="submit">Search Post</button>
    </form>

    <% if (searchResult != null && !searchResult.equals("Post not found.")) { %>
        <h2>Search Result:</h2>
        <p><%= searchResult.replaceAll("\n", "<br/>") %></p>
    <% } else if (searchResult != null) { %>
        <p>No blog exists with this title or author.</p>
    <% } %>
</body>
</html>
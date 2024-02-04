<%@page import="getpost.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Search Post</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        h1 {
            color: #333;
        }

        form {
            max-width: 400px;
            width: 100%;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        label {
            display: block;
            margin-top: 10px;
            color: #333;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        button {
            padding: 10px;
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

        h2 {
            color: #333;
            margin-top: 20px;
        }

        p {
            color: #333;
        }
    </style>
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

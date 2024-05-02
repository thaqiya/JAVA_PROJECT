<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Client</title>
    <style type="text/css">
    /* Global Styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f2e7ff; /* Lavender */
    margin: 0;
    padding: 0;
}

.container {
    width: 80%;
    margin: 20px auto;
    background-color: #e6d6ff; /* Lilac */
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #800080; /* Purple */
}

/* Form Styles */
.form-group {
    margin-bottom: 15px;
}

label {
    display: block;
    font-weight: bold;
    color: #4b0082; /* Indigo */
}

input[type="text"],
input[type="email"] {
    width: calc(100% - 10px);
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 3px;
}

button {
    padding: 10px 20px;
    background-color: #800080; /* Purple */
    color: #fff;
    border: none;
    border-radius: 3px;
    cursor: pointer;
}

button:hover {
    background-color: #4b0082; /* Indigo */
}

/* Table Styles */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    padding: 10px;
    border-bottom: 1px solid #ddd;
    text-align: left;
}

th {
    background-color: #e6d6ff; /* Lilac */
}

/* Link Styles */
a {
    color: #800080; /* Purple */
    text-decoration: none;
    display: inline-block;
    margin-top: 10px;
}

a:hover {
    text-decoration: underline;
}
    </style>
</head>
<body>
<%@ page import="java.util.List" %>
<%@ page import="JAVA_PROJECT.Client" %>
    <div class="container">
        <h2>Delete Client</h2>
        <form action="DeleteClientServlet" method="post">
            <div class="form-group">
                <label for="id">Select ID to Delete:</label>
                <select id="id" name="clientId" required>
                    <option value="">Select ID</option>
                    <% List<Integer> allClientIds = (List<Integer>) request.getAttribute("allClientIds");
                       if (allClientIds != null && !allClientIds.isEmpty()) {
                           for (Integer clientId : allClientIds) {
                    %>
                    <option value="<%= clientId %>"><%= clientId %></option>
                    <% }
                       } %>
                </select>
            </div>
            <div class="form-group">
                <button type="submit">Delete Client</button>
            </div>
        </form>
        <a href="home.html">Back to Home Page</a>
    </div>
</body>
</html>

<%-- 
    Document   : reset
    Created on : Nov 23, 2020, 10:44:56 PM
    Author     : 815000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Notes</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <p>Please enter your email address to reset your password.</p>
        <form action="reset" method="post">
            Email Address: <input type="text" name="email" value="${email}"><br><br>
            <input type="submit" value="Submit">
        </form>
        ${message}
    </body>
</html>

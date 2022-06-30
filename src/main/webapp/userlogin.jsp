<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${name}<br>
  <form action="search" method="post">
    ${error}<br>
    Enter title of book you would like to see <input type="text" name="title"><br>
    Enter category of book you would like to see <input type="text" name="category"><br>
    Enter subject of book you would like to see <input type="text" name="subject"><br>
    Enter author of book you would like to see <input type="text" name="author"><br>
    <input type="submit" value="search">
  </form>
  <form action="signout" method="post">
	<input type="submit" value="SignOut"><br>
  </form>
</body>
</html>
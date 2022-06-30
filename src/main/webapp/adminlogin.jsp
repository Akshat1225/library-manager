<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	welcome ${name}
	<br>
	<form action="add" method="post">
		Admin wants to Add Entry<br>
		<!--  Enter BookId <input type="text"name="bookId"><br>  -->
		 Title <input type="text"name="title"><br> 
		 Category <input type="text"name="category"><br> 
		 Subject <input type="text"name="subject"><br> 
		 Description <input type="text"name="description"><br> 
	     Author <input type="text"name="author"><br> 
		 Stock <input type="text"name="stock"><br> 
		 <input type="submit"><br>
	</form>
  <form action="adminsearch" method="post">
    Enter title of book you would like to see <input type="text" name="title"><br>
    Enter category of book you would like to see <input type="text" name="category"><br>
    Enter subject of book you would like to see <input type="text" name="subject"><br>
    Enter author of book you would like to see <input type="text" name="author"><br>
    <input type="submit" value="search">
  </form>
</body>
</html>
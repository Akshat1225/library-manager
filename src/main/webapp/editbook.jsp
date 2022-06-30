<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
    <style>
      table,
      th,
      td {
        padding: 10px;
        border: 1px solid black;
        border-collapse: collapse;
      }
    </style>
<body>
<table class="table table-striped">
            <thead>
                <tr class="tr tr-success">
                    <td>BookId</td>
                    <td>Title</td>
                    <td>Category</td>
                    <td>Subject</td>
                    <td>Description</td>
                    <td>Author</td>
                    <td>Stock</td>
                </tr>   
            </thead>
            <tbody>
                <c:forEach items="${adminlist}" var="temp">
                    <tr>
                        <td>${temp.bookId}</td>
                        <td>${temp.title}</td>
                        <td>${temp.category}</td>
                        <td>${temp.subject}</td>
                        <td>${temp.description}</td>
                        <td>${temp.author}</td>
                        <td>${temp.stock}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
<form action="update">
	If Admin wants to Update Entry <br>
	so, enter bookId and details to be changed <br>
	   Enter bookId <input type="text" name="bookId"><br> 
	   Enter change in Title <input type="text" name="title"><br> 
	   Enter change in Category <input type="text" name="category"><br> 
	   Enter change in Subject <input type="text" name="subject"><br> 
	   Enter change in Description <input type="text" name="description"><br>
	   Enter change in Author <input type="text" name="author"><br>
		<input type="submit"><br>
	</form>
	<form action="delete" method="post">
		If Admin wants to Delete Entry BookId is required<br>
		Enter BookId <input type="text" name="bookId"><br> 
		<input type="submit"><br>
	</form>
	<form action="changestock" method="post">
	If admin wants to change stock of book <br>
    Enter bookId of the book<input type="text" name="bookId"><br> 
	Enter change in Stock <input type="text" name="stock"><br>
	<input type="submit"><br>
	</form>
		<form action="signout" method="post">
	 <input type="submit" value="SignOut"><br>
	</form>
</body>
</html>
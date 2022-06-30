<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="error.jsp" %>
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
                <c:forEach items="${list}" var="temp">
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
<form action="rent">
Enter bookId for the book you want to rent <br>
<input type="text" name="bookId"><br>
${error}<br>
Enter time period(days) to rent maximum allowed is 62 days<br>
<input type="text" name="timePeriod"><br>
<input type="submit">
</form>
</body>
</html>
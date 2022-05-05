<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Confirm delete</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/pages/fragments/header.jsp"></jsp:include>
	<table class="table table-dark table-striped container-sm">
		<thead>
			<tr>
				<th scope="col">Pib</th>
				<th scope="col">Company id.number</th>
				<th scope="col">Address</th>
				<th scope="col">City</th>
			</tr>
		</thead>
		<tbody>
		
		<c:url value="/manufacturer/delete/confirm?id=${manufacturer.pib}" var="urlManufacturerDelete"></c:url>
			<tr>
				<td>${manufacturer.pib}</td>
				<td>${manufacturer.cid}</td>
				<td>${manufacturer.address}</td>
				<td>${manufacturer.city}</td>
			</tr>
			<tr>
				<td> 
				Are you sure ? 
				<form action="${urlManufacturerDelete}" method="post">
					  <input type="submit" class="btn btn-danger" value="Delete" name="option"/>
					  <input type="submit" class="btn btn-info" value="Cancel" name="option"/>
				</form>
				</td>
			</tr>
		</tbody>
	</table>
	<div class="col-6">
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
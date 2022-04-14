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

    <title>Home page</title>
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
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${manufacturers}" var="manufacturer">
		<c:url value="/application/manufacturer/delete?id=${manufacturer.id}" var="urlManufacturerDelete"></c:url>
		<c:url value="/application/manufacturer/edit?id=${manufacturer.id}" var="urlManufacturerEdit"></c:url>
			<tr>
				<td>${manufacturer.pib}</td>
				<td>${manufacturer.cid}</td>
				<td>${manufacturer.address}</td>
				<td>${manufacturer.city}</td>
				<td><a href="${urlManufacturerEdit}" class="link-warning">Edit</a> <a href="${urlManufacturerDelete}" class="link-danger">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="col-6 container-sm">
		<h4>Add new manufacturer:</h4>
		<c:url value="/application/manufacturer/add" var="urlManufacturerAdd"></c:url>
		<form action="${urlManufacturerAdd}" >
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">PIB
					address</label> <input type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" name="pib">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">CID</label>
				<input type="text" class="form-control"
					id="exampleInputPassword1" name="cid">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Address</label>
				<input type="text" class="form-control"
					id="exampleInputPassword1" name="address">
			</div>
			<div class="mb-3">
				<select class="form-select" aria-label="Default select example"
					name="city">
					<c:forEach items="${cities}" var="city">
						<option value="${city.zipCode}">${city}</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
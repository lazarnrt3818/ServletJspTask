<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Edit spring - manufacturer</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/pages/fragments/header.jsp"></jsp:include>
	<div class="col-6 container-sm">
		<h4>Edit manufacturer</h4>
		<c:url value="/manufacturer/edit/confirm" var="urlManufacturerEdit"></c:url>
		<form:form action="${urlManufacturerEdit}" method="post" modelAttribute="manufacturer">
			<div class="mb-3">
				<label for="pib" class="form-label">PIB</label> 
				<form:input type="text" class="form-control" id="pib" aria-describedby="emailHelp" path="pib" readonly="true"/>

			</div>
			<div class="mb-3">
				<label for="cid" class="form-label">CID</label>
				<form:input type="text" class="form-control" id="cid" aria-describedby="emailHelp" path="cid" readonly="true"/>
			</div>
			<div class="mb-3">
				<label for="address" class="form-label">Address</label>
				<form:input type="text" class="form-control" id="address" aria-describedby="emailHelp" path="address"/>
			</div>
			<div class="mb-3">
				<label for="city" class="form-label">City</label><br>
				<form:select path="city" id="city">
					<form:options items="${cities}" itemvalue="zipCode"
						itemLabel="name" />
				</form:select>
			</div>
			<input type="submit" class="btn btn-primary" name="option" value="Edit"/>
			<input type="submit" class="btn btn-danger" name="option" value="Cancel"/>
		</form:form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
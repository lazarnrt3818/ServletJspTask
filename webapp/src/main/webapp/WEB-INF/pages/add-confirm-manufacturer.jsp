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
	<style>
		.center{
			position:absolute;
			left:50%;
			top:50%;
			transform:translate(-50%,-50%);
		}
	</style>
    <title>Add manufacturer</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/pages/fragments/header.jsp"></jsp:include>
	<c:url value="/application/manufacturer/add/confirm" var="urlManufacturerEdit"></c:url>
	<div class="col-6 container-sm center">
		<form action="${urlManufacturerEdit }" >
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">PIB</label> 
				<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${manufacturer.pib}" readonly name="pib">

			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">CID</label>
				<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${manufacturer.cid}" readonly name="cid">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Address</label>
				<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${manufacturer.address}" readonly name="address">
			</div>
			<div class="mb-3">
				<input type="text" name="city" value="${manufacturer.city.zipCode}" readonly/>
			</div>
			<input type="submit" class="btn btn-primary" name="option" value="Confirm"/>
			<input type="submit" class="btn btn-danger" name="option" value="Cancel"/>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
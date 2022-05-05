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

    <title>Add manufacturer</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/pages/fragments/header.jsp"></jsp:include>
    
    
	<div class="col-6 container-sm center">
		<h4>Confirm - manufacturer</h4>
		<c:url value="/manufacturer/add/confirm" var="urlManufacturerConfirm"></c:url>
		<form:form action="${urlManufacturerConfirm}" method="post"  modelAttribute="manufacturer" >
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">PIB</label> 
				<form:input type="text" class="form-control" 
					id="exampleInputEmail1" aria-describedby="emailHelp" name="pib" path="pib" readonly="true"/>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">CID</label>
				<form:input type="text" class="form-control" 
					id="exampleInputPassword1" name="cid" path="cid" readonly="true"/>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Address</label>
				<form:input type="text" class="form-control"
					id="exampleInputPassword1" name="address" path="address" readonly="true"/>
			</div>
			<div class="mb-3">
			
			<form:input type="text" class="form-control" 
					id="exampleInputPassword1" name="city" path="city" readonly="true"/>
			</div>
			<button type="submit" class="btn btn-primary">Confirm</button>
		</form:form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
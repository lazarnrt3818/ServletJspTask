<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">WebApp</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        	
        	<c:url value="/login" var="urlLogin"></c:url>
        	<c:url value="/logout" var="urlLogout"></c:url>
       
        	<c:if test="${loginUser == null}" >
				<li class="nav-item"><a class="nav-link" href="${urlLogin}">Login</a></li>
			</c:if>

          	<c:if test="${loginUser != null}" >
          		 <li class="nav-item dropdown">
				    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">${loginUser.username}</a>
					    <ul class="dropdown-menu">
						      <li><a class="dropdown-item" href="${urlLogout}">Logout</a></li>
					    </ul>
				  </li>
          	</c:if>
          	</a>
       
      </ul>
    </div>
  </div>
</nav>
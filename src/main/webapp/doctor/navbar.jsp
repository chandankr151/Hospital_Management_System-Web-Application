<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/home.jsp"><i
			class="fa-solid fa-house-chimney-medical"></i>Medi Home</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="../home.jsp"><i
						class="fa-solid fa-right-to-bracket"></i>Home</a></li>

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="patient.jsp">PATIENT</a></li>

			</ul>
			<form class="d-flex">
				<!-- Example single danger button -->
				<div class="btn-group">
					<button type="button"
						class="btn btn-success dropdown-toggle bg-light text-dark"
						data-bs-toggle="dropdown" aria-expanded="false">
						<i class="fa-solid fa-user-tie"></i>${doctorObj.fullName}</button>
					<ul class="dropdown-menu">

						<li><a class="dropdown-item bg-light text-dark"
							href="../profile.jsp">Edit Profile</a></li>

						<li><a class="dropdown-item bg-danger text-white"
							href="../doctorLogout">Logout</a></li>

					</ul>
				</div>
			</form>
		</div>
	</div>
</nav>
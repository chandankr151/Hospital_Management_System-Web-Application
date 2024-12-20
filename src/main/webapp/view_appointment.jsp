<%@page import="com.entity.Appointment"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.*"%>
<%@page import="com.entity.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view user appointment</title>

<%@include file="component/allcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("images/hos2.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container-fluid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>

	<div class="container-fluid p-3">

		<div class="row">
			<div class="col-md-9">

				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appoint Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Status</th>

								</tr>

							</thead>

							<tbody>

								<%
									User user = (User)session.getAttribute("userObj");
									AppointmentDAO dao = new AppointmentDAO(DBConnect.getConnection());
									
									DoctorDao dao2 = new DoctorDao(DBConnect.getConnection());
									List<Appointment> list = dao.getAllAppointmentByLoginId(user.getId());
									
									for(Appointment ap : list) {
										Doctor d = dao2.getDoctorById(ap.getDoctorId());
									
								%>
								<tr>
									<th><%=ap.getFullName() %></th>
									<td><%=ap.getGender() %></td>
									<td><%=ap.getAge() %></td>
									<td><%=ap.getAppoinDate() %></td>
									<td><%=ap.getDiseases() %></td>
									<td><%=d.getFullName() %></td>
									<td>
								<%
									if("Pending".equals(ap.getStatus()))
									{ %>
									
									 <a href="#"
										class="btn btn-sm btn-warning"> Pending </a>
									 <% }else{  %>
									 
									  <%=ap.getStatus() %>
									
										<%} %>
								  </td>

								</tr>
								<% } %>
								
							</tbody>

							<tfoot>

							</tfoot>
						</table>

					</div>

				</div>

			</div>
			<div class="col-md-3 p-3">
				<img alt="imageAlternate" src="images/doct.jpg">
			</div>
		</div>

	</div>

	<%@include file="component/footer.jsp"%>
</body>
</html>
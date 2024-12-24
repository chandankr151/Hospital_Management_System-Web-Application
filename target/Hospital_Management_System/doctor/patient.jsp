<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Page</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="col-md-11 p-5">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				<c:if test="${not empty succMsg }">
				
					<p class="text-center fs-3 text-success"> ${succMsg }</p>
					<c:remove var="succMsg"/>
				</c:if>
				
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor Name</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						Doctor doct = (Doctor)session.getAttribute("doctorObj");
						
						AppointmentDAO dao = new AppointmentDAO(DBConnect.getConnection());
						List<Appointment> list = dao.getAllAppointmentByDoctorLogin(doct.getId());
						
						for (Appointment ap : list) {
					
						%>
						<tr>
							<th><%=ap.getFullName()%></th>
							<td><%=ap.getGender()%></td>
							<td><%=ap.getAge()%></td>
							<td><%=ap.getAppoinDate()%></td>
							<td><%=ap.getEmail()%></td>
							<td><%=ap.getPhNo()%></td>
							<td><%=ap.getDiseases()%></td>
							<td><%=doct.getFullName()%></td>
							<td><%=ap.getAddress()%></td>
							<td><%=ap.getStatus()%></td>
							
							<td>
								<a href="comment.jsp?id=<%=ap.getId() %>" class="btn btn-success btn-sm">Comment</a>
							</td>
						</tr>
						<%
						}
						%>


					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>
<%@page import="com.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Edit Profile</title>

<%@include file="../component/allcss.jsp"%>

<style type="text/css">
.containerbody {
	box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
}
</style>

</head>
<body>

	<%@include file="navbar.jsp"%>

	<div class="container  p-4">
		<div class="row">
			<div class="col-md-4 ">
				<div class="card containerbody">
					<p class="text-center fs-3 mt-5">Change Doctor Password</p>
					<c:if test="${not empty succMsg }">
						<p class="text-center text-success">${succMsg }</p>
						<c:remove var="succMsg" />
					</c:if>
					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger">${errorMsg }</p>
						<c:remove var="errorMsg " />

					</c:if>
					<div class="card-body">

						<form action="../doctorChangePass" method="post" class="px-4">
							<div class="mb-3 ">

								<label>Enter Old Password</label> <input type="text"
									name="oldPass" class="form-control" required>

							</div>

							<div class="mb-3 ">

								<label>Enter New Password</label> <input type="text"
									name="newPass" class="form-control" required>

							</div>

							<input type="hidden" value="${doctorObj.getId() }" name="uid">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>

			</div>

			<div class="col-md-5 offset-md-2  ">
				<div class="card containerbody">
					<div class="card-body">
						<p class="text-center fs-4">Edit Profile</p>

						<c:if test="${not empty succMsgd }">

							<p class="text-center text-success">${succMsgd }</p>
							<c:remove var="succMsgd" />

						</c:if>
						<c:if test="${not empty errorMsgd }">

							<p class="text-center text-danger">${errorMsg }</p>
							<c:remove var="errorMsgd " />

						</c:if>

						<form action="../doctorEditProfile" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control"
									value="${doctorObj.fullName }">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control"
									value="${doctorObj.dob }">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									name="qualification" type="text" class="form-control"
									value="${doctorObj.qualification }">
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									required class="form-control">

									<option>${doctorObj.specialist }</option>

									<%
									SpecialistDao dao = new SpecialistDao(DBConnect.getConnection());

									List<Specialist> list = dao.getAllSpecialist();

									for (Specialist s : list) {
									%>

									<option>
										<%=s.getSpecialistName()%></option>
									<%
									}
									%>

								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									required name="email" value="${doctorObj.email }"
									class="form-control" readonly>
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobno" class="form-control"
									value="${doctorObj.mobNo}">
							</div>

							<input type="hidden" value="${doctorObj.getId() }" name="uid">
							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>

					</div>

				</div>

			</div>

		</div>

	</div>
	<%@include file="../component/footer.jsp"%>
</body>
</html>
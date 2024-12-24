<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password Page</title>

<style>
.containerbody {
	box-shadow: rgba(0, 0, 0, 0.4) 0px 2px 4px, rgba(0, 0, 0, 0.3) 0px 7px
		13px -3px, rgba(0, 0, 0, 0.2) 0px -3px 0px inset;
}
</style>

<%@include file="component/allcss.jsp"%>
</head>

<body>
	<%@include file="component/navbar.jsp"%>

	<c:if test="${empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<div class="container mt-5 mb-4 p-4">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card containerbody">
					<p class="text-center fs-3 mt-5">Change Password</p>
					<c:if test="${not empty succMsg }">
						<p class="text-center text-success">${succMsg }</p>
						<c:remove var="succMsg" />
					</c:if>
					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger">${errorMsg }</p>
						<c:remove var="errorMsg " />

					</c:if>
					<div class="card-body">

						<form action="resetUserPass" method="post" class="px-4">
							<div class="mb-3 ">

								<label>Enter Old Password</label> <input type="text"
									name="oldPass" class="form-control" required>

							</div>

							<div class="mb-3 ">

								<label>Enter New Password</label> <input type="text"
									name="newPass" class="form-control" required>

							</div>

							<input type="hidden" value="${userObj.getId() }" name="uid">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>

			</div>

		</div>


	</div>


	<%@include file="component/footer.jsp"%>

</body>
</html>
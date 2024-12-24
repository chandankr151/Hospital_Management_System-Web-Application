<%@page import="java.sql.*"%>
<%@page import="com.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>home page</title>
<%@include file="component/allcss.jsp"%>
<link rel="icon" type="image/png" sizes="32x32"
	href="icons/medi-home.png">

<style type="text/css">
.carousel-item:after {
	content: " ";
	display: block;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background: rgba(0, 0, 0, 0.1);
}

.carousel-caption {
	top: 70%;
}

.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<!-- <h1>Welcome to Hospital Management System Projects</h1> -->
	<%-- <%
	Connection con = DBConnect.getConnection();
	if (con != null) {
		System.out.println("database connected successfully");
	}
	%> --%>
	<div id="carouselExampleControls" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="images/hos1.jpg" class="d-block w-100" height="500px"
					alt="...">
			</div>
			<div class="carousel-item">
				<img src="images/hos2.jpg" class="d-block w-100" height="500px"
					alt="...">
			</div>
			<div class="carousel-item">
				<img src="images/doc3.jpg" class="d-block w-100" height="500px"
					alt="...">
			</div>
			<div class="carousel-item">
				<img src="images/doc4.jpg" class="d-block w-100" height="500px"
					alt="...">
			</div>

		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<!--  ===============================================  -->
	<hr>
	<div class="container p-3">
		<p class="text-center fs-2 ">Key Features of our Hospital</p>

		<div class="row">
			<div class="col-md-8 p-5">
				<div class="row">
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">100% Safety</p>
								<p>Hospital safety is essential for patient well-being.
									Strict protocols, including infection control, accurate patient
									identification, and regular staff training, help minimize
									risks. Clear communication, proper equipment handling, and
									maintaining a safe environment ensure patients receive
									high-quality care. Commitment to safety protects both patients
									and healthcare professionals from harm.</p>
								<address>Delhi, India</address>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Clean Environment</p>
								<p>A clean hospital environment is essential for patient
									safety and infection prevention. Regular cleaning of surfaces,
									equipment, and high-touch areas, along with proper waste
									disposal, reduces the risk of infections. Maintaining hygiene
									in all hospital spaces promotes healing, enhances patient
									comfort, and ensures a safe, healthy environment for both
									patients and staff.</p>
								<address>Noida, India</address>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Friendly Doctors</p>
								<p>Medical research is vital for advancing healthcare in
									hospitals. It drives innovation, improves treatment options,
									and enhances patient outcomes. By supporting clinical studies
									and evidence-based practices, hospitals stay at the forefront
									of medical advancements, ensuring better care, more effective
									treatments, and improved management of patient health and
									hospital operations.</p>
								<address>Noida, India</address>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Medical Research</p>
								<p>Medical research is essential for hospital management,
									driving innovation in treatment, improving patient care, and
									enhancing healthcare outcomes. It supports evidence-based
									practices and helps hospitals stay at the forefront of medical
									advancements.</p>
								<address>Noida, India</address>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<img alt="" src="images/doct.jpg" height="350px" width="300px">
			</div>

		</div>
	</div>

	<!-- =====================OUT TEAM==================== -->
	
	<div class="container p-2">
    <p class="text-center fs-2">Our Team</p>

    <div class="row">
        <!-- Card 1: Dr. Renu Devi -->
        <div class="col-md-3 mb-4">
            <div class="card paint-card">
                <div class="card-body text-center">
                    <img src="images/doc1.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr. Renu Devi</p>
                    <p class="fs-7">(CEO & Chairman)</p>
                </div>
            </div>
        </div>

        <!-- Card 2: Dr. Shivnath DAS -->
        <div class="col-md-3 mb-4">
            <div class="card paint-card">
                <div class="card-body text-center">
                    <img src="images/doc2.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr. Shivnath DAS</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>

        <!-- Card 3: Dr. Malti DEVI -->
        <div class="col-md-3 mb-4">
            <div class="card paint-card">
                <div class="card-body text-center">
                    <img src="images/doc3.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr. Malti DEVI</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>

        <!-- Card 4: Dr. Shatrudhan DAS -->
        <div class="col-md-3 mb-4">
            <div class="card paint-card">
                <div class="card-body text-center">
                    <img src="images/doc4.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr. Shatrudhan DAS</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>

        <!-- Card 5: Dr. Chandan DAS -->
        <div class="col-md-3 mb-4">
            <div class="card paint-card">
                <div class="card-body text-center">
                    <img src="images/doc5.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr. Chandan DAS</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>

        <!-- Card 6: Dr. Mithun DAS -->
        <div class="col-md-3 mb-4">
            <div class="card paint-card">
                <div class="card-body text-center">
                    <img src="images/doc6.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr. Mithun DAS</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>

        <!-- Card 7: Dr. Samrat DAS -->
        <div class="col-md-3 mb-4">
            <div class="card paint-card">
                <div class="card-body text-center">
                    <img src="images/doc1.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr. Samrat DAS</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>

        <!-- Card 8: Dr. Ayush DAS -->
        <div class="col-md-3 mb-4">
            <div class="card paint-card">
                <div class="card-body text-center">
                    <img src="images/doc2.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr. Ayush DAS</p>
                    <p class="fs-7">(Chief Doctor)</p>
                </div>
            </div>
        </div>
    </div>
</div>
	

	<%@include file="component/footer.jsp"%>
</body>
</html>
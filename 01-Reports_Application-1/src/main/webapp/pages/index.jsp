<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reports Apps</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2 class="pb-3 pt-3">Reports Application</h2>


		<form:form action="search" modelAttribute="search" method="POST">
			<table>
				<tr>
					<td>Plan Name</td>
					<td><form:select path="planeName">
							<form:option value="">-Select-</form:option>
							<form:options items="${name}"></form:options>
						</form:select></td>


					<td>Plan Status</td>
					<td><form:select path="planeStatus">
							<form:option value="">-Select-</form:option>
							<form:options items="${status}"></form:options>
						</form:select></td>
					<td>Gender</td>

					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date"
							date-date-format="mm-dd-yyyy" /></td>

					<td>End Date:</td>
					<td><form:input path="endDate" type="date"
							date-date-format="mm-dd-yyyy" /></td>
				</tr>



				<tr>
				<td><a href="/" class="btn btn-secondary"> Reset</a></td>
				
					<td><input type="submit" value="Search"
						class="btn btn-primary"></td>


				</tr>

			</table>


		</form:form>
		<hr />

		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Citizen Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plane Statues</th>
					<th>Start Data</th>
					<th>End Date</th>
					<th>Benifit Amt</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
					<td>${index.count }</td>
					
						
						<td>${plan.citizenName }</td>
						<td>${plan.gender}</td>
						<td>${plan.planName }</td>
						<td>${plan.planStatus }</td>
						<td>${plan.planeStartDate }</td>
						<td>${plan.planeEndDate }</td>
						<td>${plan.benefitAmt }</td>


					</tr>



				</c:forEach>
				<tr>
				<c:if test="${empty plans }">
				<td colspan="8" style="text-align: center">No Record Found</td>
				</c:if>
				</tr>

			</tbody>
		</table>


		<hr />
		Export :<a href="excel">Excel</a> <a href="pdf">Pdf</a>
		<hr />



	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>
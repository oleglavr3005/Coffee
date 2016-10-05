<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<title>Administration page</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/r/bs-3.3.5/jqc-1.11.3,dt-1.10.8/datatables.min.js"></script>
<script type="text/javascript" charset="utf-8">
	window.onload = function() {
		//  var isValidData = '<c:out value="${AdminServlet.isValidData}" />';
		var mes = '${message}';
		if (mes)
			alert(mes);
	}
	$(document).ready(function() {
		$('#ingredients').DataTable();
	});

	function addAttr(event) {
		$('<input />').attr('type', 'hidden').attr('name', 'source').attr(
				'value', "addIngredients").appendTo('#form');
		return true;
	}
</script>
<style>
/* div.container { */
/*   display: none; }  */

/* div:target { */
/*   display: block; } */

/* div[id*=t]:target ~ #users { */
/*   display: none; } */
/* div[id*=tab]:target ~ #ingrs { */
/*   display: block; } */
</style>

</head>
<body>
	<c:if test="${role==2 }">
		<div id="page">

			<div>
				<jsp:directive.include file="header.jsp" />
				<div class="container">
					<!-- 					<div id="tab/ingrs"></div> -->
					<!-- 					<div id="tab/users"></div> -->
					<!-- 					<div id="tab"> -->
					<!-- 						<a href="#users">#users</a><b><a href="#tab/ingrs">#ingrs</a></b> -->

					<!-- 					</div> -->
					<div id="ingrs">
						<form action="<%=request.getContextPath()%>/administration"
							method="post" id="form" onsubmit="addAttr()">
							<table class="display" cellspacing="0" width="100%"
								id="ingredients">
								<thead align="left">
									<tr>
										<th align="left">Name</th>
										<th align="left">Amount</th>
										<th align="left">MaxAmount</th>
										<th align="left">NewAmount</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="ingr" items="${ingredients}" varStatus="loop">
										<tr>
											<td>${ingr.ingredientName}</td>
											<td>${ingr.amount}</td>
											<td>${ingr.maxAmount}</td>
											<td><input type="text" name="${ingr.ingredientName}"
												value="${ingr.amount}"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<button type="submit">Submit form</button>
							<div style="color: red; align: center">${message}</div>
						</form>
					</div>


					<div id="users">
						<form action="<%=request.getContextPath()%>/administration"
							method="post" id="form" onsubmit="addAttr()">

							<table class="display" cellspacing="0" width="100%"
								id="ingredients">
								<thead align="left">
									<tr>
										<th align="left">NAME</th>
										<th align="left">Amount</th>
										<th align="left">MaxAmount</th>
										<th align="left">NewAmount</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="ingr" items="${ingredients}" varStatus="loop">
										<tr>
											<td>${ingr.ingredientName}</td>
											<td>${ingr.amount}</td>
											<td>${ingr.maxAmount}</td>
											<td><input type="text" name="${ingr.ingredientName}"
												value="${ingr.amount}"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<button type="submit">Submit form</button>
							<div style="color: red; align: center">${message}</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
				// For demo to fit into DataTables site builder...
				$('#ingredients').removeClass('display').addClass(
						'table table-striped table-bordered');
			</script>
	</c:if>
</body>
</html>

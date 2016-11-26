<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu - Yay&#33;Koffee Website Template </title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="page">
		<div>
			<jsp:directive.include file="header.jsp"/>
			<div id="body">
				<div id="figure">
					<img src="<%=request.getContextPath()%>/images/headline-menu.jpg"
						alt="Image"> <span>Unique aroma of coffee...</span>
				</div>
				<div id="div1">
					<a href="menu.html" class="whatshot">What&#39;s Hot</a>
					<div>
						<ul>
							<c:forEach var="drink" items="${drinks}" varStatus="loop">
								<li><c:choose>
										<c:when test="${loop.index % 3 == 1}">
											<img src="<%=request.getContextPath()%>/images/coffee1.jpg"
												alt="Image">
										</c:when>
										<c:when test="${loop.index % 3 == 2}">
											<img src="<%=request.getContextPath()%>/images/coffee2.jpg"
												alt="Image">
										</c:when>
										<c:when test="${loop.index % 3 == 0}">
											<img src="<%=request.getContextPath()%>/images/coffee3.jpg"
												alt="Image">
										</c:when>
									</c:choose>
									<div>
										<a class="btn-lg" data-toggle="modal" href="#myModal">${drink.drinkName}</a>
										<p>Price = ${drink.price}</p>
									</div></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div id="confirm">
					<div style="width: 220px">
						<p class="order">
							${lang.youOrdered}: ${lang[drink.title]}
							<c:forEach var="ingr" items="${drink.ingrs}">
								<c:if test="${ingr.amount>0}">
									<br>
                        ${lang.with} ${ingr.amount}${lang.grOf} ${lang[ingr.title]} 
                    </c:if>
							</c:forEach>
						</p>
						<p class="info">
							Total cost: <span id="totalPrice"><fmt:formatNumber
									type="number" minFractionDigits="2" maxFractionDigits="2"
									value="${totalPrice}" /></span>
						</p>
						<c:if test="${!isSumOnAccount}">
							<p class="error">You don't have enough money</p>
						</c:if>
						<c:if test="${!isIngredients}">
							<p class="error">Sorry,we can't produce this drink now</p>
						</c:if>

						<c:if test="${isSumOnAccount}">
							<button type="button" class="btn btn-info btn-lg"
								data-toggle="modal" data-target="#myModal2">Confirm</button>
						</c:if>
						<button type="button" class="btn btn-info btn-lg"
							data-toggle="modal" data-target="#myModal1">Cancel</button>

						<!-- Trigger the modal with a button -->


					</div>
				</div>
			</div>
			<jsp:directive.include file="footer.jsp" />
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<div class="modal-content">
				<form id="buy"
					action="http://localhost:8080/EpamMarkTask4/BuyServlet"
					method="post" role="form">
					<div class="modal-body">
						<p>Purchase is confirmed!</p>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-default" data-dismiss="modal"
							value="OK">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal1" role="dialog">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<p>Purchase is cancelled!</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="ModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="http://localhost:8080/EpamMarkTask4/BuyServlet" class="form-horizontal" role="form"
					method="post">
					<div class="modal-footer">
							<button type="submit" class="btn btn-success">
								OK
							</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
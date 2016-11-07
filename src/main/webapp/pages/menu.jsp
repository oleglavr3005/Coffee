<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu-Yay&#33;Koffee Website Template</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	var total = 0;
	var basePrice = 0;
	var drinkName = "";
	function calcPrice() {
		var s = "0";
		var arrIngr = [];
		var arrPr = [];
		$('.slider').each(function(i, obj) {
			arrIngr.push($(obj).val());
		});
		total = basePrice;
		$('.pricecell').each(function(i, obj) {
			s += $(obj).text();
			console.log("s=" + s);
			arrPr.push($(obj).text());
			total = parseFloat(total) + arrIngr[i] * arrPr[i];
		});

		$('#total').html("total " + total.toFixed(2));
	}
	function startModal(event) {
		total = 0;
		total = $(event.target).next().text().split('=')[1];
		basePrice = total;
		drinkName = $(event.target).text()
		$('#total').html("total " + total);
		$('.slider').each(function(i, obj) {
			$(obj).val(0);
		});
	}
	function addDrink(event) {
		$('<input />').attr('type','hidden').attr('name','drink').attr(
				'value', drinkName).appendTo('#form');
		return true;
	}
</script>
</head>
<body>
	<div id="page">
		<div>
			<jsp:directive.include file="header.jsp" />
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
										<c:when test="${loop.index % 3== 0}">
											<img src="<%=request.getContextPath()%>/images/coffee3.jpg"
												alt="Image">
										</c:when>
									</c:choose>
									<div onclick="startModal(event)">
										<a class="btn-lg" data-toggle="modal" href="#myModal2">${drink.drinkName}</a>
										<p>Price = ${drink.price}</p>
									</div></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<jsp:directive.include file="footer.jsp" />
		</div>
	</div>
	<c:if test="${sessionScope.role != null}">
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="ModalLabel" aria-hidden="true"
			data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<form id="form" action="<%=request.getContextPath()%>/confirm"
						onsubmit="addDrink()" class="form-horizontal" role="form"
						method="get">
						<h3 style="margin-left: 30px;">Ingredients:</h3>
						<table id="order"
							style="margin-left: 30px; border-spacing: 6px 2px">
							<c:forEach var="ingr" items="${ingredients}">
								<tr>
									<td style="width: 90px;">${ingr.ingredientName}</td>
									<td>0<input type="range" class="slider"
										onchange="calcPrice()"
										style="width: 80%; margin-left: 5px; margin-right: 5px; display: inline;"
										name="${ingr.ingredientName}" max="3" width="6px" value="0"
										step="1">3
									</td>
									<td style="width: 50px;">Price =</td>
									<td class="pricecell" style="width: 51px;">${ingr.price}</td>
								</tr>
							</c:forEach>
						</table>

						<div class="modal-footer">
							<h2>
								<span id="total" style="color: black;">Total:</span>
							</h2>
							<button type="submit" class="btn btn-success">OK</button>
							<button type="button" data-dismiss="modal" class="btn">Cancel</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</c:if>
</body>
<script>
	$(document).ready(function() {
		$('#header ul li:nth-child(2)').addClass('current');
		$('#footer ul li:nth-child(2)').addClass('current');
	});
</script>
</html>
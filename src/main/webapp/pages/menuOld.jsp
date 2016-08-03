<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Menu - Yay&#33;Koffee Website Template</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<div id="page">
		<div>
			<jsp:directive.include file="header.jsp" />
			<div id="body">
				<div id="figure">
					<img src="<%=request.getContextPath()%>/images/headline-menu.jpg" alt="Image">
					<span>Unique aroma of coffee...</span>		
				</div>
				 <div id="contents">
            <h3>chooseDrink</h3>
            <form method='POST' action='confirm'>
                <select name='drink'>
                    <c:forEach var="drink" items="${drinks}">
                        <option value="${drink.drinkName}"><c:out value="${drink.drinkName}"/> 
                    </c:forEach>
                </select>
                <h3>Ingredients:</h3>
                <table id="order">
                <c:forEach var="ingr" items="${ingredients}">
                    <tr>
                        <td>${ingr.ingredientName}</td>
                        <td>0<input type="range" name="${ingr.ingredientName}" max="5" width="100px" value='0' step='1'>5</td>
                    <tr>
                </c:forEach>
                </table>
                <input type='submit' value='${lang.order}'>
            </form>
        </div>
				<div>
					<a href="menu.html" class="whatshot">What&#39;s Hot</a>
					<div>
						<ul>
							<li>
								<a href="index.html"><img src="<%=request.getContextPath()%>/images/coffee1.jpg" alt="Image"></a>
								<div>
									<a href="index.html">Lorem ipsum</a>
									<p>
										Lorem ipsum &#36;0.00
									</p>
								</div>
							</li>
							<li>
								<a href="index.html"><img src="<%=request.getContextPath()%>/images/coffee2.jpg" alt="Image"></a>
								<div>
									<a href="index.html">Dolor sit amet</a>
									<p>
										Lorem ipsum &#36;0.00
									</p>
								</div>
							</li>
							<li>
								<a href="index.html"><img src="<%=request.getContextPath()%>/images/coffee3.jpg" alt="Image"></a>
								<div>
									<a href="index.html">Donie quis</a>
									<p>
										Lorem ipsum &#36;0.00
									</p>
								</div>
							</li>
							<li>
								<a href="index.html"><img src="<%=request.getContextPath()%>/images/coffee4.jpg" alt="Image"></a>
								<div>
									<a href="index.html">Lorem ipsum</a>
									<p>
										Lorem ipsum &#36;0.00
									</p>
								</div>
							</li>
							<li>
								<a href="index.html"><img src="<%=request.getContextPath()%>/images/coffee5.jpg" alt="Image"></a>
								<div>
									<a href="index.html">Dolor sit amet</a>
									<p>
										Lorem ipsum &#36;0.00
									</p>
								</div>
							</li>
							<li>
								<a href="index.html"><img src="<%=request.getContextPath()%>/images/coffee6.jpg" alt="Image"></a>
								<div>
									<a href="index.html">Donie quis</a>
									<p>
										Lorem ipsum &#36;0.00
									</p>
								</div>
							</li>
							<li>
								<a href="index.html"><img src="<%=request.getContextPath()%>/images/coffee3.jpg" alt="Image"></a>
								<div>
									<a href="index.html">Lorem ipsum</a>
									<p>
										Lorem ipsum &#36;0.00
									</p>
								</div>
							</li>
							<li>
								<a href="index.html"><img src="<%=request.getContextPath()%>/images/coffee2.jpg" alt="Image"></a>
								<div>
									<a href="index.html">Dolor sit amet</a>
									<p>
										Lorem ipsum &#36;0.00
									</p>
								</div>
							</li>
							<li>
								<a href="index.html"><img src="<%=request.getContextPath()%>/images/coffee1.jpg" alt="Image"></a>
								<div>
									<a href="index.html">Donie quis</a>
									<p>
										Lorem ipsum &#36;0.00
									</p>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
				<jsp:directive.include file="footer.jsp" />SS
		  </div>
	</div>
</body>
</html>
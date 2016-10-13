<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://allfont.ru/allfont.css?fonts=kabelctt-ultra" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Yay&#39;Koffee Website Template</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">	
</style>
</head>
<body>
	<div id="page">
		<div>
			<jsp:directive.include file="header.jsp" />
			<div id="body">
				<div id="figure">
					<img src="<%=request.getContextPath()%>/images/headline-home.jpg"
						alt="Image"> <span id="home">The powers of man's mind
						are proportioned to the quantity of coffee he drinks. <a
						href="index.html">${lang.why}.</a>
					</span>
				</div>
				<div id="featured">
					<span class="whatshot"><a href="%=request.getContextPath()%>/menu">${lang.more}.</a></span>
					<div>
						<a href="<%=request.getContextPath()%>/menu"><img
							src="<%=request.getContextPath()%>/images/coffee1.jpg"
							alt="Image"></a> <a href="<%=request.getContextPath()%>/menu"><img
							src="<%=request.getContextPath()%>/images/coffee2.jpg"
							alt="Image"></a> <a href="<%=request.getContextPath()%>/menu"><img
							src="<%=request.getContextPath()%>/images/coffee3.jpg"
							alt="Image"></a>
					</div>
				</div>
				<div class="section">
					<ul>
						<li><a href="menu"><img
								src="<%=request.getContextPath()%>/images/coffee-ingredients.jpg"
								alt="Image"></a>
							<h2>
								<a href="<%=request.getContextPath()%>/menu">${lang.best1}</a>
							</h2>
							<p></p></li>
						<li><a href="<%=request.getContextPath()%>/menu"><img
								src="<%=request.getContextPath()%>/images/black-coffee.jpg"
								alt="Image"></a>
							<h2>
								<a href="<%=request.getContextPath()%>/menu">${lang.best2}</a>
							</h2>
							</li>
						<li><a href="menu"><img
								src="<%=request.getContextPath()%>/images/chocolate.jpg"
								alt="Image"></a>
							<h2>
								<a href="menu">${lang.best3}</a>
							</h2>
							<p></p></li>
					</ul>
					<div id="form">

						<h3>Password renewal</h3>
					
						<form id="passwordForm" name="passwordForm"
							action="http://localhost:8080/EpamMarkTask4/password" method="POST">

							<label for="login">${lang.login}</label> <input class="form-control"
								id="login" name="login" type="text" value=""
								placeholder=${lang.login} size="30" autocomplete="on"
								autofocus="autofocus"/>
								 <label for="email" >email</label>
							<input class="form-control" id="email" name="email"
								type="email" value="" placeholder=email size="30"
								autocomplete="on" />

							<button type="submit" class="btn btn-primary"
								style="width: 88px;">${lang.submit}</button>
								<p>${message}</p>
								<p>${lang[error]}</p>
						</form>
					</div>

				</div>
			</div>
				<jsp:directive.include file="footer.jsp" />
		</div>
	</div>
</body>
</html>
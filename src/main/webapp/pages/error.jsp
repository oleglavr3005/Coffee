<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>We are sorry but an unexpected error happened.</h2>
=======
<%@ page language="java" isErrorPage="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error Page</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<div id="page">
		<div style="height: 80%">
			<%@ include file="header.jsp"%>
			<div style="height: 200px; padding: 100px;">
				<h1 class="err" style="color: red;">We are sorry, but an unexpected error
					happened.</h1>
			</div>
			<%@ include file="footer.jsp"%>
		</div>
	</div>
>>>>>>> efeeaaf0ca360e491f09dacb324f789157019bc3
</body>
</html>
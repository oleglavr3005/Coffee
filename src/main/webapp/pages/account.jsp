<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>${lang.registerTitle}</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div id="page">
		<div>
			<%@ include file="header.jsp"%>
			<div id="body">
				<c:if test="${sessionScope.role != null}">
					<div class="section">
						<div id="form">
							<form id="accountForm" method="POST"
								style="position: absolute; top: 200px; left:500px"
								action="<%=request.getContextPath()%>/addMoney">
								<div class="form-group">
								<label style="color: green"><h2>Your account</h2></label><br> 								
								<label  for="addMoney"
									style="color: red">Current sum:${currentAmount}
								</label>								
									 <label   for="addMoney" style="color: green"><br>Enter sum to add </label>
								<p>
									<input class="form-control" type='number' name='addMoney' value='0' />
								</p>								
								<p>
									<input class="btn btn-default" type='submit' value='Submit'>
								</p>
								</div>
								<p class="info">${errormsg}</p>
							</form>
						</div>
					</div>
				</c:if>
			</div>
			<%@ include file="footer.jsp"%>
		</div>
	</div>
  <script>
	$(document).ready(function() {
		$('#header ul li:nth-child(4)').addClass('current');
		$('#footer ul li:nth-child(4)').addClass('current');
	});
</script>
</body>
</html>

<link href="http://allfont.ru/allfont.css?fonts=kabelctt-ultra"
	rel="stylesheet" type="text/css"/>


<div id="header">
	<a href="<%=request.getContextPath()%>/pages/index.jsp">
	<img src="<%=request.getContextPath()%>/images/logo.png" alt="Image"></a>
	<ul>
		<li><a href="<%=request.getContextPath()%>/pages/index.jsp">${lang.home}</a></li>
		<li><a href="<%=request.getContextPath()%>/menu">${lang.menu}</a></li>
		<li>
		  <a href="<%=request.getContextPath()%>/pages/registration.jsp">${lang.register}</a>
		</li>
		<c:if test="${sessionScope.role != null}">
			 <li><a href="<%=request.getContextPath()%>/account">${lang.account}</a>
			 </li>
		</c:if>
		<li><a href="<%=request.getContextPath()%>/pages/about.jsp">${lang.about}</a></li>
	</ul>
	<div id="logmsg">
		<my:access admin="true">
			<a href="administration">${lang[admin]}</a>
		</my:access>
		<c:if test="${sessionScope.role != null}">
		${welcomeMessage}<a href="<%=request.getContextPath()%>/logout ">${lang.logout}</a>
		</c:if>
	</div>


</div>

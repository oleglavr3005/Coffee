<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" uri="/WEB-INF/AccessTag.tld"%>
<!DOCTYPE html>
<html>
    <head>
        <title>${lang.registerTitle}</title>
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    </head>
    <body>
      <div id="page">
		<div>
        <%@ include file="header.jsp" %>
         <div id="body">
           <div class="section">
            <div id="form" style="height:480px">
             
               <form id="registrationForm" style="position: absolute; top: 500px; left:500px" method="POST" action="<%=request.getContextPath()%>/registration">
               <label>Registration Form</label><br>
                <p><input type='text' name='login' value='${login}' placeholder='Login'/></p>
                <p><input type='password' name='password' value='' placeholder='password'/></p>
                <p><input type='password' name='verification' value='' placeholder='repeat password'>${lang[passErr]}</p>
                <p><input type='text' name='name' value='${name}' placeholder='name'/></p>
                <p><input type='text' name='surname' value='${surname}' placeholder='surname'/></p>
                <p><input type='text' name='email' value='${email}' placeholder='$email'/>${lang[emailErr]}</p>
                <p><input class="btn btn-default"  type='submit' value='Submit'></p>

                 <p class="info">${errormsg}</p>
              </form>
             </div>
           </div>
          </div>    
           <%@ include file="footer.jsp" %>
         </div>
        </div>  
    </body>
    <script>
	$(document).ready(function() {
		$('#header ul li:nth-child(3)').addClass('current');
	});
</script>
</html>

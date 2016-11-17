
<div id="footer">
	<div>
		<a href="index.html"><img
			src="<%=request.getContextPath()%>/images/logo2.png" alt="Image"></a>
		<p class="footnote">${lang.footnote}
		</p>
	</div>
	<div class="section">
		<ul>
			<li class="current"><a href="index.html">${lang.home}</a></li>
			<li><a href="<%=request.getContextPath()%>/menu">${lang.menu}</a></li>
			<li><a href="<%=request.getContextPath()%>/registration">${lang.register}</a></li>
			<li><a href="<%=request.getContextPath()%>/pages/about.jsp">${lang.about}</a></li>
			<li style="padding-left:130px;">
				<form method="get"
					action="<%=request.getContextPath()%>/pages/changelang">
					<input type="hidden" name="language" value="en"> <input
						class="button16" type="submit" value="English">
				</form>
			</li>
			<li>
				<form method=get"
					action="<%=request.getContextPath()%>/pages/changelang">
					<input type="hidden" name="language" value="uk"> <input
						class="button16" type="submit" value="Ukrainian">
				</form>
			</li>
		</ul>
		<p>
			<b>${login}</b>!
		</p>
	</div>
</div>

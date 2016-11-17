<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>DataTables example - Form inputs</title>
<link rel="shortcut icon" type="image/png"
	href="/media/images/favicon.png">
<link rel="alternate" type="application/rss+xml" title="RSS 2.0"
	href="http://www.datatables.net/rss.xml">
<link rel="stylesheet" type="text/css"
	href="/media/css/site-examples.css?_=b05357026107a2e3ca397f642d976192">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<style type="text/css" class="init">
</style>
<script type="text/javascript"
	src="/media/js/site.js?_=2582268cc83e9f416b6ec1621368fb40">
	
</script>
<script type="text/javascript"
	src="/media/js/dynamic.php?comments-page=examples%2Fapi%2Fform.html"
	async>
	
</script>
<script type="text/javascript" language="javascript"
	src="//code.jquery.com/jquery-1.12.3.js">
	
</script>
<script type="text/javascript" language="javascript"
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js">
	
</script>
<script type="text/javascript" language="javascript"
	src="../resources/demo.js">
	
</script>
<script type="text/javascript" class="init">
	$(document)
			.ready(
					function() {
						var table = $('#example').DataTable();

						$('button')
								.click(
										function() {
											var data = table.$('input, select')
													.serialize();
											alert("The following data would have been submitted to the server: \n\n"
													+ data.substr(0, 120)
													+ '...');
											return false;
										});
					});
</script>
</head>
<body class="wide comments example">
	<div class="fw-container">
		<div class="fw-header fh-fixedHeader">
			<img src="/media/images/logo-fade.png" class="logo">


		</div>

		<div class="fw-body">
			<div class="content">
				<h1 class="page_title">Form inputs</h1>
				<button type="submit">Submit form</button>
				<table id="example" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Name</th>
							<th>Age</th>
							<th>Position</th>
							<th>Office</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Name</th>
							<th>Age</th>
							<th>Position</th>
							<th>Office</th>
						</tr>
					</tfoot>
					<tbody>
						<tr>
							<td>Tiger Nixon</td>
							<td><input type="text" id="row-1-age" name="row-1-age"
								value="61"></td>
							<td><input type="text" id="row-1-position"
								name="row-1-position" value="System Architect"></td>
							<td><select size="1" id="row-1-office" name="row-1-office">
									<option value="Edinburgh" selected="selected">
										Edinburgh</option>
									<option value="London">London</option>
									<option value="New York">New York</option>
									<option value="San Francisco">San Francisco</option>
									<option value="Tokyo">Tokyo</option>
							</select></td>
						</tr>
						<tr>
							<td>Hope Fuentes</td>
							<td><input type="text" id="row-38-age" name="row-38-age"
								value="41"></td>
							<td><input type="text" id="row-38-position"
								name="row-38-position" value="Secretary"></td>
							<td><select size="1" id="row-38-office" name="row-38-office">
									<option value="Edinburgh">Edinburgh</option>
									<option value="London">London</option>
									<option value="New York">New York</option>
									<option value="San Francisco" selected="selected">San
										Francisco</option>
									<option value="Tokyo">Tokyo</option>
							</select></td>
						</tr>
						<tr>
							<td>Vivian Harrell</td>
							<td><input type="text" id="row-39-age" name="row-39-age"
								value="62"></td>
							<td><input type="text" id="row-39-position"
								name="row-39-position" value="Financial Controller"></td>
							<td><select size="1" id="row-39-office" name="row-39-office">
									<option value="Edinburgh">Edinburgh</option>
									<option value="London">London</option>
									<option value="New York">New York</option>
									<option value="San Francisco" selected="selected">San
										Francisco</option>
									<option value="Tokyo">Tokyo</option>
							</select></td>
						</tr>
						<tr>
							<td>Timothy Mooney</td>
							<td><input type="text" id="row-40-age" name="row-40-age"
								value="37"></td>
							<td><input type="text" id="row-40-position"
								name="row-40-position" value="Office Manager"></td>
							<td><select size="1" id="row-40-office" name="row-40-office">
									<option value="Edinburgh">Edinburgh</option>
									<option value="London" selected="selected">London</option>
									<option value="New York">New York</option>
									<option value="San Francisco">San Francisco</option>
									<option value="Tokyo">Tokyo</option>
							</select></td>
						</tr>
						<tr>
							<td>Jackson Bradshaw</td>
							<td><input type="text" id="row-41-age" name="row-41-age"
								value="65"></td>
							<td><input type="text" id="row-41-position"
								name="row-41-position" value="Director"></td>
							<td><select size="1" id="row-41-office" name="row-41-office">
									<option value="Edinburgh">Edinburgh</option>
									<option value="London">London</option>
									<option value="New York" selected="selected">New York
									</option>
									<option value="San Francisco">San Francisco</option>
									<option value="Tokyo">Tokyo</option>
							</select></td>
						</tr>
						<tr>
							<td>Olivia Liang</td>
							<td><input type="text" id="row-42-age" name="row-42-age"
								value="64"></td>
							<td><input type="text" id="row-42-position"
								name="row-42-position" value="Support Engineer"></td>
							<td><select size="1" id="row-42-office" name="row-42-office">
									<option value="Edinburgh">Edinburgh</option>
									<option value="London">London</option>
									<option value="New York">New York</option>
									<option value="San Francisco">San Francisco</option>
									<option value="Tokyo">Tokyo</option>
							</select></td>
						</tr>
					</tbody>
				</table>


				<code> $('button').click( function() { var data =
					table.$('input, select').serialize(); alert( &quot;The following
					data would have been submitted to the server: \n\n&quot;+
					data.substr( 0, 120 )+'...' ); return false; } ); } );</code>


				<script type="text/javascript">
					var _gaq = _gaq || [];
					_gaq.push([ '_setAccount', 'UA-365466-5' ]);
					_gaq.push([ '_trackPageview' ]);

					(function() {
						var ga = document.createElement('script');
						ga.type = 'text/javascript';
						ga.async = true;
						ga.src = ('https:' == document.location.protocol ? 'https://ssl'
								: 'http://www')
								+ '.google-analytics.com/ga.js';
						var s = document.getElementsByTagName('script')[0];
						s.parentNode.insertBefore(ga, s);
					})();
				</script>
</body>
</html>
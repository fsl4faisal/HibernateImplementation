<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Company</title>
</head>
<body>
	<h1>Add Company</h1>
	<form action="company" method="post">
		<input type="hidden" name="add">
		<ul>
			<li>Name:<input type="text" name="name"></li>
		</ul>
		<input type="submit" value="Submit" name="add">
	</form>
	<a href="contacts">Back to Contacts</a>
</body>
</html>
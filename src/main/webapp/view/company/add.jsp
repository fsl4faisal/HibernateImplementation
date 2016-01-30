<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
	<h1>Add Contact</h1>
	<form action="contact" method="post">
		<input type="hidden" name="add">
		<ul>
			<li>Name:<input type="text" name="name"></li>
			<li>Street:<input type="text" name="street"></li>
			<li>City:<input type="text" name="city"></li>
			<li>State:<input type="text" name="state"></li>
			<li>Zip:<input type="text" name="zip"></li>
		</ul>
		<input type="submit" value="Submit" name="add">
	</form>
	<a href="contacts">Back to Contacts</a>
</body>
</html>
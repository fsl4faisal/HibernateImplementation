<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Company</title>
</head>
<body>
	<h1>Edit Company</h1>
	<form action="company" method="post">
		<input type="hidden" name="edit"> 
		<input type="hidden" name="id" value="${company.id}">
		<ul>
			<li>Name:<input type="text" name="name" value="${company.name}"></li>
		</ul>
		<input type="submit" value="edit" name="edit"> 
		<a href="contacts">Back to Contacts</a>
	</form>
	<form action="company" method="post">
		<input type="hidden" name="id" value="${company.id}"> <input
			type="submit" value="delete" name="delete">
	</form>
</body>
</html>
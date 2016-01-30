<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Office</title>
</head>
<body>
	<h1>Edit Office</h1>
	<form action="office" method="post">
		<input type="hidden" name="edit">
		<input type="hidden" name="id" value="${office.id}">
		<ul>
			<li>Name:<input type="text" name="name" value="${office.name}"></li>
		</ul>
		<input type="submit" value="edit" name="edit"> 
		<a href="contacts">Back to Contacts</a>
	</form>
	<form action="office" method="post">
		<input type="hidden" name="id" value="${office.id}"> <input
			type="submit" value="delete" name="delete">
	</form>
</body>
</html>
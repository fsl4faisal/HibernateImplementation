<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>contacts</title>
</head>
<body>
	<h1>contacts</h1>
	<ul>
		<c:forEach var="contact" items="${contacts}">
			<li><a href="contact?id=${contact.id}">${contact.name}</a>
		</c:forEach>
	</ul>
	<a href="contact?add">Add a new Contact</a>
</body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${person.name}</title>
</head>
<body>
	<h1>${person.name}</h1>
	<c:set var="address" value="${person.address}" />
	<ul>
		<li>${address.street}</li>
		<li>${address.city}, ${address.state} ${address.zip}</li>
	</ul>
	<a href="contacts">Back to Contacts</a>|	<a href="person?edit&id=${person.id}">Edit Person</a>
</body>
</html>
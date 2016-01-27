<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${contact.name}</title>
</head>
<body>
	<h1>${contact.name}</h1>
	<c:set var="address" value="${contact.address}" />
	<ul>
		<li>${address.street}</li>
		<li>${address.city}, ${address.state} ${address.zip}</li>
	</ul>
	<a href="contacts">Back to Contacts</a>|	<a href="contact?edit&id=${contact.id}">Edit Contact</a>
</body>
</html>
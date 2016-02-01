<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${office.name}</title>
</head>
<body>
	<h1>${office.name}</h1>
	<c:set var="address" value="${office.address}" />
	<ul>
		<li>${address.street}</li>
		<li>${address.city}, ${address.state} ${address.zip}</li>
	</ul>
	<a href="${office.company.url}">Back to ${office.company.name}</a>|<a href="${office.url}&edit">Edit Office</a>
</body>
</html>
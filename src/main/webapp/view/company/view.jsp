<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${company.name}</title>
</head>
<body>
	<h1>${company.name}</h1>
	<ul>
	<c:forEach var="office" items="${company.offices}">
	<li><a href="${office.url}">${office.name}</a></li>
	</c:forEach>
	</ul>
	<a href="contacts">Back to Contacts</a>|
	<a href="${company.url}&edit">Edit Company</a>|
	<a href="office?add&company_id=${company.id}">Add an Office</a>
</body>
</html>
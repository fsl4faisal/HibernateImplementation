<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${office.name}</title>
</head>
<body>
	<h1>${office.name}</h1>
	<a href="contacts">Back to Contacts</a>|	<a href="office?edit&id=${office.id}">Edit Office</a>
</body>
</html>
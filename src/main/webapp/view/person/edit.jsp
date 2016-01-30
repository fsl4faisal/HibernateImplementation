<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Person</title>
</head>
<body>
	<h1>Edit Person</h1>
	<form action="person" method="post">
		<c:set var="address" value="${person.address}" />
		<input type="hidden" name="edit"> 
		<input type="hidden" name="id" value="${person.id}">
		<ul>
			<li>Name:<input type="text" name="name" value="${person.name}"></li>
			<li>Street:<input type="text" name="street"
				value="${address.street}"></li>
			<li>City:<input type="text" name="city" value="${address.city}"></li>
			<li>State:<input type="text" name="state"
				value="${address.state}"></li>
			<li>Zip:<input type="text" name="zip" value="${address.zip}"></li>
		</ul>
		<input type="submit" value="edit" name="edit"> 
		<a href="contacts">Back to Contacts</a>
	</form>
	<form action="person" method="post">
		<input type="hidden" name="id" value="${person.id}"> <input
			type="submit" value="delete" name="delete">
	</form>
</body>
</html>
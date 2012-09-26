<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${person.name}</title>
</head>
<body>
	<h1>${person.name}</h1>
	<ul>
		<c:set var="address" value="${person.address}" />
		<li>${address.street}</li>
		<li>${address.city}, ${address.state} ${address.zip}</li>
	</ul>
	<a href="person?edit&id=${person.id}">edit person</a> |
	<a href="contacts">back to contact list</a>
</body>
</html>
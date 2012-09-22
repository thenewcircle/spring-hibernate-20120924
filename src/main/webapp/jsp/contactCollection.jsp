<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>contacts</title>
</head>
<body>
	<ul>
		<c:forEach var="contact" items="${contacts}">
		<li><a href="contact?id=${contact.id}">${contact.name}</a></li>
		</c:forEach>
	</ul>
	<a href="contact?add">add new contact</a>
</body>
</html>
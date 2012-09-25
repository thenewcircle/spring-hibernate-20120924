<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>contacts</title>
</head>
<body>
	<ul>
		<c:forEach var="contact" items="${contacts}">
		<li><a href="${contact.URI}">${contact.name}</a></li>
		</c:forEach>
	</ul>
	<a href="person?add">add new person</a> | <a href="company?add">add new company</a>
</body>
</html>
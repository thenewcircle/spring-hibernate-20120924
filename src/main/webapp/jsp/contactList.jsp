<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>contacts</title>
</head>
<body>
	<h1>contacts</h1>
	<ul>
		<c:forEach var="contact" items="${contacts}">
			<li><a href="???">${contact.name}</a></li>
		</c:forEach>
	</ul>
	<a href="contact?add">add a new contact</a>
</body>
</html>
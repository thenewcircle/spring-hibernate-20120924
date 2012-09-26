<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>contacts</title>
</head>
<body>
	<h1>contacts</h1>
	<ul>
		<c:forEach var="contact" items="${contacts}">
			<li><a href="person?id=${contact.id}">${contact.name}</a></li> <!-- FIXME: url? -->
		</c:forEach>
	</ul>
	<a href="person?add">add a new person</a>
</body>
</html>
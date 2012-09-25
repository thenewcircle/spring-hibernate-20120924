<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${company.name}</title>
</head>
<body>
	<h1>${company.name}</h1>
	<h2>Offices</h2>
	<ul>
		<c:forEach var="office" items="${company.offices}">
		<li><a href="office?id=${office.id}">${office.name}</a></li>
		</c:forEach>
	</ul>
	<a href="office?add&company=${company.id}">add an office</a> | <a href="contacts">back to contacts</a>
</body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${company.name}</title>
</head>
<body>
	<h1>${company.name}</h1>
	<ul>
		<c:forEach var="office" items="${company.offices}">
			<li><a href="${office.url}">${office.name}</a></li>
		</c:forEach>
	</ul>
	<a href="${company.url}&edit">edit company</a> |
	<a href="office?add&company_id=${company.id}">add office</a> |
	<a href="contacts">back to contact list</a>
</body>
</html>
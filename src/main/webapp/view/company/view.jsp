<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${company.name}</title>
</head>
<body>
	<h1>${company.name}</h1>
	<!-- TODO: list offices -->
	<a href="${company.url}&edit">edit company</a> |
	<a href="contacts">back to contact list</a>
</body>
</html>
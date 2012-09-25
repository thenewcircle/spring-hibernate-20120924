<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>edit company: ${company.name}</title>
</head>
<body>
	<form action="company" method="post">
		<input type="hidden" name="id" value="${company.id}">
		<input type="hidden" name="edit">
		<ul>
			<li>name: <input type="text" name="name" value="${company.name}"></li>
		</ul>
		<input type="submit" value="edit">
	</form>
	<a href="contacts">back to contacts</a>
</body>
</html>
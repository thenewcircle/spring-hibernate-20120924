<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>edit company</title>
</head>
<body>
	<h1>edit company</h1>
	<form action="company" method="post">
	<input type="hidden" name="edit">
	<input type="hidden" name="id" value="${company.id}">
	<ul>
		<li>name: <input type="text" name="name" value="${company.name}"></li>
	</ul>
	<input type="submit" value="edit">
	</form>
	<form action="company" method="post">
	<input type="hidden" name="delete">
	<input type="hidden" name="id" value="${company.id}">
	<input type="submit" value="delete">
	</form>
	<a href="contacts">back to contact list</a>
</body>
</html>
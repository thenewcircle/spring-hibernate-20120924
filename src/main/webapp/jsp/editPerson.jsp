<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>edit person: ${person.name}</title>
</head>
<body>
	<form action="person" method="post">
		<input type="hidden" name="id" value="${person.id}">
		<input type="hidden" name="edit">
		<ul>
			<li>name: <input type="text" name="name" value="${person.name}"></li>
			<li>street <input type="text" name="street" value="${address.street}"></li>
			<li>city <input type="text" name="city" value="${address.city}"></li>
			<li>state <input type="text" name="state" value="${address.state}"></li>
			<li>zip <input type="text" name="zip" value="${address.zip}"></li>
		</ul>
		<input type="submit" value="edit">
	</form>
	<a href="contacts">back to contacts</a>
</body>
</html>
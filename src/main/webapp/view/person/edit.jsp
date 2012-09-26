<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>edit person</title>
</head>
<body>
	<h1>edit person</h1>
	<form action="person" method="post">
	<input type="hidden" name="edit">
	<input type="hidden" name="id" value="${person.id}">
	<ul>
		<c:set var="address" value="${person.address}" />
		<li>name: <input type="text" name="name" value="${person.name}"></li>
		<li>street: <input type="text" name="street" value="${address.street}"></li>
		<li>city: <input type="text" name="city" value="${address.city}"></li>
		<li>state: <input type="text" name="state" value="${address.state}"></li>
		<li>zip: <input type="text" name="zip" value="${address.zip}"></li>
	</ul>
	<input type="submit" value="edit">
	</form>
	<form action="person" method="post">
	<input type="hidden" name="delete">
	<input type="hidden" name="id" value="${person.id}">
	<input type="submit" value="delete">
	</form>
	<a href="contacts">back to contact list</a>
</body>
</html>
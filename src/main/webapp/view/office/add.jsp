<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>add office</title>
</head>
<body>
	<h1>add office</h1>
	<form action="office" method="post">
	<input type="hidden" name="add">
	<input type="hidden" name="company_id" value="${company.id}">
	<ul>
		<li>name: <input type="text" name="name"></li>
		<li>street: <input type="text" name="street"></li>
		<li>city: <input type="text" name="city"></li>
		<li>state: <input type="text" name="state"></li>
		<li>zip: <input type="text" name="zip"></li>
	</ul>
	<input type="submit" value="add">
	</form>
	<a href="${company.url}">back to ${company.name}</a>
</body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>add company</title>
</head>
<body>
	<h1>add company</h1>
	<form action="company" method="post">
	<input type="hidden" name="add">
	<ul>
		<li>name: <input type="text" name="name"></li>
	</ul>
	<input type="submit" value="add">
	</form>
	<a href="contacts">back to contact list</a>
</body>
</html>
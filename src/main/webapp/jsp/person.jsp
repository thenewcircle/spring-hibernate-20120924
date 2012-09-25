<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${person.name}</title>
</head>
<body>
	<h1>${person.name}</h1>
	<ul>
		<li>${person.address.street}</li>
		<li>${person.address.city}, ${person.address.state} ${person.address.zip}</li>
	</ul>
	<a href="contacts">back to contacts</a>
</body>
</html>
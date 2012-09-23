<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${contact.name}</title>
</head>
<body>
	<h1>${contact.name}</h1>
	<ul>
		<li>${contact.address.street}</li>
		<li>${contact.address.city}, ${contact.address.state} ${contact.address.zip}</li>
	</ul>
	<a href="contacts">back to contacts</a>
</body>
</html>
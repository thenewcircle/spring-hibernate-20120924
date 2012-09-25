<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${office.name}</title>
</head>
<body>
	<h1>${office.name}</h1>
	<ul>
		<li>${office.address.street}</li>
		<li>${office.address.city}, ${office.address.state} ${office.address.zip}</li>
	</ul>
	<a href="${office.company.URI}">back to ${office.company.name}</a>
</body>
</html>
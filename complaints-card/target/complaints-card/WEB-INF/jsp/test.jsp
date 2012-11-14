<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Spring 3.0 MVC Series: Index - ViralPatel.net</title>
</head>
<body>
<h1>Page with image</h1>
<!-- use c:url to get the correct absolute path -->
<img src="<c:url value="/resources/img/next.gif" />" />
<img src="http://localhost:8088${pageContext.request.contextPath}/resources/img/attention.gif" />
<a href="map">View Map</a>
</body>
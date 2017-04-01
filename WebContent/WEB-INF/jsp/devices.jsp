<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>SmartHome - Devices</title>
<link href="<c:url value='/css/style.css' />" rel="stylesheet"
	type="text/css" />
</head>
<body>
	Device's list :

	<c:forEach items="${model}" var="userDevice">
		<p>${userDevice.userId}- ${userDevice.userName}:
			${userDevice.deviceId} - ${userDevice.deviceName}</p>
	</c:forEach>


	<c:forEach items="${model}" var="userDevice">
		<p>${userDevice.formattedRow}</p>
	</c:forEach>


	<c:forEach items="${model}" var="userDevice">
		<p class="${userDevice.even ? 'even' : 'odd'}">${userDevice.formattedRow}</p>
	</c:forEach>
</body>
</html>
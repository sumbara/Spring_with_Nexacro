<%@page import="com.nexacro17.xapi.tx.*"%>
<%@page import="com.nexacro17.xapi.data.PlatformData"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>insert</title>
</head>
<body>
<%
	PlatformData data = (PlatformData)request.getAttribute("data");
	HttpPlatformResponse pRes = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML);
	pRes.setData(data);
	pRes.sendData();
%>
</body>
</html>

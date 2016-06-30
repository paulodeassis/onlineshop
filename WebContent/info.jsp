<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="z" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Info</title>
</head>
<body>
	<z:hallo name="Buffersize:"></z:hallo>${pageContext.out.bufferSize}<br>
	<z:hallo name="Remaining:" ></z:hallo>${pageContext.out.remaining}<br>
	<z:hallo name="CharacterEncoding:"></z:hallo> ${pageContext.response.characterEncoding }<br>
 	<z:hallo name="ContetType:"></z:hallo> ${pageContext.response.contentType }<br>
	<z:hallo name="Locale:"></z:hallo>${pageContext.response.locale }<br>
	<z:hallo name="path:"></z:hallo>${pageContext.request.contextPath }<br>
	<z:hallo name="LocalAddr:"></z:hallo>${pageContext.request.localAddr }<br>
	<z:hallo name="LocalName:"></z:hallo>${pageContext.request.localName }<br>
	<z:hallo name="LocalPort:"></z:hallo>${pageContext.request.localPort }<br>
	<z:hallo name="Method:"></z:hallo>${pageContext.request.method }<br>
	<z:hallo name="Protocol:"></z:hallo>${pageContext.request.protocol }<br>
	<z:hallo name="RemoteAdd:"></z:hallo>${pageContext.request.remoteAddr }<br>
	<z:hallo name="RemoteHost:"></z:hallo>${pageContext.request.remoteHost }<br>
	<z:hallo name="RemotePort:"></z:hallo>${pageContext.request.remotePort }<br>
	<z:hallo name="RequestedSessionId:"></z:hallo>${pageContext.request.requestedSessionId }<br>
	<z:hallo name="RequestURI:"></z:hallo>${pageContext.request.requestURI }<br>
	<z:hallo name="Scheme:"></z:hallo>${pageContext.request.scheme }<br>
	<z:hallo name="ServerPort:"></z:hallo>${pageContext.request.serverPort }<br>
	<z:hallo name="ServletPath:"></z:hallo>${pageContext.request.servletPath }<br>
	<z:hallo name="DispatcherType:"></z:hallo>${pageContext.request.dispatcherType }<br>
	<z:hallo name="RequestURL:"></z:hallo>${pageContext.request.requestURL }<br>
	<z:hallo name="CreationTime:"></z:hallo>${pageContext.session.creationTime }<br>
	<z:hallo name="Id:"></z:hallo>${pageContext.session.id}<br>
	<z:hallo name="LastAccessedTime:"></z:hallo>${pageContext.session.lastAccessedTime }<br>
	<z:hallo name="MaxInactiveInterval:"></z:hallo>${pageContext.session.maxInactiveInterval }<br>
</body>
</html>
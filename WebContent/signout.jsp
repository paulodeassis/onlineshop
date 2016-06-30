<%@ include file="header.jspf"%>
<c:remove var="customer" scope="session"/>
<c:redirect url="index.jsp"></c:redirect>
<c:catch var="exception">
<c:redirect url="signin.jsp"></c:redirect>
</c:catch>
<jsp:include page = "header.jsp" />
<%@ page import= "nl.hu.sp.lesson7.Les7.User" %>
<form action = "LogoutServlet.do" method = "get">
<ul style = "list-style-type:none">
<li>Welcome ${user.username}</li>
</ul>
</form>
<jsp:include page = "footer.jsp" />
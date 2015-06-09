<jsp:include page = "header.jsp" />
<div id="header">
<h1>Page</h1>
</div>

<div id="nav">
<a href="http://localhost:8080/Les7/login.jsp" target="content">Login</a><br>
<a href="LogoutServlet.do" target="content">Logout</a><br>
<a href="http://localhost:8080/Les7/welcome.jsp" target="content">Welcome Page</a><br>
<a href="http://localhost:8080/Les7/register.jsp" target="content">Register</a><br>
<a href="http://localhost:8080/Les7/post.jsp" target="content">Post</a><br>
<a href="http://localhost:8080/Les7/allposts.jsp" target="content">All Posts</a><br>
</div>

<div id="section">
<iframe name ="content" src = "http://localhost:8080/Les7/login.jsp"></iframe>
</div>
<jsp:include page = "footer.jsp" />
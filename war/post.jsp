<jsp:include page = "header.jsp" />
<form action = "PostServlet.do" method = "get">
<ul style = "list-style-type:none">
<li>
<textarea rows="10" cols="50" name = "blogpost">
Type your post here
</textarea>
</li>
<li>
<input type="submit" name = "post" value="Post" />
</li>
</ul>
</form>
<jsp:include page = "footer.jsp" />
<jsp:include page = "header.jsp" />
<form action = "LoginServlet.do" method = "get">

<div class="column">
    <ul style = "list-style-type:none" id = "firstlist">
        <li>Username: </li>
		<li>Password: </li>
    </ul>
</div>

<div class="column">
    <ul style = "list-style-type:none" id = "secondlist">
        <li><input type="text" name="username" value="${cookie.username.value}" /> </li>
		<li><input type="text" name="password" /></li>
		<li><input type="submit" name = "login" value="Login" /></li>
    </ul>
</div>

</form>

<div id = "messagebox">
<% Object msgs = request.getAttribute("msgs");
   if(msgs != null)
   { out.print(msgs);}
   %>
</div>
<jsp:include page = "footer.jsp" />
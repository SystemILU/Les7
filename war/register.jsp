<jsp:include page = "header.jsp" />
<form action = "RegisterServlet.do" method = "get">

<div class="column">
    <ul style = "list-style-type:none" id = "firstlist">
        <li>Username: </li>
		<li>Real name: </li>
		<li>Password: </li>
		<li>Re-type password: </li>
		<li>E-mail address: </li>
		<li>Re-type e-mail adress: </li>
		<li>Address: </li>
		<li>Country: </li>
    </ul>
</div>

<div class="column">
    <ul style = "list-style-type:none" id = "secondlist">
        <li><input type="text" name="username" value="${param.username}" /> </li>
		<li><input type="text" name="realname" value="${param.realname}" /></li>
		<li><input type="text" name="password" /></li>
		<li><input type="text" name="passwordretyped" /></li>
		<li><input type="text" name="emailaddress" value="${param.emailaddress}" /></li>
		<li> <input type="text" name="emailaddressretyped" value="${param.emailaddressretyped}" /></li>
		<li><input type="text" name="address" value="${param.address}" /></li>
		<li><input type="text" name="country" value="${param.country}" /></li>
		<li><input type="submit" name = "register" value="Register" /></li>
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
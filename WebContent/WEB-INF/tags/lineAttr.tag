<%@ tag  body-content="empty"%>
<%@ attribute name="color" %>
<%@ attribute name="size" type="java.lang.Integer" %>

<FONT color="${color}">
	<%
		for (int i = 0; i< size ; i++) {
			out.print("-");
		}
	%>
</FONT>
<br>
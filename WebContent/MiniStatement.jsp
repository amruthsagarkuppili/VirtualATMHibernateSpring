<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techaspect.atm.to.TransactionInfo, java.util.ArrayList,java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mini statement</title>
</head>
<body>

	<%@ include file = "LoginSuccess.jsp" %><br><br><br>
	 <%
		ArrayList al =  (ArrayList)session.getAttribute("Transaction");
		Iterator it = al.iterator();
		while(it.hasNext()) {
			TransactionInfo transtemp = (TransactionInfo)it.next();
	%>
		<span>Transaction ID :   <%=  transtemp.getTrans_id()  %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Transaction Amount :  <%= transtemp.getTrans_amt() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Transaction Date : <%=transtemp.getTrans_date()%> </span><br><br>
	<%} %> 
</body>
</html>
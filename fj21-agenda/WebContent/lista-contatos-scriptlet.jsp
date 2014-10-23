<%@ page import="java.util.*,dao.*,modelo.*,java.text.SimpleDateFormat,java.util.Date;" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Contatos</title>
</head>
<body>
<table>

<% 
	ContatoDao dao = new ContatoDao();
	List<Contato> contatos = dao.getLista();
	
	for(Contato contato : contatos){
%>

<tr>
<%
	Calendar c = contato.getDataNascimento();
	Date data = c.getTime();
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
%>
	
	<td><%=contato.getNome() %></td>
	<td><%=contato.getEmail() %></td>
	<td><%=contato.getEndereco() %></td>
	<td><% out.println(f.format(data)); %></td>
</tr>


<% } %>

</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testando pagina JSP</title>
</head>
<body>

<%-- comentario  --%>
<% String mensagem = "Bem vindo ao sistema de agenda"; %>
<% out.println(mensagem); %>
<br/>

<% String autor = "Desenvolvido por MateusParente"; %>
<%= autor %>

<br/>
<br>

<% out.println("Tudo foi executado"); %>


</body>
</html>
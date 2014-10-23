<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Contatos</title>
</head>
<body>

<table border="1" cellspacing="2" cellpadding="8">
<c:forEach var="contato" items="${contatos}">
	
	<tr>
		<td>${contato.nome}</td>
		<td>${contato.email}</td>
		<td>${contato.endereco}</td>
		<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
		<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
		<td><a href="mvc?logica=AlteraContatoLogic&id=${contato.id}">Editar</a></td>
	</tr>
	
</c:forEach>
</table>

<br/><br/>
<a href="mvc?logica=AdicionaContato">Adicionar novo</a>

</body>
</html>
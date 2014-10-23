<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar contato</title>
</head>
<body>

<h3>Edita contato</h3>
<hr>
<c:forEach var="contato" items="${contatos}">
<form action="mvc?logica=AlterandoLogic&id=${contato.id}" method="post">

	Nome: <input type="text" name="nome" value="${contato.nome}"/><br/>
	Email: <input type="text" name="email" value="${contato.email}" /><br/>
	Endereço: <input type="text" name="endereco" value="${contato.endereco}" /><br/>
	Data de Nascimento: <input type="text" name="dataNascimento" value='<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>'>
	<br/>
	<input type="submit" value="Gravar"/>
	
	<br/>
	<br/>

</form>
</c:forEach>
</body>
</html>
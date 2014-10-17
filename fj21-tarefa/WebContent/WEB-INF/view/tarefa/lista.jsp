<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listando tarefas</title>
<script type="text/javascript" src="resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript">
	function finalizaAgora(id){
		$.post("finalizaTarefa", {'id' : id}, function(){
			$("#tarefa_"+id).html("Finalizado");
		});
}
</script>
</head>
<body>
<a href="novaTarefa">Criar nova tarefa</a><br/><br/>

<table border="1" cellpadding="6" cellspacing="1">
<tr bgcolor="c0c0c0">
	<th>Id</th>
	<th>Descrição</th>
	<th>Finalizado?</th>
	<th>Data de finalização</th>
	<th>Ações</th>
</tr>

<c:forEach items="${tarefas}" var="tarefa">
<tr>
	<td>${tarefa.id}</td>
	<td>${tarefa.descricao}</td>
	<c:if test="${tarefa.finalizado eq false}">
		<td id="tarefa_${tarefa.id}">Não finalizado, finalizar <a href="#" onclick="finalizaAgora(${tarefa.id})">agora?</a></td>
		<td></td>
	</c:if>
	<c:if test="${tarefa.finalizado eq true}">
		<td>Finalizado</td>
		<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/></td>
	</c:if>
	
	<td><a href="removeTarefa?id=${tarefa.id}">Excluir</a>  | <a href="mostraTarefa?id=${tarefa.id}">Editar</a></td>
</tr>

</c:forEach>

</table>
</body>
</html>
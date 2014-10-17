<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
		<script type='text/javascript' src='js/jquery-1.4.2.min.js'></script>
		<script type='text/javascript' src='js/jquery-ui-1.8.2.custom.min.js'></script>
	</head>
	<body>
	
		<script type="text/javascript">
			function deletaAgora(id){
				$.post("excluiTarefa", {'id' : id}, function(dados){
					$("#tarefa"+id+"a").closest("tr").hide();
					});
			}
		</script>
	
		<script type="text/javascript">
			function finalizaAgora(id){
				$.post("finalizaTarefa", {'id' : id}, function(dados){
					/*selecionando o elemento html atraves da ID
						e alterando o html dele*/
					$("#tarefa"+id).html("Tarefa finalizada");
					});
				}
		</script>
		
		<table border="1">
			<tr align="center" bgcolor="#00008B">
				<th><font color="FFFFF0">Id</font></th>
				<th><font color="FFFFF0">Descrição</font></th>
				<th><font color="FFFFF0">Finalizado?</font></th>
				<th><font color="FFFFF0">Data de Finalização</font></th>
				<th colspan="2"><font color="FFFFF0">Opções</font></th>
			</tr>
			<c:forEach items="${tarefas}" var="tarefa" >
				<tr align="center" bgcolor="#BEBEBE" id="tarefa${tarefa.id}a">
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
					<c:if test="${not tarefa.finalizado}">
						<td bgcolor="red" id="tarefa${tarefa.id}">
							<a href="#" onClick="finalizaAgora(${tarefa.id})">Finaliza Agora!</a>
						</td>
					</c:if>
					<c:if test="${tarefa.finalizado}">
						<td bgcolor="blue">Finalizado</td>
					</c:if>
					<td>
						<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td><a href="#" onClick="deletaAgora(${tarefa.id})"><img src="imagens/botao-excluir.gif" border="0" alt="Excluir"/></a></td>
					<td><a href="mostraTarefa?id=${tarefa.id}"><img src="imagens/icone-editar.gif" border="0" alt="Editar"/></a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
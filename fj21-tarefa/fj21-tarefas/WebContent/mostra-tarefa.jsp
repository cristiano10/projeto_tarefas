<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>

<html>
	<head>
		<link type='text/css' href='css/ui-lightness/jquery-ui-1.8.2.custom.css' rel='stylesheet'/>
		<script type='text/javascript' src='js/jquery-1.4.2.min.js'></script>
		<script type='text/javascript' src='js/jquery-ui-1.8.2.custom.min.js'></script>
	</head>
	<body>
		<h3>Alterar Tarefa - ${tarefa.id}</h3>
		<form action="alteraTarefa" method="post">
			<input type="hidden" name="tarefa.id" value="${tarefa.id}"/>
			
			Descrição: <br/>
			<textarea name="tarefa.descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
			<br/>
			Finalizado <input type="checkbox" name="tarefa.finalizado"
						value="true" ${tarefa.finalizado?'checked':''}/>
			<br/>
			Data de Finalização: 
			<mytag:campoData id="dataFinalizacao" name="tarefa.dataFinalizacao" />

			<br/>
			<input type="submit" value="Alterar"/>
		</form>
	</body>
</html>
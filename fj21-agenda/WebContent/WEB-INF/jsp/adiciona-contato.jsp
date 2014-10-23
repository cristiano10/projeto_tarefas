<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Adiciona contatos</title>
	<link href='<c:url value="/css/css/jquery-ui-1.10.4.custom.css"/>' rel="stylesheet">
	<script src='<c:url value="/js/jquery-1.10.2.js"/>'></script>
	<script src='<c:url value="/js/jquery-ui-1.10.4.custom.js"/>'>
	</script>
</head>

<body>
<h3>Adiciona contatos</h3>
<hr>
<form action="adicionaContato" method="post">
	
	Nome: <input type="text" name="nome" /><br/>
	Email: <input type="text" name="email" /><br/>
	Endereço: <input type="text" name="endereco" /><br/>
	Data de Nascimento: <caelum:campoData id="dataNascimento" /><br/>
	
	<input type="submit" value="Gravar"/>
	
	<br/>
	<br/>
	
	
</form>
</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="id" required="true"%>
<%@ attribute name="name" required="false" %>
<script type='text/javascript'>
	$(function(){
		$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
	});
</script>

<input type="text" id="${id}" name="${name}" 
value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>"/> 
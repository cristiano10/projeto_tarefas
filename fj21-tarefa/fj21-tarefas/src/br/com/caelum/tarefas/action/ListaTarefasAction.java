package br.com.caelum.tarefas.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.caelum.tarefas.dao.TarefaDAO;
import br.com.caelum.tarefas.modelo.Tarefa;

@ParentPackage("default")

public class ListaTarefasAction {
	private List<Tarefa> tarefas;
	
	@Action(value="listaTarefas", results={
			@Result(name="ok", location="/lista-tarefas.jsp")
	}, interceptorRefs={
			@InterceptorRef("autorizador")
	})

	
	public String execute(){
		tarefas= new TarefaDAO().lista();
		return "ok";
	}
	
	public List<Tarefa> getTarefas(){
		return tarefas;
	}

}

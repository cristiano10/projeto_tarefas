package br.com.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.caelum.tarefas.dao.TarefaDAO;
import br.com.caelum.tarefas.modelo.Tarefa;

public class MostraTarefaAction {
	private Long id;
	private Tarefa tarefa;
	
	@Action(value="mostraTarefa", results={
			@Result(name="ok", location="/mostra-tarefa.jsp")
	})
	public String execute(){
		tarefa = new TarefaDAO().buscaPorId(id);
		return "ok";
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Tarefa getTarefa(){
		return tarefa;
	}

}

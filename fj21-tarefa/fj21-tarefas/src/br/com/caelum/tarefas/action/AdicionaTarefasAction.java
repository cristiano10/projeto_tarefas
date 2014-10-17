package br.com.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.caelum.tarefas.dao.TarefaDAO;
import br.com.caelum.tarefas.modelo.Tarefa;

public class AdicionaTarefasAction {
	private Tarefa tarefa;
	
	@Action(value="adicionaTarefa", results = {
			@Result(name="ok", location="/tarefa-adicionada.jsp")
	})
	
	public String execute(){
		new TarefaDAO().adiciona(tarefa);
		return "ok";
	}
	
	public void setTarefa(Tarefa tarefa){
		this.tarefa = tarefa;
	}
	
	public Tarefa getTarefa(){
		return this.tarefa;
	}

}

package br.com.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.caelum.tarefas.dao.TarefaDAO;
import br.com.caelum.tarefas.modelo.Tarefa;

public class excluiTarefaAction {

	private Long id;
	
	@Action(value="excluiTarefa", results={
			@Result(name="ok", type="httpheader", params={"status", "200"})
	})
	public String execute(){
		Tarefa exc = new TarefaDAO().buscaPorId(id);
		new TarefaDAO().remove(exc);
		return "ok";
	}
	public void setId(Long id){
		this.id = id;
	}

}

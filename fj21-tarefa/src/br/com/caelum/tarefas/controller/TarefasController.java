package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
@Scope("request")
public class TarefasController {
	
	private JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao){
		this.dao = dao;
	}
	
	
	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		
		if(result.hasFieldErrors("descricao")){
			return "tarefa/formulario";
		}
		
		
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model){
		
		model.addAttribute("tarefas", dao.getLista());
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remover(Tarefa tarefa){
		
		dao.remove(tarefa);
		
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model){
		
		model.addAttribute("tarefa",dao.getBusca(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa){
		
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id, HttpServletResponse response){
		
		dao.finaliza(id);
		response.setStatus(200);
	}
	
}

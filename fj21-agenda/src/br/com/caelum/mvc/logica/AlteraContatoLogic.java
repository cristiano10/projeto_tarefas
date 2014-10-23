package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDao;
import modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
			long id = Long.parseLong(req.getParameter("id"));
			List<Contato> contatos = new ContatoDao().getBusca(id);
			
			req.setAttribute("contatos", contatos);
			
			System.out.println("Editando...");
			
			return "/WEB-INF/jsp/altera-contato.jsp";
		
		
	}

}

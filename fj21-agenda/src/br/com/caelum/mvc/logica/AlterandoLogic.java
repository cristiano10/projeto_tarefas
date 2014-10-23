package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDao;
import modelo.Contato;

public class AlterandoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
	
	Long id = Long.parseLong(req.getParameter("id"));
	String nome = req.getParameter("nome");
	String endereco = req.getParameter("endereco");
	String email = req.getParameter("email");
	String dataEmTexto = req.getParameter("dataNascimento");
	
	Calendar dataNascimento = null;
	try {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
	} catch (ParseException e) {
		System.out.println("Erro ao converter data");
	}
	
	Contato contato = new Contato();
	contato.setId(id);
	contato.setNome(nome);
	contato.setEndereco(endereco);
	contato.setEmail(email);
	contato.setDataNascimento(dataNascimento);
	
	Connection connection = (Connection) req.getAttribute("conexao");
	
	ContatoDao dao = new ContatoDao(connection);
	dao.edita(contato);
	
	return "mvc?logica=ListaContatosLogic";
	
	}
	
}

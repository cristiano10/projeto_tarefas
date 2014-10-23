package teste;

import java.util.Calendar;

import dao.ContatoDao;
import modelo.Contato;

public class Testando {

	public static void main(String[] args) {

		Contato contato = new Contato(1,"Mateus","mpripardo@gmail.com","Rua Aurino Colares",
				Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		System.out.println("Gravado");
	}

}

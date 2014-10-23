package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import modelo.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao(Connection connection){
		this.connection=connection;
	}
	
	public ContatoDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
		
		String sql = "INSERT INTO `testando`.`contatos`" + "(nome,email,endereco,dataNascimento)" + 
		"values (?,?,?,?)";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4,new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista(){

		try{
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * FROM `testando`.`contatos`");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				
				Contato contato = new Contato(
						rs.getLong("id"),
						rs.getString("nome"),
						rs.getString("email"),
						rs.getString("endereco"),
						data);
				
				contatos.add(contato);
				
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public void exclui(Contato contato){
		
		String sql = "DELETE from testando.contatos where id= ?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		
	}
	
	public void edita(Contato contato){
		
		String sql = "UPDATE `testando`.`contatos` SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id =?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(5, contato.getId());
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4,new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getBusca(long id){

		try{
			List<Contato> contatos = new ArrayList<Contato>();
			
			String sql = "select * FROM `testando`.`contatos` where id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				
				Contato contato = new Contato(
						rs.getLong("id"),
						rs.getString("nome"),
						rs.getString("email"),
						rs.getString("endereco"),
						data);
				
				contatos.add(contato);
			}
				
			rs.close();
			stmt.close();
			return contatos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}

}

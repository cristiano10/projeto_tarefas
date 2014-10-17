package br.com.caelum.tarefas.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.caelum.tarefas.modelo.Tarefa;

@Repository
public class JdbcTarefaDao {
	
	private Connection connection;

	@Autowired
	public JdbcTarefaDao(DataSource dataSource){
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Tarefa tarefa){
		
		String sql = "INSERT INTO `testando`.`tarefas`"+"(descricao,finalizado)"+"values(?,?)";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Tarefa> getLista(){
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		String sql = "SELECT * FROM `testando`.`tarefas`";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()){
				Calendar data = Calendar.getInstance();
				if(resultado.getDate("dataFinalizacao")!=null){
					data.setTime(resultado.getDate("dataFinalizacao"));
				}else{
					data=null;
				}
				
				Tarefa tarefa = new Tarefa();
				tarefa.setId(resultado.getLong("id"));
				tarefa.setDescricao(resultado.getString("descricao"));
				tarefa.setDataFinalizacao(data);
				tarefa.setFinalizado(resultado.getBoolean("finalizado"));
				
				tarefas.add(tarefa);
			}
			
			resultado.close();
			stmt.close();
			return tarefas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public void remove(Tarefa tarefa){
		
		String sql = "DELETE from testando.tarefas where id= ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, tarefa.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Tarefa> getBusca(Long id){

		try{
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			
			String sql = "select * FROM `testando`.`tarefas` WHERE id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Calendar data = Calendar.getInstance();
				if(rs.getDate("dataFinalizacao")!=null){
					data.setTime(rs.getDate("dataFinalizacao"));
				}else{
					data=null;
				}
				
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				tarefa.setDataFinalizacao(data);
				
				tarefas.add(tarefa);
			}
				
			rs.close();
			stmt.close();
			return tarefas;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	public void altera(Tarefa tarefa){
		
		String sql = "UPDATE `testando`.`tarefas` SET descricao=?, finalizado=?, dataFinalizacao=? WHERE id=?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(4, tarefa.getId());
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3,new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void finaliza(Long id){
		
		String sql = "UPDATE `testando`.`tarefas` SET finalizado=?, dataFinalizacao=? WHERE id=?";
		
		Calendar datando = Calendar.getInstance();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setDate(2, new Date(datando.getTimeInMillis()));
			stmt.setLong(3, id);
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


}

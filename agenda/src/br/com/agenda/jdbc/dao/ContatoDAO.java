package br.com.agenda.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.agenda.jdbc.FabricaDeConexao;
import br.com.agenda.modelo.Contato;
import br.com.agenda.modelo.Usuario;

public class ContatoDAO {

	private Connection connection;
	
	public ContatoDAO()  {
		try {
			this.connection = FabricaDeConexao.getConexaoMySQL();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos (nome, email, endereco, dataNascimento, id_usuario) values (?,?,?,?,?)";
		
		try {
			// prepared statment para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date( contato.getDataNascimento().getTimeInMillis() ));
			stmt.setString(5, contato.getUsuario().getLogin());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public List<Contato> getLista(){

		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				// Criando o contato
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar  data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data); 
				
				// Adicionando o objeto a Lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista(Usuario usuario){

		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id_usuario=?");
			stmt.setString(1, usuario.getLogin());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				// Criando o contato
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar  data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data); 
				
				// Adicionando o objeto a Lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		
		try {
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 stmt.setString(1, contato.getNome());
			 stmt.setString(2, contato.getEmail());
			 stmt.setString(3, contato.getEndereco());
			 stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			 stmt.setLong(5, contato.getId());
			 stmt.execute();
			 stmt.close();
		} catch (SQLException e) {
		 throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Contato pesquisar(int id) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				// Criando o contato
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar  data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data); 
					
				rs.close();
				stmt.close();
				return contato;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

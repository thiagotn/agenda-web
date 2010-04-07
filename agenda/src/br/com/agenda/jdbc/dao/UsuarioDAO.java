package br.com.agenda.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.agenda.jdbc.FabricaDeConexao;
import br.com.agenda.modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;
	
	public UsuarioDAO() {
		try{
			this.connection = FabricaDeConexao.getConexaoMySQL();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Usuario autenticar(String login, String senha) {
		try {

			PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where login=? and senha=?");
			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				
				rs.close();
				stmt.close();
				return usuario;
			}
			return null;
			
		} catch (Exception e) {
			throw new RuntimeException();	
		}
	}
	
}

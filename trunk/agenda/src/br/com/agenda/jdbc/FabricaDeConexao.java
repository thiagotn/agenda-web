package br.com.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	public Connection getConnection() {
		System.out.println("Conectando ao banco");
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/agenda",
					"root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConexaoMySQL() throws Exception, SQLException {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/agenda",
					"root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConexaoPostgreSQL() throws Exception,
			SQLException {
		try {

			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost/agenda", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConexaoOracleXE() throws Exception,
			SQLException {
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XE", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

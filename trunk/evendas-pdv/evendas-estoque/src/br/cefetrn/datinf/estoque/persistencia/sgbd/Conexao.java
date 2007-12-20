package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.cefetrn.datinf.estoque.persistencia.Util;

public class Conexao {
	private String driver;
	private String url;
	private String usuario;
	private String senha;
	
	private Connection connection;

	public void init(String driver, String url, String usuario, String senha) {
		this.driver = driver;
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
		
		this.carregarDriver();
		this.conectar();
	}
	
	private void carregarDriver() {
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void conectar() {
		try {
			this.connection = DriverManager.getConnection(this.url, this.usuario, this.senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static Conexao conexao = null;
	
	public static Conexao obterInstancia(){
		if(Conexao.conexao == null){
			Conexao.conexao = obterIntanciaPadrao();
		}
		return Conexao.conexao;
	}
	
	private static Conexao obterIntanciaPadrao() {
		String driver = Util.obterDrive();
		String url = Util.obterURL();
		String usuario = Util.obterUsuario();
		String senha = Util.obterSenha();
		
		Conexao conexao = new Conexao();
		conexao.init(driver, url, usuario, senha);
		return conexao;
	}
	
	
	public PreparedStatement obterPreparedStatement(String sql){
		try {
			return this.connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CallableStatement obterCallableStatement(String umaConsulta) {
		try {
			return this.connection.prepareCall(umaConsulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}

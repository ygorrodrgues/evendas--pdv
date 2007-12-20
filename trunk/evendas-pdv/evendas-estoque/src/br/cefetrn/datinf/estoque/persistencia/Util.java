package br.cefetrn.datinf.estoque.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Util {
	
	private static Properties properties;
	
	private static final String DRIVER = "jdbc_driver";
	private static final String URL = "jdbc_url";
	private static final String USUARIO = "jdbc_user";
	private static final String SENHA = "jdbc_password";
	private static final String FABRICA = "dao_fabrica";
	private static final String ARQ = "estoqueDAO.properties";
	
	static{
		try {
			FileInputStream arq = new FileInputStream(Util.ARQ);
			Util.properties = new Properties();
			Util.properties.load(arq);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static String obterDrive(){
		return Util.properties.getProperty(Util.DRIVER);
	}
	
	public static String obterURL(){
		return Util.properties.getProperty(Util.URL);
	}
	
	public static String obterUsuario(){
		return Util.properties.getProperty(Util.USUARIO);
	}
	
	public static String obterSenha(){
		return Util.properties.getProperty(Util.SENHA);
	}
	
	public static String obterNomeFabrica(){
		return Util.properties.getProperty(Util.FABRICA);
	}
	
}

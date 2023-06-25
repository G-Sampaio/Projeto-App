package db_pessoas;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static String usuario = "root";
	private static String senha = "1234";
	private static String host = "localhost";
	private static String porta = "3306";
	private static String bd = "db_pessoas";
	
	public static Connection ObtemConexao(){
	try{
		Connection c = DriverManager.getConnection( "jdbc:mysql://" + host + ":" + porta + "/" + bd + "?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true",usuario,senha);
		return c;
				
	}
	catch (Exception e){
		e.printStackTrace();
		return null;
		
	}
	}
}

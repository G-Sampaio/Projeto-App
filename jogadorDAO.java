package sublimeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db_pessoas.ConnectionFactory;
import sublime_main.Jogador;

public class jogadorDAO {
	
	public void salvar (Jogador jogador) {
		String sql = "INSERT INTO jogador(nome,nickname) VALUES (?,?)";
		
		Connection conn = null;	
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, jogador.getNome());
			pstm.setString(2, jogador.getNickname());
			pstm.execute();
					
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static List<Jogador> getJogador(){
		String sql = "SELECT * FROM jogador";
		
		List <Jogador> jogadores = new ArrayList<Jogador>();
		Connection conn = null;
		PreparedStatement pstm =null;
		// Recupera os dados do banco **Select**
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()){
				Jogador jogador = new Jogador();
				
				jogador.setNome(rset.getString("nome"));
				jogador.setNickname(rset.getString("nickname"));
				jogadores.add(jogador);
				
				}
			}
			
			catch (Exception e) {
				e.printStackTrace();
				
			}
			
			return jogadores;			
		}
		
	public void	atualizar(Jogador jogador) {

		String sql = "UPDATE jogador SET nome = ?, nickname = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			
			// Valores para atualizar
			
			pstm.setString(1, jogador.getNome());
			pstm.setString(2, jogador.getNickname());
			pstm.setInt(3, jogador.getId());
			
			
			pstm.execute();

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			try {
				if(pstm != null) {
					pstm.close();					
				}
				if(conn != null) {
					conn.close();
				}	
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		}
	}

	public static void deletar (int id) {
		String sql = "DELETE FROM jogador WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static List<Jogador> getJogadorid(int id){
		
		String sql = "SELECT * FROM jogador WHERE id = ?";
		
		List<Jogador> jogadorid = new ArrayList<Jogador>();
		
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			
			while (rset.next()){
				Jogador jogador_id = new Jogador();
				
				jogador_id.setNome(rset.getString("nome"));
				jogador_id.setNickname(rset.getString("nickname"));
				jogadorid.add(jogador_id);
				
				}
			}
			
			catch (Exception e) {
				e.printStackTrace();
				
			}
		
		return jogadorid;
		
	}
}

	
	


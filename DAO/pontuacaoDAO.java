package sublimeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db_pessoas.ConnectionFactory;

import sublime_main.pontuacao;

public class pontuacaoDAO {
	
	public static void salvar_pontuacao (pontuacao Pontuacao) {
		String sql = "insert into pontuacao (nomejgr, nomejg, pontuacao) values (?, ?, ?)";
		
		Connection conn = null;	
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, Pontuacao.getNome_jgr());
			pstm.setString(2, Pontuacao.getNome_jg());
			pstm.setString(3, Pontuacao.getInserir_pontuacao());
			pstm.execute();
					
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
		
	public static List<pontuacao> getMostrarPontuacao(String nome_jgr, String nome_jg) {
	    
		String sql = "SELECT pontuacao\r\n"
	    		+ "FROM pontuacao AS pt\r\n"
	    		+ "JOIN jogador as jgr on pt.nomejgr = jgr.id\r\n"
	    		+ "join jogo as jg on pt.nomejg = jg.id\r\n"
	    		+ "where jgr.nome = ? and jg.nome = ?;";

	    List<pontuacao> pontuacoes = new ArrayList<>();
	    
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    ResultSet rset = null;

	    try {
	        conn = ConnectionFactory.ObtemConexao();
	        pstm = conn.prepareStatement(sql);
	        
	        pstm.setString(1, nome_jgr);
	        pstm.setString(2, nome_jg);
	        
	        rset = pstm.executeQuery();

	        while (rset.next()) {
	        	pontuacao Pontuacao = new pontuacao();

	            Pontuacao.setMostrar_pontuacao(rset.getString("pontuacao"));
	            pontuacoes.add(Pontuacao);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return pontuacoes;		
			
		}
	
}
		
		
	
	
	
	

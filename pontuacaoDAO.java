package sublimeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db_pessoas.ConnectionFactory;
import sublime_main.pontuacao;

public class pontuacaoDAO {
	
	public void salvar_pontuacao (pontuacao Pontuacao) {
		String sql = "INSERT INTO pontuacao(pontuacao) VALUES (?)";
		
		Connection conn = null;	
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, Pontuacao.getInserir_pontuacao());
			pstm.execute();
					
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
}

package sublimeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import db_pessoas.ConnectionFactory;
import sublime_main.Jogo;

public class jogoDAO {
	
	public void salvar_jogo (Jogo jogo) {
		String sql = "INSERT INTO jogo(nome,tema,pontMax) VALUES (?,?,?)";
		
		Connection conn = null;	
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, jogo.getNome_jogo());
			pstm.setString(2, jogo.getTema());
			pstm.setInt(3, jogo.getPontMax());
			pstm.execute();
					
		}
		
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Inválido");
			
		}
	}


	public static List<Jogo> getJogo(){
	String sql = "SELECT * FROM jogo";
	
	List <Jogo> jogo = new ArrayList<Jogo>();
	Connection conn = null;
	PreparedStatement pstm =null;	
	// RECUPERA OS DADOS DO BANCO
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.ObtemConexao();
		pstm = conn.prepareStatement(sql);
		rset = pstm.executeQuery();	
		
		while (rset.next()){
			Jogo jogo_select = new Jogo();
			
			jogo_select.setNome_jogo(rset.getString("nome"));
			jogo_select.setTema(rset.getString("tema"));
			jogo_select.setPontMax(rset.getInt("pontMax"));			
			jogo.add(jogo_select);
			
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return jogo;			
	}

	
	public void	atualizar_jogo(Jogo jogo) {

		String sql = "UPDATE jogo SET nome = ?, Tema = ?, pontMax = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			
			// VALORES PARA ATUALIZAR
			
			pstm.setString(1, jogo.getNome_jogo());
			pstm.setString(2, jogo.getTema());
			pstm.setInt(3, jogo.getPontMax());
			pstm.setInt(4, jogo.getId());
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
	
	
	public static void deletar_jogo (int id) {
		String sql = "DELETE FROM jogo WHERE id = ?";
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
	
	
	public static List<Jogo> getJogoid(Integer busca_id_jogo2){
		
		String sql = "SELECT * FROM jogo WHERE id = ?";
		
		List<Jogo> jogoid = new ArrayList<Jogo>();
		
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.ObtemConexao();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, busca_id_jogo2);
			rset = pstm.executeQuery();
			
			
			while (rset.next()){
				Jogo jogo_id = new Jogo();
				
				jogo_id.setNome_jogo(rset.getString("nome"));
				jogo_id.setTema(rset.getString("tema"));
				jogo_id.setPontMax(rset.getInt("pontMax"));
				jogoid.add(jogo_id);
				}
			}
			
			catch (Exception e) {
				e.printStackTrace();
				
			}
		
		return jogoid;
	}

}